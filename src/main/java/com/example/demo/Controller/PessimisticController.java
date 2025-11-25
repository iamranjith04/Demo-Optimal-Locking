package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Database.DemoDatabasePessimistic;
import com.example.demo.Repository.DemoDatabaseRepoPessimistic;
import com.example.demo.Service.PessimisticLockService;

@RestController
@RequestMapping("/pessimistic")
public class PessimisticController {
    
    @Autowired
    private PessimisticLockService service;

    @Autowired
    private DemoDatabaseRepoPessimistic dBRepo;

    @GetMapping("/addRecord/{name}")
    public void addRecord(@PathVariable String name){ 
        DemoDatabasePessimistic data=new DemoDatabasePessimistic();
        data.setName(name);
        data.setAccountBalance(5000);
        dBRepo.save(data);
    }

    @GetMapping("/getRecord/{id}")
    public String reduce(@PathVariable Integer id) {
        try {
            return service.reduceBalanceBy100(id);
        } catch (Exception e) {
            return "Update Failed: " + e.getMessage();
        }
    }

    @GetMapping("/getRecordByName/{name}")
    public String reduce(@PathVariable String name) {
        try {
            return service.reduceBalanceByName100(name);
        } catch (Exception e) {
            return "Update Failed: " + e.getMessage();
        }
    }
}
