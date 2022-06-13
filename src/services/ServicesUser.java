package services;
import io.ReadAndWrite;
import model.User;

import java.util.ArrayList;


public class ServicesUser {
    public static ReadAndWrite<User> readAndWriteUser = new ReadAndWrite<>();
    public static ArrayList<User> list_User = new ArrayList<>();
    {
        list_User = readAndWriteUser.read("listAccount.txt");
    }
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

    public void addUser(User use) {
        list_User.add(use);
        readAndWriteUser.write(list_User, "listAccount.txt");
    }
}
