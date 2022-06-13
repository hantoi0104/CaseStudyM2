package controller;
import conparator.SortByIDEmployee;
import services.ServicesManagerEmployee;
import view.ManagerEmployeeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static services.ServicesBorrowManager.list_Employee;


public class ControllerManagerEmployee implements ActionListener {
    private ManagerEmployeeView managerEmployeeView;
    private ServicesManagerEmployee servicesManagerEmployee;

    public ControllerManagerEmployee(ManagerEmployeeView managerEmployeeView) {
        this.managerEmployeeView = managerEmployeeView;
        this.servicesManagerEmployee = new ServicesManagerEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Thêm":
                if( !servicesManagerEmployee.checkId(managerEmployeeView.getIdInputEmployee())){
                    servicesManagerEmployee.addEmployee(managerEmployeeView.creatEmployee());
                    managerEmployeeView.creatEmployee();
                    System.out.println(managerEmployeeView.creatEmployee());
                    managerEmployeeView.disPlayAllEmployee(list_Employee);
                    managerEmployeeView.clearInputEmployee();
                }
                else {
                   managerEmployeeView.setAlerEmployee("ID đã tồn tại");
                    managerEmployeeView.clearInputEmployee();
                }

                break;
            case "Sửa":
                int idEdit = managerEmployeeView.getIdInputSearch();
                int index = servicesManagerEmployee.getIndex(idEdit);
                servicesManagerEmployee.editEmployee(managerEmployeeView.creatEmployee(), index);
               managerEmployeeView.disPlayAllEmployee(list_Employee);
                managerEmployeeView.clearInputEmployee();

                break;
            case "Xóa":

                int idDelete = managerEmployeeView.getIdInputSearch();
                int indexDelete = servicesManagerEmployee.getIndex(idDelete);
               servicesManagerEmployee.deleteEmployee(indexDelete);
                managerEmployeeView.disPlayAllEmployee(list_Employee);
                managerEmployeeView.clearInputEmployee();
                break;
            case "Sắp xếp ID":
                list_Employee.sort(new SortByIDEmployee());
               managerEmployeeView.disPlayAllEmployee(list_Employee);
                break;
            case "Tìm ID":
                managerEmployeeView.setAlerEmployee("");
                int ID = managerEmployeeView.getIdInputSearch();
                if (servicesManagerEmployee.checkId(ID)) {
                    managerEmployeeView.displaySearchEmployee(servicesManagerEmployee.getIndex(ID), list_Employee);
                   managerEmployeeView.setInputEmployee(list_Employee.get(servicesManagerEmployee.getIndex(ID)));
                } else {
                    managerEmployeeView.setAlerEmployee(" ID không có trong danh sách");
                }

                break;
            case "Tất cả":
                System.out.println("hdsfhsdfhdsfgdsfgds");
                managerEmployeeView.disPlayAllEmployee(list_Employee);
                break;


        }
    }
}