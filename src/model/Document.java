package model;

import java.io.Serializable;

public class Document implements Serializable {
    private String name;
    private String author;
    private int year;
    private int quantity;

    public Document() {
    }

    public Document(String name, String author, int year, int quantity) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
