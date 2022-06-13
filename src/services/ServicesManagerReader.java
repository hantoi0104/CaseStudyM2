package services;
import model.Employee;
import model.Reader;

import static services.ServicesBorrowManager.*;

public class ServicesManagerReader {

    public void addReader(Reader reader) {
        list_Reader.add(reader);
        readAndWriteReader.write(list_Reader, "listReader.txt");
    }

    public void editReader(Reader reader, int index) {
        list_Reader.set(index,reader);
        readAndWriteReader.write(list_Reader, "listReader.txt");
    }

    public void deleteReader(int index) {
        list_Reader.remove(index);
        readAndWriteReader.write(list_Reader, "listReader.txt");
    }

    public int getIndex(int id) {
        for (int i = 0; i < list_Reader.size(); i++) {
            if (list_Reader.get(i).getIdReader() == id)
                return i;
        }
        return -1;
    }

    public Boolean checkId(int id) {
        for (int i = 0; i < list_Reader.size(); i++) {
            if (list_Reader.get(i).getIdReader() == id)
                return true;
        }
        return false;
    }
}
