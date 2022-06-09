package view;

import controller.ControllerLogin;
import controller.ControllerRegister;
import model.User;
import services.Validate;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {
    private JPanel registerPanel;
    private JTextField inputName;
    private JTextField inputEmail;
    private JTextField inputAddress;
    private JPasswordField inputpassword;
    private JPasswordField inputConfirmPassword;
    private JButton confirmRegisterViewButton;
    private JButton loginRegisterViewButtom;
    private JLabel register;
    private JTextField inputUserName;
    private JLabel alerRegister;


    public RegisterView() {
        this.setContentPane(registerPanel);
        this.setTitle("Đăng ký tài khoản");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        ControllerRegister ac = new ControllerRegister(this);
        confirmRegisterViewButton.addActionListener(ac);
        loginRegisterViewButtom.addActionListener(ac);
    }

    public void closeView() {
        this.setVisible(false);
    }

    public User createUse() {
            String useName = inputUserName.getText();
            String passWord = inputpassword.getText();
            return new User(useName, passWord);
    }

    public void setAlerRegister(String str) {
        alerRegister.setText(str);
    }

    public void clearInputRegister() {
        inputUserName.setText("");
        inputpassword.setText("");
        inputConfirmPassword.setText("");
    }

    public void clearInputPassWord() {
        inputpassword.setText("");
        inputConfirmPassword.setText("");
    }

    public boolean checkConfirmPassWord() {
        if (inputpassword.getText().equals(inputConfirmPassword.getText()))
            return true;
        else return false;
    }

    public boolean checkValiDateInput() {
        if (Validate.validateUserName(inputUserName.getText())) {
            if (Validate.validatePassword(inputpassword.getText()))
                return true;
            else {
                setAlerRegister("PassWord phải từ 8-10 ký tự, các ký tự từ a-z, 0-9");
                clearInputPassWord();
                return false;
            }
        } else {
            setAlerRegister(("UserName phải tử 5-10, các ký tự từ a-z, 0-9"));
            inputUserName.setText("");
            return false;
        }
    }

    public static void main(String[] args) {
        RegisterView registerView = new RegisterView();
    }
}
