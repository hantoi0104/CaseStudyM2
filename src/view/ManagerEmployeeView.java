package view;

import controller.ControllerManagerEmployee;
import model.Book;
import model.Employee;
import services.Validate;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManagerEmployeeView extends JFrame {
    private JPanel mainEmployeePanel;
    private JButton seachEmployeeButton;
    private JTable tableEmployee;
    private JTextField inputCmndEmployee;
    private JTextField inputDateEmployee;
    private JTextField inputNameEmployee;
    private JTextField inputAddressEmployee;
    private JTextField inputGenderEmployee;
    private JTextField inputIDEmployee;
    private JTextField inputPossEmployee;
    private JButton addEmployeeButton;
    private JButton editEmployeeButton;
    private JButton deleteEmployeeButton;
    private JButton allEmployeeButton;
    private JButton sortEmployeeButton;
    private JTextField inputPartEmployee;
    private JTextField inputSearchID;
    private JLabel alerEmployee;


    public ManagerEmployeeView() {
        this.setContentPane(mainEmployeePanel);
        this.setTitle("Quản lý nhân viên  ");
        this.setSize(500, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        ControllerManagerEmployee ac = new ControllerManagerEmployee(this);
        addEmployeeButton.addActionListener(ac);
        editEmployeeButton.addActionListener(ac);
        deleteEmployeeButton.addActionListener(ac);
        seachEmployeeButton.addActionListener(ac);
        allEmployeeButton.addActionListener(ac);
        sortEmployeeButton.addActionListener(ac);

    }

    public static void main(String[] args) {
        ManagerEmployeeView managerEmployeeView = new ManagerEmployeeView();
    }


    public Employee creatEmployee() {
        String name = inputNameEmployee.getText();
        int cmnd = Integer.parseInt(inputCmndEmployee.getText());
        LocalDate date = LocalDate.parse(inputDateEmployee.getText());
        String address = inputAddressEmployee.getText();
        String gender = inputGenderEmployee.getText();
        int idEmployee = Integer.parseInt(inputIDEmployee.getText());
        String poss = inputPossEmployee.getText();
        String part = inputPartEmployee.getText();
        return new Employee(cmnd, name, date, address, gender, idEmployee, poss, part);
    }

    public void clearInputEmployee() {
        inputIDEmployee.setText("");
        inputNameEmployee.setText("");
        inputCmndEmployee.setText("");
        inputAddressEmployee.setText("");
        inputDateEmployee.setText("");
        inputGenderEmployee.setText("");
        inputPartEmployee.setText("");
        inputPartEmployee.setText("");
    }

    public int getIdInputSearch() {
        return Integer.parseInt(inputSearchID.getText());
    }

    public int getIdInputEmployee() {
        return Integer.parseInt(inputIDEmployee.getText());
    }

    public void clearInputSearch() {
        inputSearchID.setText("");
    }

    public void setInputEmployee(Employee employee) {
        inputNameEmployee.setText(employee.getCmnd() + "");
        inputCmndEmployee.setText(employee.getName());
        inputDateEmployee.setText(employee.getDateOfBirth() + "");
        inputAddressEmployee.setText(employee.getAddress() + "");
        inputGenderEmployee.setText(employee.getGender());
        inputIDEmployee.setText(employee.getIdEmployee() + "");
        inputPossEmployee.setText(employee.getPosition());
        inputPartEmployee.setText(employee.getPart());
    }


    public void setAlerEmployee(String str) {
        alerEmployee.setText(str);
    }

    public Boolean checkValidateInputIDSearch() {
        if (Validate.validateIdBook(inputSearchID.getText())) {
            return true;
        } else {
            inputSearchID.setText("");
            return false;
        }
    }

//    public Boolean checkValidateInput() {
//        if (Validate.validateNameBook(inputBookName.getText())) {
//            if (Validate.validateIdBook(inputBookID.getText())) {
//                if (Validate.validateAuthorBook(inputBookAuthor.getText())) {
//                    if (Validate.validateYearBook(inputBookYear.getText())) {
//                        if (Validate.validateQuantityBook(inputBookQuantity.getText())) {
//                            if (Validate.validateTypeBook(inputBookType.getText()))
//                                return true;
//                            else {
//                                setAlerBook(" Tên loại sách a-z A-Z độ dài từ 3 - 20 ký tự");
//                                inputBookType.setText("");
//                                return false;
//                            }
//                        } else {
//                            setAlerBook("Số lượng có độ dài từ 1-3 chữ số");
//                            inputBookQuantity.setText("");
//                            return false;
//                        }
//                    } else {
//                        setAlerBook("Năm có độ dài 4 chữ số, bắt đầu từ số 1");
//                        inputBookYear.setText("");
//                        return false;
//                    }
//                } else {
//                    setAlerBook("Tên tác giả a-z A-Z, dài hơn 3 ký tự");
//                    inputBookAuthor.setText("");
//                    return false;
//                }
//            } else {
//                setAlerBook("ID là số có độ dài từ 1-5 chữ số");
//                inputBookID.setText("");
//                return false;
//            }
//        } else {
//            setAlerBook("Tên sách a-z, A-Z, dài hơn 3 ký tự");
//            inputBookName.setText("");
//            return false;
//        }
//
//    }

    public void styleTable() {
        TableColumnModel colums = tableEmployee.getColumnModel();
        colums.getColumn(0).setMinWidth(90);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 1; i < 6; i++) {
            colums.getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    public void disPlayAllEmployee(ArrayList<Employee> employees) {
        DefaultTableModel model = new DefaultTableModel();
        String[] array = {"Name", "CMND", "Date", "Address", "Gender", "ID", " Position", " Part"};
        for (int i = 0; i < array.length; i++) {
            model.addColumn(array[i]);
        }
        for (Employee x : employees) {
            model.addRow(new Object[]{x.getName(), x.getCmnd(), x.getDateOfBirth(), x.getAddress(),
                    x.getGender(), x.getIdEmployee(), x.getPosition(), x.getPart()});
        }
        tableEmployee.setModel(model);
        styleTable();
    }

    public void displaySearchEmployee(int index, ArrayList<Employee> list) {
        DefaultTableModel model = new DefaultTableModel();
        String[] array = {"Name", "CMND", "Date", "Address", "Gender", "ID", " Position", " Part"};
        for (int i = 0; i < array.length; i++) {
            model.addColumn(array[i]);
        }
        model.addRow(new Object[]{list.get(index).getName(), list.get(index).getCmnd(), list.get(index).getDateOfBirth(),
                list.get(index).getAddress(), list.get(index).getGender(), list.get(index).getIdEmployee(),
                list.get(index).getPosition(), list.get(index).getPart()});
       tableEmployee.setModel(model);
        styleTable();
    }
}
