package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Database.DemoDatabasePessimistic;
import jakarta.persistence.LockModeType;

public interface DemoDatabaseRepoPessimistic extends JpaRepository<DemoDatabasePessimistic, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT d FROM DemoDatabasePessimistic d WHERE d.id = :id")
    DemoDatabasePessimistic findByIdForUpdate(@Param("id") int id);
    
}
