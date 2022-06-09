package controller;

import view.ManagerBookView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerManagerBook implements ActionListener {

    private ManagerBookView managerBookView;

    public ControllerManagerBook(ManagerBookView managerBookView) {
        this.managerBookView = managerBookView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
