package conparator;
import model.Book;
import java.util.Comparator;

public class SortByUP implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getQuantity() - o2.getQuantity() > 0)
            return 1;
        else if (o1.getQuantity() - o2.getQuantity() == 0)
            return 0;
        else return -1;
    }
}
