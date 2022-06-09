package controller;

import model.User;
import services.ServicesUser;
import view.LoginView;
import view.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerRegister implements ActionListener {
    private RegisterView registerView;
    private LoginView loginView;
    private ServicesUser servicesUser;

    public ControllerRegister(RegisterView registerView) {
        this.registerView = registerView;
        this.servicesUser = new ServicesUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Register")) {
            Boolean checkValiDateInput = registerView.checkValiDateInput();
            if (checkValiDateInput) {
                registerView.setAlerRegister("chuẩn bị được thêm");

                if (registerView.checkConfirmPassWord()) {
                    User user = registerView.createUse();
                    if (!servicesUser.checkAccountRegister(user)) {
                        servicesUser.addToList(user);
                        registerView.setAlerRegister("Đăng ký thành công");
                        registerView.clearInputRegister();
                    } else {
                        registerView.setAlerRegister("Tài khoản đã tồn tại ");
                        registerView.clearInputRegister();
                    }
                } else {
                    registerView.setAlerRegister("Nhập sai mật khẩu");
                    registerView.clearInputPassWord();
                }
            }
        } else {
            this.registerView.closeView();
            loginView = new LoginView();
        }
    }
}