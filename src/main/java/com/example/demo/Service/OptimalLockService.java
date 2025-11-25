package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.demo.Database.DemoDatabaseOptimal;
import com.example.demo.Repository.DemoDatabaseRepo;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OptimalLockService {
    
    @Autowired
    private DemoDatabaseRepo dB;

    @Autowired
    @Lazy
    private OptimalLockService self;

    @Transactional
    public void reduceBalanceBy100(int id) {
        DemoDatabaseOptimal data=dB.findById(id);
        try{
            Thread.sleep(10000);
        }
        catch(Exception e){
            System.out.println(e);
        }
        data.setAccountBalance(data.getAccountBalance()-100);
    }


    public String demoService(int id){
        try{
            self.reduceBalanceBy100(id);
        }
        catch(Exception e){
            return "Update Failed due to Optimistic Locking "+e;
        }
        return "Update Successful";
    }

}
