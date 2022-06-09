package model;

import java.io.Serializable;

public class Book extends Document{
    private int id;
    private String type;
    private int empty;
    private String status;

    public Book() {
    }

    public Book(String name, String author, int year, int quantity, int id, String type) {
        super(name, author, year, quantity);
        this.id = id;
        this.type = type;
        this. empty = quantity;
        this.status = "new";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public int getEmpty() {
        return empty;
    }

    public void setEmpty(int empty) {
        this.empty = empty;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", empty=" + empty +
                ", status='" + status + '\'' +
                '}';
    }
}
