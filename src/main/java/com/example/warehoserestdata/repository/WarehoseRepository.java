package com.example.warehoserestdata.repository;

import com.example.warehoserestdata.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehoseRepository extends JpaRepository<Warehouse,Integer> {
}
