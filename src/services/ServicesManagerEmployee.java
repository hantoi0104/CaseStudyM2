package services;
import model.Employee;
import static services.ServicesBorrowManager.*;

public class ServicesManagerEmployee {

    public void addEmployee(Employee employee) {
        list_Employee.add(employee);
        readAndWriteEmployee.write(list_Employee, "listEmployee.txt");
    }

    public void editEmployee(Employee employee, int index) {
        list_Employee.set(index,employee);
       readAndWriteEmployee.write(list_Employee, "listEmployee.txt");
    }

    public void deleteEmployee(int index) {
        list_Employee.remove(index);
        readAndWriteEmployee.write(list_Employee, "listEmployee.txt");
    }

    public int getIndex(int id) {
        for (int i = 0; i < list_Employee.size(); i++) {
            if (list_Employee.get(i).getIdEmployee() == id)
                return i;
        }
        return -1;
    }

    public Boolean checkId(int id) {
        for (int i = 0; i < list_Employee.size(); i++) {
            if (list_Employee.get(i).getIdEmployee() == id)
                return true;
        }
        return false;
    }
}
