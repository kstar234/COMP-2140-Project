import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginSignupFrame extends JFrame {
    private JTextField loginEmailField, signupUsernameField, signupEmailField;
    private JPasswordField loginPassField, signupPassField;
    private JButton loginBtn, signupBtn;

    public LoginSignupFrame() {
        setTitle("Login/Signup Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));

        JLabel titleLabel = new JLabel("Welcome, Administrator!");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        signupBtn = new JButton("Sign-up");
        signupBtn.addActionListener(e -> {
            // Add logout functionality here
            JOptionPane.showMessageDialog(null, "Logging out...");
            // For demonstration, simply close the window
            dispose();
        });

        loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> {
            // Add logout functionality here
            JOptionPane.showMessageDialog(this, "Logging out...");
            // For demonstration, simply close the window
            dispose();
        });

        add(signupBtn, BorderLayout.SOUTH);
        add(loginBtn, BorderLayout.SOUTH);

        // JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        // JLabel loginEmailLabel = new JLabel("Email:");
        // JLabel loginPassLabel = new JLabel("Password:");
        // loginEmailField = new JTextField();
        // loginPassField = new JPasswordField();
        // loginBtn = new JButton("Login");

        // loginBtn.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         // Handle login logic here
        //         String email = loginEmailField.getText();
        //         String password = String.valueOf(loginPassField.getPassword());
        //         // Validate credentials
        //         // Perform login authentication
        //         JOptionPane.showMessageDialog(null, "Login clicked with Email: " + email + " Password: " + password);
        //     }
        // });

        // loginPanel.add(loginEmailLabel);
        // loginPanel.add(loginEmailField);
        // loginPanel.add(loginPassLabel);
        // loginPanel.add(loginPassField);
        // loginPanel.add(new JLabel()); // Blank label for alignment
        // loginPanel.add(loginBtn);

        // JPanel signupPanel = new JPanel(new GridLayout(4, 2));
        // JLabel signupUsernameLabel = new JLabel("Username:");
        // JLabel signupEmailLabel = new JLabel("Email:");
        // JLabel signupPassLabel = new JLabel("Password:");
        // signupUsernameField = new JTextField();
        // signupEmailField = new JTextField();
        // signupPassField = new JPasswordField();
        // signupBtn = new JButton("Signup");

        // signupBtn.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         // Handle signup logic here
        //         String username = signupUsernameField.getText();
        //         String email = signupEmailField.getText();
        //         String password = String.valueOf(signupPassField.getPassword());
        //         // Validate signup data
        //         // Perform signup operation
        //         JOptionPane.showMessageDialog(null, "Signup clicked with Username: " + username + " Email: " + email + " Password: " + password);
        //     }
        // });

        // signupPanel.add(signupUsernameLabel);
        // signupPanel.add(signupUsernameField);
        // signupPanel.add(signupEmailLabel);
        // signupPanel.add(signupEmailField);
        // signupPanel.add(signupPassLabel);
        // signupPanel.add(signupPassField);
        // signupPanel.add(new JLabel()); // Blank label for alignment
        // signupPanel.add(signupBtn);

        // add(loginPanel);
        // add(new JSeparator(JSeparator.HORIZONTAL));
        // add(signupPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginSignupFrame();
            }
        });
    }
}
