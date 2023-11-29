import javax.swing.*;
import java.awt.*;

// UserMainApp class for the user interface
class UserMainApp extends JFrame {
    public UserMainApp() {
        setTitle("User Main App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Welcome, User!"));

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
