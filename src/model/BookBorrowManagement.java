package model;

import java.io.Serializable;

public class BookBorrowManagement implements Serializable {
    private Book book1;
    private Book book2;
    private Book book3;
    private int quantity1;
    private int quantity2;
    private int quantity3;
    private int total;
    private Reader reader;
    private String state;

    public BookBorrowManagement() {
    }

    public BookBorrowManagement(Book book1, Book book2, Book book3, int quantity1,
                                int quantity2, int quantity3, Reader reader) {
        this.book1 = book1;
        this.book2 = book2;
        this.book3 = book3;
        this.quantity1 = quantity1;
        this.quantity2 = quantity2;
        this.quantity3 = quantity3;
        this.reader = reader;
        this.state = "New";
        this.total = this.quantity1 + this.quantity2 + this.quantity3;
    }

    public Book getBook1() {
        return book1;
    }

    public void setBook1(Book book1) {
        this.book1 = book1;
    }

    public Book getBook2() {
        return book2;
    }

    public void setBook2(Book book2) {
        this.book2 = book2;
    }

    public Book getBook3() {
        return book3;
    }

    public void setBook3(Book book3) {
        this.book3 = book3;
    }

    public int getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(int quantity1) {
        this.quantity1 = quantity1;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(int quantity2) {
        this.quantity2 = quantity2;
    }

    public int getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(int quantity3) {
        this.quantity3 = quantity3;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}

