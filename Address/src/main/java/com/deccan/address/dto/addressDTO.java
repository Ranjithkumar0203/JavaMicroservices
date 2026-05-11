package com.deccan.address.dto;


public class addressDTO {
    // private List<address> addressList = new ArrayList<>();

    // public List<address> getAddressList() {
    // return addressList;
    // }

    // public void setAddressList(List<address> addressList) {
    // this.addressList = addressList;
    // }

    // public addressDTO(List<address> addressList) {
    // this.addressList = addressList;
    // }
    private String id;
    private String city;
    private String pincode;
    private String address;
    private String phoneNumber;
    private String employeeID;

   

    public addressDTO(String id, String city, String pincode, String address, String phoneNumber, String employeeID) {
        this.id = id;
        this.city = city;
        this.pincode = pincode;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.employeeID = employeeID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public addressDTO(String city, String pincode, String address, String phoneNumber) {
        this.city = city;
        this.pincode = pincode;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public addressDTO() {
    }
}
