package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Database.DemoDatabaseOptimal;

public interface DemoDatabaseRepo extends JpaRepository<DemoDatabaseOptimal, Integer> {
    DemoDatabaseOptimal findById(int id);
} 