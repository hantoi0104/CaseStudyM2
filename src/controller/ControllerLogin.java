package controller;

import services.ServicesUser;
import view.BorrowManagementView;
import view.LoginView;
import view.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static services.ServicesUser.list_User;


public class ControllerLogin implements ActionListener {
    private LoginView loginView;
    private RegisterView registerView;
    private ServicesUser servicesUser;

    public ControllerLogin(LoginView loginView) {
        this.loginView = loginView;
        this.servicesUser = new ServicesUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Login")) {
            System.out.println(this.loginView.getUser().getUserName());
            System.out.println(this.loginView.getUser().getPassword());
            if (servicesUser.checkAccountLogin(loginView.getUser())) {
                list_User.add(loginView.getUser());
                new BorrowManagementView();
                loginView.closeView();

            } else {
                loginView.setAlertLogin("Tài khoản không tồn tại");
                loginView.clearInputLogin();
            }

        } else {
            this.loginView.closeView();
            registerView = new RegisterView();
        }
    }


}
