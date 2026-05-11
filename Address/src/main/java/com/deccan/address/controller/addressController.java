package com.deccan.address.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deccan.address.dto.EmployeeDTO;
import com.deccan.address.dto.addressDTO;
import com.deccan.address.service.addressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/address")
public class addressController {

    @Autowired
    public addressService _addressService;

    @GetMapping()
    public String Hello() {
        return "Hi Hello";
    }

    @PostMapping("/save")
    public addressDTO saveAddress(@RequestBody addressDTO _addressDto) {
        addressDTO address = _addressService.saveAddressList(_addressDto);
        return address;
    }

    @GetMapping("/employee/{employeeID}")
    public List<addressDTO> getAddressesByEmployeeID(@PathVariable String employeeID) {
        return _addressService.getAddressesByEmployeeID(employeeID);
    }

    @GetMapping("/{count}")
    public List<EmployeeDTO> getEmployeeByMoreThanOneAddress(@PathVariable Long count) {
        return _addressService.findEmployeeIDWithAddressCount(count);
    }

}
