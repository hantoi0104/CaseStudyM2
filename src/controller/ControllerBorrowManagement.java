package controller;

import services.ServicesBorrowManager;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static services.ServicesBorrowManager.*;


public class ControllerBorrowManagement implements ActionListener {

    private BorrowManagementView borrowManagementView;
    private ServicesBorrowManager servicesBorrowManager;

    public ControllerBorrowManagement(BorrowManagementView borrowManagementView) {
        this.borrowManagementView = borrowManagementView;
        this.servicesBorrowManager = new ServicesBorrowManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        switch (str) {
            case "Thêm KH mới":
                ManagerReaderView managerReaderView = new ManagerReaderView();
                System.out.println("kh ok");
                break;
            case "Thêm sách mới":
                ManagerBookView managerBookView = new ManagerBookView();
                System.out.println("saCHS OK");
                break;
            case "Thêm nhân viên":
                System.out.println("nhanh vien ok");
                ManagerEmployeeView managerEmployeeView = new ManagerEmployeeView();
                break;
            case "Tìm sách":
                String nameBookSearch = borrowManagementView.getnameSearchBook();
                borrowManagementView.disPlayBookSearch(nameBookSearch);
                borrowManagementView.clearInputSearchNameBook();
                break;
            case "Tất cả":
                borrowManagementView.disPlayAllBook(list_Book);
                break;
            case "Thuê":

                if (servicesBorrowManager.checkIdReader(borrowManagementView.getIdReader())) {
                    if (servicesBorrowManager.checkIdEmployee(borrowManagementView.getIdEmployee())) {
                        if (borrowManagementView.checkEmptyTotalBookBorrow()) {
                            if (!servicesBorrowManager.checkIdBill(borrowManagementView.getIdBill().trim())) {
                                System.out.println("thuê ok");
                                servicesBorrowManager.addBill(borrowManagementView.createBill());
                                servicesBorrowManager.addBBM(borrowManagementView.createBookBorrowManagement());
                                System.out.println("bill OK");
                                borrowManagementView.setQuantityBook();
                                readAndWriteBook.write(list_Book, "listBook.txt");
                                borrowManagementView.disPlayAllBook(list_Book);
                                borrowManagementView.setAlerBorrow("Thuê thành công");
                                borrowManagementView.clearInputBookBorrow();
                                System.out.println("thuê thành công");
                            } else {
                                borrowManagementView.clearIdBill();
                                borrowManagementView.setAlerBorrow(" Mã hóa đơn đã tồn tại");
                            }
                        } else {
                            borrowManagementView.clearInputBookBorrow();
                        }
                    } else {
                        borrowManagementView.setAlerBorrow("ID nhân viên không tồn tại");
                        borrowManagementView.clearIdEmployee();
                    }
                } else {
                    borrowManagementView.setAlerBorrow("ID khách hàng không tông tại");
                    borrowManagementView.clearIdReader();
                }
                break;
            case "Tính tiền":
                if (servicesBorrowManager.checkIdBill(borrowManagementView.getIdMoneyInput().trim())) {
                    int indexBill = borrowManagementView.getIndexMoneyBill(borrowManagementView.getIdMoneyInput());
                    borrowManagementView.setAlerBorrow("");
                    borrowManagementView.displayBillBorrow(indexBill, list_BillBorrow);
                    borrowManagementView.showTotalMoney(indexBill);
                    System.out.println("tính tiền ok");
                    borrowManagementView.setOutPutBill();
                    borrowManagementView.setQuantityReBook();
                    borrowManagementView.disPlayAllBook(list_Book);
                    readAndWriteBook.write(list_Book, "listBook.txt");
                } else {
                    borrowManagementView.cleanIdMoneyInput();
                    borrowManagementView.setAlerBorrow("Mã hóa đơn không đúng");
                }
                break;
            case "Tất cả Bill":
                borrowManagementView.displayAllBillBorrow(list_BillBorrow);
                break;
        }

    }
}
