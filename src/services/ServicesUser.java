package services;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class ServicesUser {
    public static List<User> list_User = new ArrayList<>();

    public Boolean checkAccountLogin(User user) {
        for (User x : list_User) {
            if (x.getUserName().equals(user.getUserName()) && x.getPassword().equals(user.getPassword()))
                return true;
        }
        return false;
    }

    public Boolean checkAccountRegister(User user) {
        for (User x : list_User) {
            if (x.getUserName().equals(user.getUserName()))
                return true;
        }
        return false;
    }

    public boolean checkConfirmPassWord(String pass, String c_Pass) {
        if (pass.equals(c_Pass))
            return true;
        else return false;
    }

    public void addToList(User use) {
        list_User.add(use);
    }
}
