package com.deccan.address.service.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deccan.address.client.employeeClient;
import com.deccan.address.dao.addressEntity;
import com.deccan.address.dto.EmployeeAddressCountDTO;
import com.deccan.address.dto.EmployeeDTO;
import com.deccan.address.dto.addressDTO;
import com.deccan.address.entity.address;
import com.deccan.common.exception.AddressNotFoundException;
import com.deccan.common.exception.AddressSaveException;
import com.deccan.common.exception.EmployeeServiceException;

import com.deccan.address.service.addressService;
import feign.FeignException;

@Service
public class addressServiceiMPL implements addressService {

    @Autowired
    private addressEntity _addressEntity;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private employeeClient _employeeClient;

    @Override
    public addressDTO saveAddressList(addressDTO _addressDTO) {
        address _address = modelMapper.map(_addressDTO, address.class);
        try {
            _addressEntity.save(_address);
        } catch (Exception ex) {
            throw new AddressSaveException("Unable to save address", ex);
        }
        addressDTO _addressdto = modelMapper.map(_address, addressDTO.class);
        return _addressdto;
    }

    @Override
    public List<addressDTO> getAddressesByEmployeeID(String employeeID) {
        List<addressDTO> addresses = _addressEntity.findByEmployeeID(employeeID)
                .stream()
                .map(_address -> modelMapper.map(_address, addressDTO.class))
                .toList();

        if (addresses.isEmpty()) {
            throw new AddressNotFoundException("Address not found with employee id: " + employeeID);
        }

        return addresses;
    }

    @Override
    public List<EmployeeDTO> findEmployeeIDWithAddressCount(Long count) {
        List<EmployeeAddressCountDTO> employeeAdressCountDTOs = _addressEntity.findEmployeeIDWithAddressCount(count);

        if (employeeAdressCountDTOs.isEmpty()) {
            throw new AddressNotFoundException("Address not found with count: " + count);
        }

        try {
            return employeeAdressCountDTOs.stream()
                    .map(employeeAddressCountDTO -> _employeeClient
                            .getEmployeeWithID(Long.valueOf(employeeAddressCountDTO.getEmployeeID())))
                    .toList();
        } catch (FeignException ex) {
            throw new EmployeeServiceException("Unable to fetch employee because employee service is not available",
                    ex);
        }
    }

}
