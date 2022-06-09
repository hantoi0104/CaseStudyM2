package model;

public class BorrowManagement {
private Document document;
private Reader reader;
private int total;
private String state;

    public BorrowManagement() {
    }

    public BorrowManagement(Document document, Reader reader, int total, String state) {
        this.document = document;
        this.reader = reader;
        this.total = total;
        this.state = state;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
