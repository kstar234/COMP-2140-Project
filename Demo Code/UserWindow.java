import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserWindow extends JFrame {
    private JTable table;

    public UserWindow() {
        setTitle("Pelican Drive Admin Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Create a panel for the top section (label and logout button)
        JPanel topPanel = new JPanel(new BorderLayout());

        // Create a label for the title
        JLabel titleLabel = new JLabel("Fleet Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Create a logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            // Implement logout functionality here
            // For example: close the current window
            dispose();
        });
        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        logoutPanel.add(logoutButton);
        topPanel.add(logoutPanel, BorderLayout.EAST);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Create panel for buttons
        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.EAST);

        // Create table for bus fleet
        JPanel tablePanel = createTablePanel();
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton addButton = new JButton("Add Bus");
        JButton removeButton = new JButton("Remove Bus");
        JButton editButton = new JButton("Edit Bus");

        // Add action listeners for buttons (implement your logic here)

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);

        return buttonPanel;
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());

        String[] columnNames = {"Bus ID", "Route", "Available Seats", "Departure Time", "EST Arrival Time"};
        Object[][] data = {
                {"1", "Route 1", 20, "08:00 AM", "12:00 PM"},
                {"2", "Route 2", 15, "09:30 AM", "01:30 PM"},
                // Add sample data or implement your data retrieval logic here
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Center-align cell content
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        tablePanel.add(scrollPane, BorderLayout.CENTER);

        return tablePanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminWindow adminWindow = new AdminWindow();
            adminWindow.setVisible(true);
        });
    }
}
