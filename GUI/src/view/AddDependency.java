package view;

import controller.DependencyController;
import controller.JobController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.Login.USER_ID;

public class AddDependency extends JFrame implements ActionListener {
    JButton adddependencybutton,cancelbutton,logoutbutton;
    JTextField field;
    JLabel label;
    ImageIcon cancel = new ImageIcon("Public\\cancel.png");
    ImageIcon logout = new ImageIcon("Public\\Logoutb.png");
    AddDependency(){
        uI();
        labels();
        Field();
        addDependencyButton();
        setLayout(null);
        setVisible(true);
        handleAction();
    }
    void uI(){
        setTitle("Add Job");
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(250, 10, 489, 650);
        setBackground(Color.decode(("#EBEBEB")));
    }
    void addDependencyButton(){
        adddependencybutton = new Base.Button("Insert", 18, 250, 340, 180, 40);
        add(adddependencybutton);
    }
    void labels() {
        label= new Base.Label("Dependency","Poppins",18,10,160,150,40);
        add(label);
    }
    void Field(){
        field= new Base.TextField("Enter the dependency",18,10,200,450,40);
        add(field);
    }
    void handleAction(){
//        cancelbutton.addActionListener(this);
        adddependencybutton.addActionListener(this);
//        logoutbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String dependencyName=field.getText();
        if (e.getSource().equals(logoutbutton)) {
            int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                new Login().setVisible(true);
                dispose();
            }
        }
        if (e.getSource().equals(cancelbutton)) {
            int reply = JOptionPane.showConfirmDialog(this, "The dependency cannot be saved if cancelled.", "Cancel", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                new JobDesc().setVisible(true);
                dispose();
            }
        }
        if (e.getSource().equals(adddependencybutton)) {
            if(dependencyName=="Enter the dependency"||dependencyName==""){
            }
            else {
                DependencyController dependencyController = new DependencyController();
                dependencyController.addDependency(USER_ID,dependencyName);}
            new JobDesc().setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new AddDependency().setVisible(true);
    }
}
