package view;

import controller.ControllerManagerBook;
import controller.ControllerRegister;

import javax.swing.*;

public class ManagerBookView extends JFrame {
    private JPanel mainBookView;
    private JTextField inputSearchId;
    private JButton seachIDButton;
    private JTextField inputBookName;
    private JTextField inputBookID;
    private JTextField inputBookAuthor;
    private JTextField InputBookYear;
    private JTable table1;
    private JTextField inputBookType;
    private JTextField inputBookQuantity;
    private JButton addButton;
    private JButton allBookButton;
    private JButton sortButton;
    private JButton editButton;
    private JButton deleteButton;

    public ManagerBookView() {
        this.setContentPane(mainBookView);
        this.setTitle("Quản lý ");
        this.setSize(500, 450);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        ControllerManagerBook ac = new ControllerManagerBook(this);
       addButton.addActionListener(ac);
       editButton.addActionListener(ac);
       addButton.addActionListener(ac);
       addButton.addActionListener(ac);
       addButton.addActionListener(ac);

    }

    public static void main(String[] args) {
        ManagerBookView managerBookView = new ManagerBookView();
    }
}

