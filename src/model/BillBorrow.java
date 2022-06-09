package model;

import java.time.LocalDate;

public class BillBorrow {
    private String idBill;
    private LocalDate day_Start;
    private int timeBorrow;
    private Reader reader;
    private Employee employee;
    private double freeBorrow;
    private int totalBorrow;
    private BorrowManagement borrowManagement;

    public BillBorrow(String idBill) {
        this.idBill = idBill;
    }

    public BillBorrow(String idBill, LocalDate day_Start, int timeBorrow, Reader reader, Employee employee,
                      double freeBorrow, int totalBorrow, BorrowManagement borrowManagement) {
        this.idBill = idBill;
        this.day_Start = day_Start;
        this.timeBorrow = timeBorrow;
        this.reader = reader;
        this.employee = employee;
        this.freeBorrow = freeBorrow;
        this.totalBorrow = totalBorrow;
        this.borrowManagement = borrowManagement;
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

    public int getTimeBorrow() {
        return timeBorrow;
    }

    public void setTimeBorrow(int timeBorrow) {
        this.timeBorrow = timeBorrow;
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

    public BorrowManagement getBorrowManagement() {
        return borrowManagement;
    }

    public void setBorrowManagement(BorrowManagement borrowManagement) {
        this.borrowManagement = borrowManagement;
    }
}
