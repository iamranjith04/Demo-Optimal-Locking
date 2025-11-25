package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Database.DemoDatabase;

public interface DemoDatabaseRepo extends JpaRepository<DemoDatabase, Integer> {
    DemoDatabase findById(int id);
} 