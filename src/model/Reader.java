package model;

import java.time.LocalDate;

public class Reader extends Person{
    private String idReader;
    private String readerType;
    private int phoneNumber;
    private int email;

    public Reader() {
    }

    public Reader(int cmnd, String name, LocalDate dateOfBirth, String address, String gender, String idReader, String readerType, int phoneNumber, int email) {
        super(cmnd, name, dateOfBirth, address, gender);
        this.idReader = idReader;
        this.readerType = readerType;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getIdReader() {
        return idReader;
    }

    public void setIdReader(String idReader) {
        this.idReader = idReader;
    }

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "idReader='" + idReader + '\'' +
                ", readerType='" + readerType + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                '}';
    }
}
