package com.deccan.address.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deccan.address.dto.EmployeeDTO;

@FeignClient(name = "employees")
public interface employeeClient {
    @GetMapping("/employees/{id}")
    public EmployeeDTO getEmployeeWithID(@PathVariable Long id);
    
}
