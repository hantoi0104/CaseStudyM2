package services;

import io.ReadAndWrite;
import model.Book;

import java.util.ArrayList;

import static services.ServicesBorrowManager.list_Book;
import static services.ServicesBorrowManager.readAndWriteBook;

public class ServicesManagerBook {


    public void addBook(Book book) {
        list_Book.add(book);
        readAndWriteBook.write(list_Book, "listBook.txt");
    }

    public void editBook(Book book, int index) {
        list_Book.set(index, book);
        readAndWriteBook.write(list_Book, "listBook.txt");
    }

    public void deleteBook(int index) {
        list_Book.remove(index);
        readAndWriteBook.write(list_Book, "listBook.txt");
    }

    public int getIndex(int id) {
        for (int i = 0; i < list_Book.size(); i++) {
            if (list_Book.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public Boolean checkId(int id) {
        for (int i = 0; i < list_Book.size(); i++) {
            if (list_Book.get(i).getId() == id)
                return true;
        }
        return false;
    }
}
