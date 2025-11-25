package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Database.DemoDatabasePessimistic;
import com.example.demo.Repository.DemoDatabaseRepoPessimistic;

@Service
public class PessimisticLockService {

    @Autowired
    private DemoDatabaseRepoPessimistic repo;

    @Transactional
    public String reduceBalanceBy100(int id) {
        DemoDatabasePessimistic db = repo.findByIdForUpdate(id);
        System.out.println(Thread.currentThread().getName() +" - Acquired lock. Current balance: " + db.getAccountBalance());

        try { 
            Thread.sleep(30000); 
        } 
        catch (Exception e) {
            return "Error in Thread Sleep";
        }

        db.setAccountBalance(db.getAccountBalance() - 100);
        repo.save(db);
        
        System.out.println(Thread.currentThread().getName() + " - Updated balance for ID: " + id);

        return "Updated Successfully";
    }
}

