package com.deccan.address.client;

import org.springframework.stereotype.Component;

import com.deccan.address.dto.EmployeeDTO;

@Component
public class EmployeeClientFallback implements employeeClient {

    @Override
    public EmployeeDTO getEmployeeWithID(Long id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(id);
        employeeDTO.setName("Employee service is currently unavailable");
        return employeeDTO;
    }
}
