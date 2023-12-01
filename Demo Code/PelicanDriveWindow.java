import javax.swing.*;
import java.awt.*;

public class PelicanDriveWindow {
    public static void main(String[] args) {
        // Create a JFrame (window)
        JFrame frame = new JFrame("Pelican Drive");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200); // Set the window size
        frame.setLayout(new BorderLayout()); // Use BorderLayout for positioning components

        // Create a label for the heading
        JLabel headingLabel = new JLabel("Pelican Drive");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font and size for the heading
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center-align the heading

        // Create buttons for Sign-up and Login
        JButton signUpButton = new JButton("Sign-up");
        JButton loginButton = new JButton("Login");

        // Create a panel for holding the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Use FlowLayout for button arrangement
        buttonPanel.add(signUpButton);
        buttonPanel.add(loginButton);

        // Add components to the frame
        frame.add(headingLabel, BorderLayout.NORTH); // Add heading label to the top of the frame
        frame.add(buttonPanel, BorderLayout.CENTER); // Add button panel to the center of the frame

        

        // Set the frame visibility to true
        frame.setVisible(true);
    }
}
