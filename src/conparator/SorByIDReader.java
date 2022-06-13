package conparator;

import model.Employee;
import model.Reader;

import java.util.Comparator;

public class SorByIDReader implements Comparator<Reader> {
    @Override
    public int compare(Reader o1,Reader o2) {
        if (o1.getIdReader() - o2.getIdReader() > 0)
            return 1;
        else if (o1.getIdReader() - o2.getIdReader() == 0)
            return 0;
        else return -1;
    }
}
