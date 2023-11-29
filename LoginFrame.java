import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// LoginFrame class for the login interface
class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private List<User> userList;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userList = new ArrayList<>();
        userList.add(new User("admin", "adminpass", true));
        userList.add(new User("user", "userpass", false));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void authenticateUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                openMainApp(user.isAdmin());
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void openMainApp(boolean isAdmin) {
        dispose(); // Close the login frame

        // Open the main application frame based on user role
        if (isAdmin) {
            new AdminMainApp();
        } else {
            new UserMainApp();
        }
    }
}

