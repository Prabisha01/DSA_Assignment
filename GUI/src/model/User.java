package model;

import javax.swing.*;

public class User {
    private int userId;
    private String fName;
    private String lName;
    private String email;
    private String password;

    public User(){}

    public User(String fName, String lName, String email, String password){
        this.fName=fName;
        this.lName=lName;
        this.email=email;
        this.password=password;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
