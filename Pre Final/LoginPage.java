import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * LoginPage class provides a simple login interface.
 * Users must enter the correct username and password to proceed.
 */
public class LoginPage implements ActionListener {

    private JFrame frame;
    private JPanel panel1, panel2;
    private JLabel loginLabel, passwordLabel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    
    // Predefined username and password for authentication
    private static final String USERNAME = "jisoo";
    private static final String PASSWORD = "flower_me";

    /**
     * Constructor initializes the login page UI.
     */
    public LoginPage() {
        // Set up frame properties
        frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel for input fields
        panel1 = new JPanel(new GridLayout(2, 2, 10, 10));
        
        loginLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        loginField = new JTextField();
        passwordField = new JPasswordField();

        // Add components to panel
        panel1.add(loginLabel);
        panel1.add(loginField);
        panel1.add(passwordLabel);
        panel1.add(passwordField);
        frame.add(panel1, BorderLayout.CENTER);

        // Panel for login button
        panel2 = new JPanel();
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        panel2.add(loginBtn);
        frame.add(panel2, BorderLayout.SOUTH);

        // Set frame size and visibility
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Handles login button click event.
     * Validates user input and displays appropriate messages.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginBtn)) {
            // Get user input
            String username = loginField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            // Check login credentials
            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                System.out.println("Login Successful");
                new DataPage(); // Navigate to the data page
                frame.dispose();
            } else {
                System.out.println("Login Fail");
            }
        }
    }

    /**
     * Main method to run the login page.
     */
    public static void main(String[] args) {
        new LoginPage();
    }
}
