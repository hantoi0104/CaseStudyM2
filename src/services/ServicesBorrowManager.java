package services;

import io.ReadAndWrite;
import model.*;

import java.util.ArrayList;

public class ServicesBorrowManager {
public static ReadAndWrite<Book> readAndWriteBook = new ReadAndWrite<>();
public static ReadAndWrite <Employee> readAndWriteEmployee = new ReadAndWrite<>();
public static ReadAndWrite <Reader> readAndWriteReader = new ReadAndWrite<>();
public static ReadAndWrite <BillBorrow> readAndWriteBill = new ReadAndWrite<>();
public static ReadAndWrite <BookBorrowManagement> readAndWriteBBM = new ReadAndWrite<>();
public static ArrayList<Book> list_Book = new ArrayList<>();
public static ArrayList<Employee> list_Employee = new ArrayList<>();
public static ArrayList<Reader> list_Reader = new ArrayList<>();
public static ArrayList<BillBorrow> list_BillBorrow = new ArrayList<>();
public static ArrayList<BookBorrowManagement> list_ManagerBookBorrow = new ArrayList<>();

    {
        list_Book = readAndWriteBook.read("listBook.txt");
        list_Reader = readAndWriteReader.read("listReader.txt");
        list_Employee= readAndWriteEmployee.read("listEmployee.txt");
        list_BillBorrow = readAndWriteBill.read("listBill.txt");
        list_ManagerBookBorrow = readAndWriteBBM.read("listManagerBookBorrow.txt");
    }


    public void searchNameBook(String nameBook){
        for (int i = 0; i < list_Book.size(); i++) {
            if(list_Book.get(i).getName().equals(nameBook))
                list_Book.add(list_Book.get(i));
        }
    }

    public void addBill(BillBorrow billBorrow) {
        list_BillBorrow.add(billBorrow);
        readAndWriteBill.write(list_BillBorrow, "listBill.txt");
    }
    public void addBBM(BookBorrowManagement bbm) {
       list_ManagerBookBorrow.add(bbm);
        readAndWriteBBM.write(list_ManagerBookBorrow, "listManagerBookBorrow.txt");
    }

    public int getIndexBill(String idBill) {
        for (int i = 0; i < list_BillBorrow.size(); i++) {
            if (list_BillBorrow.get(i).getIdBill().equals(idBill))
                return i;
        }
        return -1;
    }

    public Boolean checkIdBill(String idBill) {
        for (int i = 0; i < list_BillBorrow.size(); i++) {
            if (list_BillBorrow.get(i).getIdBill().equals(idBill))
                return true;
        }
        return false;
    }

    public Boolean checkIdReader(int id) {
        for (int i = 0; i < list_Reader.size(); i++) {
            if (list_Reader.get(i).getIdReader() == id)
                return true;
        }
        return false;
    }
    public Boolean checkIdEmployee(int id) {
        for (int i = 0; i < list_Employee.size(); i++) {
            if (list_Employee.get(i).getIdEmployee() == id)
                return true;
        }
        return false;
    }


}
