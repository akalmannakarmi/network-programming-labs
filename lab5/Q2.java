// Design the following form to illustrate the concept of JPasswordField in java.

import javax.swing.*;
import java.awt.*;

public class Q2 {

    public static void main(String[] args) {
        JFrame f = new JFrame("Password Field Example");

        // Create password field
        JPasswordField value = new JPasswordField();
        value.setBounds(100, 100, 100, 30);

        // Create label
        JLabel l1 = new JLabel("Password:");
        l1.setBounds(20, 100, 80, 30);

        // Add components to frame
        f.add(value);
        f.add(l1);

        // Frame settings
        f.setSize(300, 300);
        f.setLayout(null);  // Manual positioning
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
