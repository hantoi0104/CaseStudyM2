package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee extends Person implements Serializable {
    private int idEmployee;
    private String position;
    private String part;

    public Employee() {
    }


    public Employee(int id, String name, LocalDate dateOfBirth, String address, String gender, int idEmployee, String position, String part) {
        super(id, name, dateOfBirth, address, gender);
        this.idEmployee = idEmployee;
        this.position = position;
        this.part = part;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee='" + idEmployee + '\'' +
                ", position='" + position + '\'' +
                ", part=" + part +
                '}';
    }
}
