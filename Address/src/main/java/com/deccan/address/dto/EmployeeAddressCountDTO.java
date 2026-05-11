package com.deccan.address.dto;

public class EmployeeAddressCountDTO {

    private String employeeID;
    private int addressCount;

    // Default constructor
    public EmployeeAddressCountDTO() {}

    // All args constructor
    public EmployeeAddressCountDTO(String employeeID, int addressCount) {
        this.employeeID = employeeID;
        this.addressCount = addressCount;
    }

    // Getters and Setters
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getAddressCount() {
        return addressCount;
    }

    public void setAddressCount(int addressCount) {
        this.addressCount = addressCount;
    }
}
