import javax.swing.*;
import java.awt.*;

// AdminMainApp class for the admin interface
class AdminMainApp extends JFrame {
    public AdminMainApp() {
        setTitle("Admin Main App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Welcome, Admin!"));

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
