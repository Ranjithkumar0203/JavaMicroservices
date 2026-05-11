package com.deccan.worklocation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deccan.worklocation.model.WorkLocation;
import com.deccan.worklocation.service.WorkLocationService;
import com.deccan.worklocation.serviceImpl.WorkLocationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/worklocation")
public class WorkLocationController{

    private final WorkLocationServiceImpl _WorkLocationServiceImpl;

   public WorkLocationController(WorkLocationServiceImpl _WorkLocationServiceImpl){
    this._WorkLocationServiceImpl = _WorkLocationServiceImpl;    
   }

    @GetMapping("/")
    public String hello() {
        return new String("Hi How do you do");
    }

    @PostMapping("/save")
    public WorkLocation saveWorkLocation(@RequestBody WorkLocation WorkLocation) {

        return _WorkLocationServiceImpl.saveWorkLocation(WorkLocation);
    }
    

}