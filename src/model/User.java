package model;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;

    private String passWord;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.passWord = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }
}
