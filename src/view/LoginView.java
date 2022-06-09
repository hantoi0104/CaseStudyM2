package view;

import controller.ControllerLogin;
import model.User;

import javax.swing.*;

public class LoginView extends JFrame {

    private JTextField userNameField1;
    private JPasswordField passWordField1;
    private JButton loginButton;
    private JPanel loginPanel;
    private JButton registerButton;
    private JLabel alertLogin;


    public LoginView() {
        this.setContentPane(loginPanel);
        this.setTitle("Đăng nhập tài khoản");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        ControllerLogin ac = new ControllerLogin(this);
        loginButton.addActionListener(ac);
        registerButton.addActionListener(ac);
    }

    public void closeView() {
        this.setVisible(false);
    }

    public User getUser() {
        String userName = userNameField1.getText();
        String passWord = passWordField1.getText();
        return new User(userName, passWord);
    }

    public void setAlertLogin(String str) {
        alertLogin.setText(str);

    }

    public void clearInputLogin()
    {
        userNameField1.setText("");
        passWordField1.setText("");
    }

}
