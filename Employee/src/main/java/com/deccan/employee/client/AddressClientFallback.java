package com.deccan.employee.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.deccan.employee.model.Address;

@Component
public class AddressClientFallback implements AddressClient {

    @Override
    public Address saveAddress(Address address) {
        Address fallbackAddress = address == null ? new Address() : address;
        fallbackAddress.setAddress("Address service is currently unavailable");
        return fallbackAddress;
    }

    @Override
    public List<Address> getAddressesByEmployeeID(String employeeID) {
        return Collections.emptyList();
    }
}
