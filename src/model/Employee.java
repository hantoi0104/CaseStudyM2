package model;

import java.time.LocalDate;

public class Employee extends Person{
    private String idEmployee;
    private String position;
    private int part;

    public Employee() {
    }


    public Employee(int cmnd, String name, LocalDate dateOfBirth, String address, String gender, String idEmployee, String position, int part) {
        super(cmnd, name, dateOfBirth, address, gender);
        this.idEmployee = idEmployee;
        this.position = position;
        this.part = part;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
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
