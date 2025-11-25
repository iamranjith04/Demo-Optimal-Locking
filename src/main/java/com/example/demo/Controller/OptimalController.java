package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Database.DemoDatabase;
import com.example.demo.Repository.DemoDatabaseRepo;
import com.example.demo.Service.OptimalLockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/optimal")
public class OptimalController{

    @Autowired
    private DemoDatabaseRepo dBRepo;
    
    @Autowired
    private OptimalLockService service;
    @GetMapping("/addRecord/{name}")
    public void addRecord(@PathVariable String name){ 
        DemoDatabase data=new DemoDatabase();
        data.setName(name);
        data.setAccountBalance(5000);
        dBRepo.save(data);
    }

    @GetMapping("/getRecord/{id}")
    public String getRecord(@PathVariable int id){
        return service.demoService(id);
    }
    
}
