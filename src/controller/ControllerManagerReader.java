package controller;

import conparator.SorByIDReader;
import conparator.SortByIDEmployee;
import services.ServicesManagerReader;
import view.ManagerReaderView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static services.ServicesBorrowManager.list_Reader;

public class ControllerManagerReader implements ActionListener {
    private ManagerReaderView managerReaderView;
    private ServicesManagerReader servicesManagerReader;

    public ControllerManagerReader(ManagerReaderView managerReaderView) {
        this.managerReaderView = managerReaderView;
        this.servicesManagerReader = new ServicesManagerReader();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Thêm":
                if (!servicesManagerReader.checkId(managerReaderView.getIdReaderInput())) {
                    servicesManagerReader.addReader(managerReaderView.creatReader());
                    managerReaderView.disPlayAllReader(list_Reader);
                    managerReaderView.clearInputReader();
                } else {
                    managerReaderView.setAlerReader("ID đã tồn tại");
                    managerReaderView.clearInputReader();
                }

                break;
            case "Sửa":
                int idEdit = managerReaderView.getIdSeachReader();
                int index = servicesManagerReader.getIndex(idEdit);
                servicesManagerReader.editReader(managerReaderView.creatReader(), index);
                managerReaderView.disPlayAllReader(list_Reader);
                managerReaderView.clearInputReader();
                break;
            case "Xóa":

                int idDelete = managerReaderView.getIdSeachReader();
                int indexDelete = servicesManagerReader.getIndex(idDelete);
                servicesManagerReader.deleteReader(indexDelete);
                managerReaderView.disPlayAllReader(list_Reader);
                managerReaderView.clearInputReader();
                break;
            case "Sắp xếp ID":
                list_Reader.sort(new SorByIDReader());
                managerReaderView.disPlayAllReader(list_Reader);
                break;
            case "Tìm":
              managerReaderView.setAlerReader("");
                int ID = managerReaderView.getIdSeachReader();
                if (servicesManagerReader.checkId(ID)) {
                    managerReaderView.displaySearchReader(servicesManagerReader.getIndex(ID), list_Reader);
                  managerReaderView.setInputReader(list_Reader.get(servicesManagerReader.getIndex(ID)));
                } else {
                    managerReaderView.setAlerReader(" ID không có trong danh sách");
                }

                break;
            case "Tất cả":
               managerReaderView.disPlayAllReader(list_Reader);
                break;


        }
    }
}

