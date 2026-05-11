package com.deccan.worklocation.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deccan.worklocation.dao.workLocationRepo;
import com.deccan.worklocation.entity.WorkLocationEntity;
import com.deccan.worklocation.model.WorkLocation;
import com.deccan.worklocation.service.WorkLocationService;

@Service
public class WorkLocationServiceImpl implements WorkLocationService{

    public final workLocationRepo _workLocationRepo;
     public final ModelMapper modelmapper;
    public WorkLocationServiceImpl(workLocationRepo _workLocationRepo, ModelMapper modelmapper){
        this._workLocationRepo = _workLocationRepo;
        this.modelmapper = modelmapper;

    }

    @Override
    public WorkLocation saveWorkLocation(WorkLocation workLocation) {
       WorkLocationEntity _workLocation =
                modelmapper.map(workLocation, WorkLocationEntity.class);
        WorkLocationEntity savedWorkLocation = this._workLocationRepo.save(_workLocation);
        return modelmapper.map(savedWorkLocation, WorkLocation.class);
    }
    
}
