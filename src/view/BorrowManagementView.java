package view;

import controller.ControllerBorrowManagement;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.time.LocalDate;
import java.util.ArrayList;

import static services.ServicesBorrowManager.*;

public class BorrowManagementView extends JFrame {

    private JPanel mainManager;
    private JTextField idBook2Input;
    private JTextField idBillGetMoneyInput;
    private JTable tableShowBill;
    private JTable tableShowBook;
    private JTextField idReaderInput;
    private JTextField dateStartInput;
    private JTextField quantityBorrowInput;
    private JButton managerReaderButton;
    private JButton managerBookButton;
    private JButton managerEmployeeButton;
    private JTextField freeInput;
    private JTextField idEmpoyeeInput;
    private JTextField idBillInput;
    private JTextField idBook1Input;
    private JTextField quantityBook1Input;
    private JTextField quantityBook2Input;
    private JPasswordField sdjfj;
    private JTextField quantityBook3Input;
    private JTextField totalDateInput;
    private JButton borrowButton;
    private JButton takeMoneyButton;
    private JTextField searchBookNameInput;
    private JButton searchBookNameButton;
    private JScrollPane ScrollPanel;
    private JScrollPane tableShowManagerBook;
    private JTextField totalMoneyInput;
    private JButton allBookButton;
    private JTextField idBook3Input;
    private JLabel alerBorrow;
    private JTextField re_totalMoneyInput;
    private JButton allBillButton;

    public BorrowManagementView() {
        this.setContentPane(mainManager);
        this.setTitle("Chương trình quản lý cho thuê sách");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        ControllerBorrowManagement ac = new ControllerBorrowManagement(this);
        managerBookButton.addActionListener(ac);
        managerEmployeeButton.addActionListener(ac);
        managerReaderButton.addActionListener(ac);
        allBookButton.addActionListener(ac);
        searchBookNameButton.addActionListener(ac);
        borrowButton.addActionListener(ac);
        takeMoneyButton.addActionListener(ac);
        allBillButton.addActionListener(ac);

    }

    public String getnameSearchBook() {
        return searchBookNameInput.getText().trim();
    }

    public int getIdReader() {
        return Integer.parseInt(idReaderInput.getText());
    }

    public int getIdEmployee() {
        return Integer.parseInt(idEmpoyeeInput.getText());
    }

    public void disPlayBookSearch(String nameBook) {
        DefaultTableModel model = new DefaultTableModel();
        String[] array_colum = {"Name", "ID", "Author", "Type", "Year", "Quantity", "Empty", "Status"};
        for (int i = 0; i < array_colum.length; i++) {
            model.addColumn(array_colum[i]);
        }
        for (Book x : list_Book) {
            if (x.getName().equals(nameBook))
                model.addRow(new Object[]{x.getName(), x.getId(), x.getAuthor(), x.getType(), x.getYear(), x.getQuantity(), x.getEmpty(), x.getStatus()});
        }
        tableShowBook.setModel(model);
        styleTable();

    }


    public void disPlayAllBook(ArrayList<Book> books) {
        DefaultTableModel model = new DefaultTableModel();
        String[] array_colum = {"Name", "ID", "Author", "Type", "Year", "Quantity", "Empty", "Status"};
        for (int i = 0; i < array_colum.length; i++) {
            model.addColumn(array_colum[i]);
        }
        for (Book x : books) {
            model.addRow(new Object[]{x.getName(), x.getId(), x.getAuthor(), x.getType(), x.getYear(), x.getQuantity(), x.getEmpty(), x.getStatus()});
        }
        tableShowBook.setModel(model);
//        tableShowBook.setFont(new Font("Serif",Font.PLAIN, 12));
        styleTable();


    }

