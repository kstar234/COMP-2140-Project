import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusEntry extends JFrame
{
    private JTextField  txtBusID;       
    private JTextField  txtAvailableSeats;
    private JTextField  txtReservedSeats;
    private JTextField  txtDriver;
    private JTextField  txtArrivalTime;
    private JTextField  txtArrivalDate;
    private JTextField  txtBusRoute;
    private JButton     cmdSave;
    private JButton     cmdClose;
    //private JButton     cmdClearAll;

    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private Main         main;
    



    public BusEntry(Main main )
    {
        setTitle("Entering new Bus");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("ID:")); 
        txtBusID = new JTextField(20);
        pnlDisplay.add(txtBusID);
        pnlDisplay.add(new JLabel("AvailableSeats"));
        txtAvailableSeats = new JTextField(20);
        pnlDisplay.add(txtAvailableSeats);
        pnlDisplay.add(new JLabel("ReservedSeats"));
        txtReservedSeats = new JTextField(20);
        pnlDisplay.add(txtReservedSeats);
        pnlDisplay.add(new JLabel("Driver"));
        txtDriver = new JTextField(20);
        pnlDisplay.add(txtDriver);
        pnlDisplay.add(new JLabel("ArrivalTime"));
        txtArrivalTime = new JTextField(20);
        pnlDisplay.add(txtArrivalTime);
        pnlDisplay.add(new JLabel("ArrivalDate"));
        txtArrivalDate = new JTextField(20);
        pnlDisplay.add(txtArrivalDate);
        pnlDisplay.add(new JLabel("BusRoute"));
        txtBusRoute = new JTextField(20);
        pnlDisplay.add(txtBusRoute);
        
        

        pnlDisplay.setLayout(new GridLayout(3,4));



        cmdSave      = new JButton("Save");
        cmdClose   = new JButton("Close");

        pnlCommand.add(cmdSave);
        pnlCommand.add(cmdClose);
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setVisible(true);

        this.main=main;
        cmdClose.addActionListener(new CloseButtonListener());
      //cmdSave.addActionListener(new SaveButtonListener());
    }
       private class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            setVisible(false);
        }
    }
   //private class SaveButtonListener implements ActionListener
    //{
        //public void actionPerformed(ActionEvent s)
        //{

        //}



}