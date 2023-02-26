package view;

import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private final JButton loginButton;
    private final JButton registerButton;
    private final JButton submitButton;
    public static int USER_ID = 0;

    private final JTextField emailField;
    private final JPasswordField passwordField;
    User user;
    UserController userController;

    public Login() {
        setTitle("Login Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(null); // center the window on the screen

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");

        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);


        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        registerButton = new JButton("Sign Up");
        registerButton.addActionListener(this);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(submitButton);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submitButton)) {
            String pass = String.copyValueOf(passwordField.getPassword());
            if (emailField.getText().equals("Email") && passwordField.equals("Password")) {
                JOptionPane.showMessageDialog(null, "Fill all the details");
            } else if (emailField.getText().equals("Email") || passwordField.equals("Password")) {
                JOptionPane.showMessageDialog(null, "One of the box is empty");
            } else {
                userController = new UserController();
                user = userController.loginUser(emailField.getText(),
                        String.copyValueOf(passwordField.getPassword()));
                if (user != null) {
                    new Homepage().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        }

        if (e.getSource().equals(registerButton)) {
            new Register().setVisible(true);
            dispose();
        }

    }
}
