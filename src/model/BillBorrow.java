package model;

import java.io.Serializable;
import java.time.LocalDate;

public class BillBorrow implements Serializable {
    private String idBill;
    private LocalDate day_Start;
    private Reader reader;
    private Employee employee;
    private double freeBorrow;
    private int totalBorrow;
    private BookBorrowManagement listBookBorrowManagement;
    private int timeBorrow;
    private Double totalMoney;

    public BillBorrow(String idBill) {
        this.idBill = idBill;
    }

    public BillBorrow(String idBill, LocalDate day_Start, Reader reader, Employee employee,
                      double freeBorrow, int totalBorrow, BookBorrowManagement listBookBorrowManagement) {
        this.idBill = idBill;
        this.day_Start = day_Start;
        this.reader = reader;
        this.employee = employee;
        this.freeBorrow = freeBorrow;
        this.totalBorrow = totalBorrow;
        this.listBookBorrowManagement = listBookBorrowManagement;
        this.timeBorrow = 0;
        this.totalBorrow = 0;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public LocalDate getDay_Start() {
        return day_Start;
    }

    public void setDay_Start(LocalDate day_Start) {
        this.day_Start = day_Start;
    }


    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getFreeBorrow() {
        return freeBorrow;
    }

    public void setFreeBorrow(double freeBorrow) {
        this.freeBorrow = freeBorrow;
    }

    public int getTotalBorrow() {
        return totalBorrow;
    }

    public void setTotalBorrow(int totalBorrow) {
        this.totalBorrow = totalBorrow;
    }

    public BookBorrowManagement getBorrowManagement() {
        return listBookBorrowManagement;
    }

    public void setBorrowManagement(BookBorrowManagement listBookBorrowManagement) {
        this.listBookBorrowManagement = listBookBorrowManagement;
    }
}
