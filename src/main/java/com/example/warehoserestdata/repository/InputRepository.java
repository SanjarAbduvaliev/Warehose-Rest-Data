package com.example.warehoserestdata.repository;
import com.example.warehoserestdata.entity.Currency;
import com.example.warehoserestdata.entity.Input;
import com.example.warehoserestdata.entity.Supplier;
import com.example.warehoserestdata.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input,Integer> {
    Warehouse findByWarehouse_Id(Integer warehouse_id);
    Supplier findBySupplier_Id(Integer supplier_id);
    Currency findByCurrency_Id(Integer currency_id);
}
