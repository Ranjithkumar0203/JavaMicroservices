package com.deccan.employee.client;

import org.springframework.stereotype.Component;

import com.deccan.employee.model.WorkLocation;

@Component
public class WorkLocationClientFallback implements WorkLocationClientClient {

    @Override
    public WorkLocation saveWorkLocation(WorkLocation workLocation) {
        WorkLocation fallbackWorkLocation = workLocation == null ? new WorkLocation() : workLocation;
        fallbackWorkLocation.setLocationName("Work location service is currently unavailable");
        return fallbackWorkLocation;
    }
}
