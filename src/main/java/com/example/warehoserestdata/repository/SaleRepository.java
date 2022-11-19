package com.example.warehoserestdata.repository;
import com.example.warehoserestdata.entity.Client;
import com.example.warehoserestdata.entity.Currency;
import com.example.warehoserestdata.entity.Input;
import com.example.warehoserestdata.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Input,Integer> {
    Warehouse findByWarehouse_Id(Integer warehouse_id);
    Client findByClient_Id(Integer client_id);
    Currency findByCurrency_Id(Integer currency_id);
}
