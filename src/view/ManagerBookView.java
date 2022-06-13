package view;

import controller.ControllerManagerBook;
import model.Book;
import services.Validate;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;

public class ManagerBookView extends JFrame {
    private JPanel mainBookView;
    private JTextField inputSearchId;
    private JButton seachIDButton;
    private JTextField inputBookName;
    private JTextField inputBookID;
    private JTextField inputBookAuthor;
    private JTextField inputBookYear;
    private JTable tableDisplayBook;
    private JTextField inputBookType;
    private JTextField inputBookQuantity;
    private JButton addButton;
    private JButton allBookButton;
    private JButton sortButton;
    private JButton editButton;
    private JButton deleteButton;
    private JLabel alerBook;

    public ManagerBookView() {
        this.setContentPane(mainBookView);
        this.setTitle("Quản lý danh mục sách ");
        this.setSize(500, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        ControllerManagerBook ac = new ControllerManagerBook(this);
       addButton.addActionListener(ac);
       editButton.addActionListener(ac);
       deleteButton.addActionListener(ac);
       seachIDButton.addActionListener(ac);
       sortButton.addActionListener(ac);
       allBookButton.addActionListener(ac);

    }



    public Book creatBook() {
        String bookName = inputBookName.getText();
        String bookAuthor = inputBookAuthor.getText();
        int bookYear = Integer.parseInt(inputBookYear.getText() + "");
        int bookId = Integer.parseInt(inputBookID.getText() + "");
        int bookQuantity = Integer.parseInt(inputBookQuantity.getText() + "");
        String bookType = inputBookType.getText();
        return new Book(bookName, bookAuthor, bookYear, bookQuantity, bookId, bookType);
    }

    public void clearInputBook() {
        inputBookID.setText("");
        inputBookName.setText("");
        inputBookAuthor.setText("");
        inputBookQuantity.setText("");
        inputBookYear.setText("");
        inputBookType.setText("");
    }

    public int getIdInputSeach() {
        return Integer.parseInt(inputSearchId.getText());
    }
    public int getIdBookInput() {
        return Integer.parseInt(inputBookID.getText());
    }

    public void clearInputSeach() {
       inputSearchId.setText("");
    }

    public void setInputBook(Book book) {
        inputBookID.setText(book.getId() + "");
        inputBookName.setText(book.getName());
        inputBookAuthor.setText(book.getAuthor());
        inputBookQuantity.setText(book.getQuantity() + "");
        inputBookYear.setText(book.getYear() + "");
        inputBookType.setText(book.getType());
    }


    public void setAlerBook(String str) {
        alerBook.setText(str);
    }


    public Boolean checkValidateInputSearch() {
        if (Validate.validateIdBook(inputSearchId.getText())){
            return true;
        }
        else {
            inputSearchId.setText("");
            return false;
        }
    }

    public Boolean checkValidateInput() {
        if (Validate.validateNameBook(inputBookName.getText())) {
            if (Validate.validateIdBook(inputBookID.getText())) {
                if (Validate.validateAuthorBook(inputBookAuthor.getText())) {
                    if (Validate.validateYearBook(inputBookYear.getText())) {
                        if (Validate.validateQuantityBook(inputBookQuantity.getText())) {
                            if (Validate.validateTypeBook(inputBookType.getText()))
                                return true;
                            else {
                                setAlerBook(" Tên loại sách a-z A-Z độ dài từ 3 - 20 ký tự");
                                inputBookType.setText("");
                                return false;
                            }
                        } else {
                            setAlerBook("Số lượng có độ dài từ 1-3 chữ số");
                            inputBookQuantity.setText("");
                            return false;
                        }
                    } else {
                        setAlerBook("Năm có độ dài 4 chữ số, bắt đầu từ số 1");
                        inputBookYear.setText("");
                        return false;
                    }
                } else {
                    setAlerBook("Tên tác giả a-z A-Z, dài hơn 3 ký tự");
                    inputBookAuthor.setText("");
                    return false;
                }
            } else {
                setAlerBook("ID là số có độ dài từ 1-5 chữ số");
                inputBookID.setText("");
                return false;
            }
        } else {
            setAlerBook("Tên sách a-z, A-Z, dài hơn 3 ký tự");
            inputBookName.setText("");
            return false;
        }

    }

    public void styleTable() {
        TableColumnModel colums = tableDisplayBook.getColumnModel();
        colums.getColumn(0).setMinWidth(90);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 1; i < 6; i++) {
            colums.getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    public void disPlayAllBook(ArrayList<Book> books) {
        DefaultTableModel model = new DefaultTableModel();
        String[] array_colum = {"Name", "ID", "Author", "Type", "Year", "Quantity"};
        for (int i = 0; i < array_colum.length; i++) {
            model.addColumn(array_colum[i]);
        }
        for (Book x : books) {
            model.addRow(new Object[]{x.getName(), x.getId(), x.getAuthor(), x.getType(), x.getYear(), x.getQuantity()});
        }
        tableDisplayBook.setModel(model);
        styleTable();
        for (Book x: books
             ) {
            System.out.println(x);
        }

    }

    public void displaySearchBook(int index, ArrayList<Book> list) {
        DefaultTableModel model = new DefaultTableModel();
        String[] array_colum = {"Name", "ID", "Author", "Year", "Type", "Quantity"};
        for (int i = 0; i < array_colum.length; i++) {
            model.addColumn(array_colum[i]);
        }
        model.addRow(new Object[]{list.get(index).getName(), list.get(index).getId(),
                list.get(index).getAuthor(), list.get(index).getType(),
                list.get(index).getYear(), list.get(index).getQuantity()});
        tableDisplayBook.setModel(model);
        styleTable();
    }

    public static void main(String[] args) {
        ManagerBookView managerBookView = new ManagerBookView();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

