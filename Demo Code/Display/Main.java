import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends JPanel {
    private JButton cmdAddBus;
    private JButton cmdClose;
    private JPanel pnlCommand;
    private JPanel pnlDisplay;
    private ArrayList<Bus> blist;
    private JTable table;
    private DefaultTableModel model;
    private JTextField  txtBusID;       
    private JTextField  txtAvailableSeats;
    private JTextField  txtReservedSeats;
    private JTextField  txtDriver;
    private JTextField  txtArrivalTime;
    private JTextField  txtArrivalDate;
    private JTextField  txtBusRoute;
    private JTextField txtSelectedBusID;

    public Main() {
        super(new GridLayout(2, 1));
        //super(new BorderLayout());

        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();

        blist = loadBus("Bus.dat");
        String[] columnNames = {"Bus ID", "Available Seats", "Reserved Seats", "Driver", "Arrival Time", "Arrival Date", "BusRoute"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        showTable();

        table.setPreferredScrollableViewportSize(new Dimension(500, blist.size() * 15 + 50));
        table.setFillsViewportHeight(true);
        table.setBackground(Color.white);

        

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        cmdAddBus = new JButton("Add Bus");
        cmdClose = new JButton("Close");

        cmdAddBus.setBackground(Color.PINK);
        cmdClose.setBackground(Color.PINK);

        cmdClose.addActionListener(new CloseButtonListener());
        cmdAddBus.addActionListener(new AddBusButtonListener());

        pnlCommand.add(cmdAddBus);
        pnlCommand.add(cmdClose);
        //add(pnlCommand);
        //add(pnlCommand,BorderLayout.SOUTH);
        //add(pnlCommand,GridLayout.SOUTH);
        add(pnlCommand);


        JPanel pnlRegister = new JPanel();
        txtSelectedBusID = new JTextField(10);
        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new RegisterButtonListener());

        pnlRegister.add(new JLabel("Bus ID:"));
        pnlRegister.add(txtSelectedBusID);
        pnlRegister.add(btnRegister);
        //add(pnlRegister, BorderLayout.NORTH);
        //add(pnlRegister, GridLayout.NORTH);
        add(pnlRegister);

        // Initialize text fields for displaying selected bus info
        txtBusID = new JTextField(20);
        txtAvailableSeats = new JTextField(20);
        txtReservedSeats = new JTextField(20);
        txtArrivalDate = new JTextField(20);
        txtArrivalTime = new JTextField(20);
        txtDriver = new JTextField(20);
        txtBusRoute = new JTextField(20);

        pnlDisplay.add(new JLabel("Bus ID"));
        pnlDisplay.add(txtBusID);
        pnlDisplay.add(new JLabel("Available Seats"));
        pnlDisplay.add(txtAvailableSeats);
        pnlDisplay.add(new JLabel("Reserved Seats"));
        pnlDisplay.add(txtReservedSeats);
        pnlDisplay.add(new JLabel("Arrival Date"));
        pnlDisplay.add(txtArrivalDate);
        pnlDisplay.add(new JLabel("Arrival Time"));
        pnlDisplay.add(txtArrivalTime);
        pnlDisplay.add(new JLabel("Driver"));
        pnlDisplay.add(txtDriver);
        pnlDisplay.add(new JLabel("BusRoute"));
        pnlDisplay.add(txtBusRoute);
        // Add other labels and text fields for other bus info...

        add(pnlDisplay);

        // Add row selection listener to the table
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new BusSelectionListener());
    }


    private class BusSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    displaySelectedBusInfo(selectedRow);
                }
            }
        }
    }
    
    private class RegisterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedBusID = txtSelectedBusID.getText();

            // Find the selected bus in the ArrayList
            Bus selectedBus = null;
            for (Bus bus : blist) {
                if (String.valueOf(bus.getBusID()).equals(selectedBusID)) {
                    selectedBus = bus;
                    break;
                }
            }

            if (selectedBus != null && selectedBus.getAvailableSeats() > 0) {
                // Decrement available seats and increment reserved seats
                selectedBus.setAvailableSeats(selectedBus.getAvailableSeats() - 1);
                selectedBus.setReservedSeats(selectedBus.getReservedSeats() + 1);

                // Update the table with the modified seat counts
                updateTable();

                // Optionally, display a message or perform other actions upon successful registration
                JOptionPane.showMessageDialog(Main.this, "Registration successful!");
            } else {
                JOptionPane.showMessageDialog(Main.this, "Invalid Bus ID or no available seats!");
            }
        }
    }

    private void displaySelectedBusInfo(int selectedRow) {
        String busID = (String) table.getValueAt(selectedRow, 0);
        String availableSeats = (String) table.getValueAt(selectedRow, 1);
        String reservedSeats = (String) table.getValueAt(selectedRow, 2);
        String driver = (String) table.getValueAt(selectedRow, 3);
        String arrivalTime = (String) table.getValueAt(selectedRow, 4);
        String arrivalDate = (String) table.getValueAt(selectedRow, 5);
        String busRoute = (String) table.getValueAt(selectedRow, 6);

       txtBusID.setText(busID);
       txtAvailableSeats.setText(availableSeats);
       txtReservedSeats.setText(reservedSeats);
       txtDriver.setText(driver);
       txtArrivalTime.setText(arrivalTime);
       txtArrivalDate.setText(arrivalDate);
       txtBusRoute.setText(busRoute);
}

private void updateTable() {
    // Clear the table model and re-populate it with the updated seat counts
    model.setRowCount(0); // Clear the table

    for (Bus b : blist) {
        addToTable(b);
    }
}
   
    private void showTable() {
        for (Bus b : blist) {
            addToTable(b);
        }
    }

    private void addToTable(Bus b) {
        String[] item = {
            String.valueOf(b.getBusID()),
            String.valueOf(b.getAvailableSeats()),                   
            String.valueOf(b.getReservedSeats()),
            b.getDriver(),
            b.getArrivalTime(),
            b.getArrivalDate(),
            b.getBusRoute()
        };
        model.addRow(item);
    }


    private ArrayList<Bus> loadBus(String bfile) {
        Scanner bscan = null;
        ArrayList<Bus> blist = new ArrayList<>();
        try {
            bscan = new Scanner(new File(bfile));
            while (bscan.hasNext()) {
                String[] nextLine = bscan.nextLine().split(","); // Assuming data is comma-separated
                int busID = Integer.parseInt(nextLine[0]);
                int availableSeats = Integer.parseInt(nextLine[1]);
                int reservedSeats = Integer.parseInt(nextLine[2]);
                String driver = nextLine[3];
                String arrivalTime = nextLine[4];
                String arrivalDate = nextLine[5];
                String busRoute = nextLine[6];
                Bus b = new Bus(busID, availableSeats, reservedSeats, driver, arrivalTime, arrivalDate, busRoute);
                blist.add(b);
            }
            bscan.close();
        } catch (IOException e) {
            e.printStackTrace(); // Handle this exception properly in your application
        }
        return blist;
    }

    private class CloseButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class AddBusButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // Implement logic to add a new bus entry
            BusEntry busEntry = new BusEntry(Main.this);
        }
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("List of buses");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Main newContentPane = new Main();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}