    public void styleTable() {
        TableColumnModel colums = tableShowBook.getColumnModel();
        colums.getColumn(0).setMinWidth(90);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 1; i < 8; i++) {
            if (i == 2)
                continue;
            colums.getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    public Reader getReader(int id) {
        for (int i = 0; i < list_Reader.size(); i++) {
            if (list_Reader.get(i).getIdReader() == id)
                return list_Reader.get(i);
        }
        return null;
    }

    public Employee getEmployee(int id) {
        for (int i = 0; i < list_Employee.size(); i++) {
            if (list_Employee.get(i).getIdEmployee() == id)
                return list_Employee.get(i);
        }
        return null;
    }


    public void clearInputSearchNameBook() {
        searchBookNameInput.setText("");
    }

    public void clearInputBorrow() {
        quantityBook1Input.setText("");
        idBook1Input.setText("");
        idBook2Input.setText("");
        idBook3Input.setText("");
        quantityBook3Input.setText("");
        quantityBook2Input.setText("");
        idReaderInput.setText("");
        idBillInput.setText("");
        dateStartInput.setText("");
        idEmpoyeeInput.setText("");
        freeInput.setText("");
    }


    public BookBorrowManagement createBookBorrowManagement() {
        Book book1 = getBook(Integer.parseInt(idBook1Input.getText()));
        Book book2 = getBook(Integer.parseInt(idBook2Input.getText()));
        Book book3 = getBook(Integer.parseInt(idBook3Input.getText()));
        int quantity1 = Integer.parseInt(quantityBook1Input.getText());
        int quantity2 = Integer.parseInt(quantityBook2Input.getText());
        int quantity3 = Integer.parseInt(quantityBook3Input.getText());
        Reader reader = getReader(Integer.parseInt(idReaderInput.getText()));
        return new BookBorrowManagement(book1, book2, book3, quantity1, quantity2, quantity3, reader);
    }


    public BillBorrow createBill() {
        String idBill = idBillInput.getText();
        LocalDate dateStart = LocalDate.parse(dateStartInput.getText());
        Reader reader = getReader(Integer.parseInt(idReaderInput.getText()));
        Employee employee = getEmployee(Integer.parseInt(idEmpoyeeInput.getText()));
        double freeBorrow = Double.parseDouble(freeInput.getText());
        int totalBorrow = Integer.parseInt(quantityBook1Input.getText()) + Integer.parseInt(quantityBook2Input.getText()) +
                Integer.parseInt(quantityBook3Input.getText());
        BookBorrowManagement bookBorrowManagement = createBookBorrowManagement();


        return new BillBorrow(idBill, dateStart, reader, employee, freeBorrow, totalBorrow, bookBorrowManagement);
    }

    public String getIdBill() {
        return idBillInput.getText();
    }

    public void setAlerBorrow(String str) {
        alerBorrow.setText(str);
    }

    public Book getBook(int id) {
        for (int i = 0; i < list_Book.size(); i++) {
            if (list_Book.get(i).getId() == id)
                return list_Book.get(i);
        }
        return null;
    }

    public boolean checkBookEmpty(Book book, int quantityBorrow) {
        if (book.getEmpty() >= quantityBorrow)
            return true;
        else return false;
    }

    public Boolean checkEmptyTotalBookBorrow() {
        int idBook1 = Integer.parseInt(idBook1Input.getText());
        int idBook2 = Integer.parseInt(idBook1Input.getText());
        int idBook3 = Integer.parseInt(idBook1Input.getText());
        if (getBook(idBook1) == null || getBook(idBook2) == null || getBook(idBook3) == null) {
            setAlerBorrow("Nhập ID sách sai");
            return false;
        } else {
            if (checkBookEmpty(getBook(idBook1), Integer.parseInt(quantityBook1Input.getText())))
                if (checkBookEmpty(getBook(idBook2), Integer.parseInt(quantityBook2Input.getText())))
                    if (checkBookEmpty(getBook(idBook3), Integer.parseInt(quantityBook3Input.getText())))
                        return true;
                    else {
                        setAlerBorrow("Sách " + getBook(idBook3).getName() + " Không đủ số lượng cho thuê");
                        return false;
                    }
                else {
                    setAlerBorrow("Sách " + getBook(idBook2).getName() + " Không đủ số lượng cho thuê");
                    return false;
                }
            else {
                setAlerBorrow("Sách " + getBook(idBook1).getName() + " Không đủ số lượng cho thuê");
                return false;
            }
        }
    }

    public void clearInputBookBorrow() {
        idBook1Input.setText("");
        quantityBook1Input.setText("");
        idBook2Input.setText("");
        quantityBook2Input.setText("");
        idBook3Input.setText("");
        quantityBook3Input.setText("");
        idBillInput.setText("");
        dateStartInput.setText("");
        quantityBorrowInput.setText("");
        idEmpoyeeInput.setText("");
        freeInput.setText("");
        idReaderInput.setText("");


    }

    public void clearIdBill() {
        idBillInput.setText("");
    }

    public void clearIdReader() {
        idReaderInput.setText("");
    }

    public void clearIdEmployee() {
        idEmpoyeeInput.setText("");
    }

    public int getIndex(int id) {
        for (int i = 0; i < list_Book.size(); i++) {
            if (list_Book.get(i).getId() == id)
                return i;
        }
        return -1;
    }
    //    list_Book.get(0).setEmpty(15);

    public void setQuantityBook() {
        int indexBook1 = getIndex(Integer.parseInt(idBook1Input.getText()));
        int indexBook2 = getIndex(Integer.parseInt(idBook2Input.getText()));
        int indexBook3 = getIndex(Integer.parseInt(idBook3Input.getText()));
        list_Book.get(indexBook1).setEmpty(list_Book.get(indexBook1).getQuantity() - Integer.parseInt(quantityBook1Input.getText()));
        System.out.println("ok1");
        list_Book.get(indexBook2).setEmpty(list_Book.get(indexBook2).getQuantity() - Integer.parseInt(quantityBook2Input.getText()));
        System.out.println("ok2");
        list_Book.get(indexBook3).setEmpty(list_Book.get(indexBook3).getQuantity() - Integer.parseInt(quantityBook3Input.getText()));
        System.out.println("ok3");

    }

    public void setQuantityReBook() {
        int indexBill = getIndexMoneyBill(idBillGetMoneyInput.getText().trim());
        BillBorrow billBorrow = list_BillBorrow.get(indexBill);
        int idBook1 = billBorrow.getBorrowManagement().getBook1().getId();
        int idBook2 = billBorrow.getBorrowManagement().getBook2().getId();
        int idBook3 = billBorrow.getBorrowManagement().getBook3().getId();
        int quantityBook1 = billBorrow.getBorrowManagement().getQuantity1();
        int quantityBook2 = billBorrow.getBorrowManagement().getQuantity2();
        int quantityBook3 = billBorrow.getBorrowManagement().getQuantity3();
        list_Book.get(getIndex(idBook1)).setEmpty(list_Book.get(getIndex(idBook1)).getEmpty()+quantityBook1 );
        list_Book.get(getIndex(idBook2)).setEmpty(list_Book.get(getIndex(idBook2)).getEmpty()+quantityBook2 );
        list_Book.get(getIndex(idBook3)).setEmpty(list_Book.get(getIndex(idBook3)).getEmpty()+quantityBook3 );

    }

    public String getIdMoneyInput() {
        return idBillGetMoneyInput.getText();
    }

    public void cleanIdMoneyInput() {
        idBillGetMoneyInput.setText("");
    }

    public void displayBillBorrow(int index, ArrayList<BillBorrow> list) {
        DefaultTableModel modelBill = new DefaultTableModel();
        String[] array_colum = {"IdBill", "Day", "Reader", "Employee", "Free", "Total"};
        for (int i = 0; i < array_colum.length; i++) {
            modelBill.addColumn(array_colum[i]);
        }
        modelBill.addRow(new Object[]{list.get(index).getIdBill(), list.get(index).getDay_Start(),
                list.get(index).getReader().getName(), list.get(index).getEmployee().getIdEmployee(),
                list.get(index).getFreeBorrow(), list.get(index).getTotalBorrow()});
        tableShowBill.setModel(modelBill);
        styleTableShowBill();
    }

    public void displayAllBillBorrow(ArrayList<BillBorrow> list) {
        DefaultTableModel modelAllBill = new DefaultTableModel();
        String[] array_colum = {"IdBill", "Day", "Reader", "Employee", "Free", "Total"};
        for (int i = 0; i < array_colum.length; i++) {
            modelAllBill.addColumn(array_colum[i]);
        }
        for (BillBorrow x : list_BillBorrow) {
            modelAllBill.addRow(new Object[]{x.getIdBill(), x.getDay_Start(), x.getReader().getName(),
                    x.getEmployee().getIdEmployee(),
                    x.getFreeBorrow(), x.getTotalBorrow()});
        }

        tableShowBill.setModel(modelAllBill);
        styleTableShowBill();
    }

    public void styleTableShowBill() {
        TableColumnModel colum = tableShowBill.getColumnModel();
//        colum.getColumn(0).setMinWidth(50);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < 6; i++) {
            colum.getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    public int getIndexMoneyBill(String id) {
        for (int i = 0; i < list_BillBorrow.size(); i++) {
            if (list_BillBorrow.get(i).getIdBill().equals(id))
                return i;
        }
        return -1;
    }

    public int getTimeBorrow() {
        return Integer.parseInt(totalDateInput.getText());
    }

    public void showTotalMoney(int indexBill) {
        double totalMoney = Integer.parseInt(totalDateInput.getText()) * 2000 * list_BillBorrow.get(indexBill).getTotalBorrow();
        totalMoneyInput.setText(totalMoney + "");
        double re_totalMoney = list_BillBorrow.get(indexBill).getFreeBorrow() - totalMoney;
        re_totalMoneyInput.setText(re_totalMoney + "");
    }


    public void setOutPutBill() {
        int indexBill = getIndexMoneyBill(idBillGetMoneyInput.getText().trim());
        BillBorrow billBorrow = list_BillBorrow.get(indexBill);
        idReaderInput.setText(billBorrow.getReader().getIdReader() + "");
        idBillInput.setText(billBorrow.getIdBill());
        idEmpoyeeInput.setText(billBorrow.getEmployee().getIdEmployee() + "");
        dateStartInput.setText(billBorrow.getDay_Start() + "");
        quantityBorrowInput.setText(billBorrow.getBorrowManagement().getTotal() + "");
        freeInput.setText(billBorrow.getFreeBorrow() + "");
        idBook1Input.setText(billBorrow.getBorrowManagement().getBook1().getId() + "");
        idBook2Input.setText(billBorrow.getBorrowManagement().getBook2().getId() + "");
        idBook3Input.setText(billBorrow.getBorrowManagement().getBook3().getId() + "");
        quantityBook1Input.setText(billBorrow.getBorrowManagement().getQuantity1() + "");
        quantityBook2Input.setText(billBorrow.getBorrowManagement().getQuantity2() + "");
        quantityBook3Input.setText(billBorrow.getBorrowManagement().getQuantity3() + "");

    }

}

