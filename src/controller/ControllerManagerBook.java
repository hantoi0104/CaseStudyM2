package controller;
import conparator.SortByUP;
import services.ServicesManagerBook;;
import view.ManagerBookView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static services.ServicesBorrowManager.list_Book;

public class ControllerManagerBook implements ActionListener {

    private ManagerBookView managerBookView;
    private ServicesManagerBook servicesManagerBook;

    public ControllerManagerBook(ManagerBookView managerBookView) {
        this.managerBookView = managerBookView;
        this.servicesManagerBook = new ServicesManagerBook();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Thêm":
                if (!servicesManagerBook.checkId(managerBookView.getIdBookInput())) {
                    if (managerBookView.checkValidateInput()) {
                        servicesManagerBook.addBook(managerBookView.creatBook());
                        managerBookView.disPlayAllBook(list_Book);
                        managerBookView.clearInputBook();
                    }
                } else {
                    managerBookView.setAlerBook("ID đã tồn tại");
                    managerBookView.clearInputBook();
                }
                break;
            case "Sửa":
                int idEdit = managerBookView.getIdInputSeach();
                int index = servicesManagerBook.getIndex(idEdit);
                servicesManagerBook.editBook(managerBookView.creatBook(), index);
                managerBookView.disPlayAllBook(list_Book);
                managerBookView.clearInputBook();
                break;
            case "Xóa":
                int idDelete = managerBookView.getIdInputSeach();
                int indexDelete = servicesManagerBook.getIndex(idDelete);
                servicesManagerBook.deleteBook(indexDelete);
                managerBookView.disPlayAllBook(list_Book);
                managerBookView.clearInputBook();

                break;
            case "Tìm kiếm":
                managerBookView.setAlerBook("");
                int ID = managerBookView.getIdInputSeach();
                if (servicesManagerBook.checkId(ID)) {
                    managerBookView.displaySearchBook(servicesManagerBook.getIndex(ID), list_Book);
                    System.out.println("tim ok");
                    managerBookView.setInputBook(list_Book.get(servicesManagerBook.getIndex(ID)));
                    System.out.println("tim ok2");
                } else {
                    managerBookView.setAlerBook(" ID không có trong danh sách");
                }
                break;
            case "Tất cả sách":
                managerBookView.disPlayAllBook(list_Book);
                break;
            case "Sắp xếp":
                list_Book.sort(new SortByUP());
                managerBookView.disPlayAllBook(list_Book);
                break;
        }
    }
}
