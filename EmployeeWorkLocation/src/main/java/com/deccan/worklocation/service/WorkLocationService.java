package com.deccan.worklocation.service;

import org.springframework.stereotype.Service;

import com.deccan.worklocation.model.WorkLocation;

@Service
public interface WorkLocationService {
    
    WorkLocation saveWorkLocation(WorkLocation workLocation);
}
