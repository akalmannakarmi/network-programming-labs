import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q4 {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Login Form");
        frame.setSize(350, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window

        // Username Label
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 30, 80, 25);
        frame.add(userLabel);

        // Username TextField
        JTextField userText = new JTextField();
        userText.setBounds(110, 30, 160, 25);
        frame.add(userText);

        // Password Label
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 70, 80, 25);
        frame.add(passLabel);

        // Password Field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(110, 70, 160, 25);
        frame.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(110, 110, 80, 25);
        frame.add(loginButton);

        // Message Label
        JLabel message = new JLabel();
        message.setBounds(20, 140, 300, 25);
        frame.add(message);

        // Login Button Action
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("1234")) {
                    message.setForeground(Color.GREEN);
                    message.setText("Login successful!");
                } else {
                    message.setForeground(Color.RED);
                    message.setText("Invalid username or password.");
                }
            }
        });

        frame.setVisible(true);
    }
}
