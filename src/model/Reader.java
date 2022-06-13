package model;

import java.time.LocalDate;

public class Reader extends Person{
    private int idReader;
    private int phoneNumber;
    private String email;

    public Reader() {
    }

    public Reader(int cmnd, String name, LocalDate dateOfBirth, String address, String gender, int idReader, int phoneNumber, String email) {
        super(cmnd, name, dateOfBirth, address, gender);
        this.idReader = idReader;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getIdReader() {
        return idReader;
    }

    public void setIdReader(int idReader) {
        this.idReader = idReader;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "idReader='" + idReader + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                '}';
    }
}
