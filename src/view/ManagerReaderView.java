package view;

import controller.ControllerManagerReader;
import model.Book;
import model.Employee;
import model.Reader;
import services.Validate;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManagerReaderView extends JFrame {
    private JPanel mainReaderPanel;
    private JTextField inputSeachIDReader;
    private JButton searchReaderButton;
    private JTable tableReader;
    private JTextField inputNameReader;
    private JTextField inputCmndReader;
    private JTextField inputDateReader;
    private JTextField inputGenderReader;
    private JTextField inputIdReader;
    private JButton addReaderButton;
    private JButton editReaderButton;
    private JButton deleteReaderButton;
    private JButton allReaderButton;
    private JButton sortReaderButton;
    private JTextField inputPhoneReader;
    private JTextField inputEmailReader;
    private JTextField inputAddressReader;
    private JLabel alerReader;

    public ManagerReaderView() {
        this.setContentPane(mainReaderPanel);
        this.setTitle("Quản lý đối tượng bạn đọc ");
        this.setSize(500, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        ControllerManagerReader ac = new ControllerManagerReader(this);
        addReaderButton.addActionListener(ac);
        editReaderButton.addActionListener(ac);
        deleteReaderButton.addActionListener(ac);
        searchReaderButton.addActionListener(ac);
        sortReaderButton.addActionListener(ac);
        allReaderButton.addActionListener(ac);

    }

    public Reader creatReader() {
        String nameReader = inputNameReader.getText();
        int cmnd = Integer.parseInt(inputCmndReader.getText());
        LocalDate date = LocalDate.parse((inputDateReader.getText() + ""));
        String address = inputAddressReader.getText();
        String gender = inputGenderReader.getText();
        int idReader = Integer.parseInt(inputIdReader.getText());
        String email = inputEmailReader.getText();
        int phone = Integer.parseInt(inputPhoneReader.getText());
        return new Reader(cmnd, nameReader, date, address, gender, idReader, phone, email);
    }

    public void clearInputReader() {
        inputDateReader.setText("");
        inputAddressReader.setText("");
        inputGenderReader.setText("");
        inputEmailReader.setText("");
        inputPhoneReader.setText("");
        inputIdReader.setText("");
        inputNameReader.setText("");
        inputCmndReader.setText("");

    }

    public int getIdSeachReader() {
        return Integer.parseInt(inputSeachIDReader.getText());
    }

    public int getIdReaderInput() {
        return Integer.parseInt(inputIdReader.getText());
    }

    public void clearInputSeach() {
        inputSeachIDReader.setText("");
    }

    public void setInputReader(Reader reader) {
        inputNameReader.setText(reader.getName());
        inputCmndReader.setText(reader.getCmnd() + "");
        inputAddressReader.setText(reader.getAddress());
        inputGenderReader.setText(reader.getGender());
        inputIdReader.setText(reader.getIdReader() + "");
        inputPhoneReader.setText(reader.getPhoneNumber() + "");
        inputEmailReader.setText(reader.getEmail());
        inputDateReader.setText(reader.getDateOfBirth()+"");
    }


    public void setAlerReader(String str) {
        alerReader.setText(str);
    }


    public Boolean checkValidateInputSearch() {
        if (Validate.validateIdBook(inputIdReader.getText())) {
            return true;
        } else {
           inputIdReader.setText("");
            return false;
        }
    }


    public void styleTable() {
        TableColumnModel colums = tableReader.getColumnModel();
        colums.getColumn(0).setMinWidth(95);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 1; i < 6; i++) {
            colums.getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    public void disPlayAllReader(ArrayList<Reader> readers) {
        DefaultTableModel model = new DefaultTableModel();
        String[] array_Title = {"Name", "CMND", "Date", "Address", "Gender", "ID", " Phone", " Email"};
        for (int i = 0; i < array_Title.length; i++) {
            model.addColumn(array_Title[i]);
        }
        for (Reader x : readers ) {
            model.addRow(new Object[]{x.getName(), x.getCmnd(), x.getDateOfBirth(), x.getAddress(),
                    x.getGender(), x.getIdReader(), x.getPhoneNumber(), x.getEmail()});
        }
        tableReader.setModel(model);
        styleTable();
    }

    public void displaySearchReader(int index, ArrayList<Reader> list) {
        DefaultTableModel model = new DefaultTableModel();
        String[] array = {"Name", "CMND", "Date", "Address", "Gender", "ID", " Phone", " Email"};
        for (int i = 0; i < array.length; i++) {
            model.addColumn(array[i]);
        }
        model.addRow(new Object[]{list.get(index).getName(), list.get(index).getCmnd(), list.get(index).getDateOfBirth(),
                list.get(index).getAddress(), list.get(index).getGender(), list.get(index).getIdReader(),
                list.get(index).getPhoneNumber(), list.get(index).getEmail()});
        tableReader.setModel(model);
        styleTable();
    }



}
