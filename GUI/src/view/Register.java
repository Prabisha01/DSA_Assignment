package view;

import controller.UserController;
import model.User;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Register extends JFrame implements ActionListener {
    private final JButton loginButton;
    private final JButton registerButton;
    private final JButton submitButton;
    private final JTextField emailField, fNameField, LNameField;
    private final JPasswordField passwordField, confirmField;


    public Register() {
        setTitle("Registration Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(null); // center the window on the screen

        JPanel panel = new JPanel(new GridLayout(12, 2));
        JLabel FirstLabel = new JLabel("First Name:");
        JLabel LastLabel = new JLabel("Last Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel passwordLabel2 = new JLabel(" Confirm Password:");
        LNameField = new JTextField(20);
        fNameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confirmField =new JPasswordField(20);
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
        panel.add(FirstLabel);
        panel.add(fNameField);
        panel.add(LastLabel);
        panel.add(LNameField);
        panel.add(passwordLabel2);
        panel.add(confirmField);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        panel.add(submitButton);
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submitButton)) {
            String fname = fNameField.getText();
            String lname = LNameField.getText();
            String email = emailField.getText();
            String pass = String.copyValueOf(passwordField.getPassword());
            String cpass = String.copyValueOf(confirmField.getPassword());

            if (fname.equals("First Name") && lname.equals("Last Name") && email.equals("Email") && pass.equals("Password") && cpass.equals("Confirm Password")) {
                JOptionPane.showMessageDialog(null, "All fields are required.");
            } else if (fname.equals("First Name")) {
                JOptionPane.showMessageDialog(null, "First name is required.");

            } else if (lname.equals("Last Name")) {
                JOptionPane.showMessageDialog(null, "Last name is required.");
            } else if (email.equals("Email")) {
                JOptionPane.showMessageDialog(null, "Password is required.");
            } else if (pass.equals("Password") || cpass.equals("Confirm Password")) {
                JOptionPane.showMessageDialog(null, "Password is required.");
            } else if (pass.length() < 6) {
                JOptionPane.showMessageDialog(null, "Password should be more than 6 characters!");
            } else if (pass.equals(cpass)) {
                JOptionPane.showMessageDialog(null, "Confirming..");

                try {


                            User user = new User(fname,lname,email,pass);
                            UserController userController = new UserController();
                            int insert = userController.userRegister(user);

                            if (insert > 0) {
                                JOptionPane.showMessageDialog(null, "Account registered\n Directing to Login");
                                new Login().setVisible(true);
                                dispose();
                            } else
                                JOptionPane.showMessageDialog(null, "Failed to Register");

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "The account cannot be created at the moment\nPlease try again later");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Your passwords do not match");
                confirmField.requestFocus();
            }

            }
            if (e.getSource().equals(loginButton)) {
                new Login().setVisible(true);
                dispose();
            }
        }
    }

