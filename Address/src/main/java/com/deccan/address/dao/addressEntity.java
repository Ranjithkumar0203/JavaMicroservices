package com.deccan.address.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.deccan.address.dto.EmployeeAddressCountDTO;
import com.deccan.address.dto.addressDTO;
import com.deccan.address.entity.address;


@Repository
public interface addressEntity  extends MongoRepository<address, String> {

    List<address> findByEmployeeID(String employeeID);

  @Aggregation(pipeline = {
    "{ $group: { _id: '$employeeID', addressCount: { $sum: 1 } } }",
    "{ $match: { addressCount: ?0 } }",
    "{ $project: { _id: 0, employeeID: '$_id', addressCount: 1 } }"
})
    List<EmployeeAddressCountDTO> findEmployeeIDWithAddressCount(Long count);
    
}
