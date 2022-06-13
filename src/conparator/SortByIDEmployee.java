package conparator;

import model.Employee;
import java.util.Comparator;

public class SortByIDEmployee implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getIdEmployee() - o2.getIdEmployee() > 0)
            return 1;
        else if (o1.getIdEmployee() - o2.getIdEmployee() == 0)
            return 0;
        else return -1;
    }
}
