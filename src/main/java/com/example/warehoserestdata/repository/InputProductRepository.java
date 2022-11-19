package com.example.warehoserestdata.repository;
import com.example.warehoserestdata.entity.Input;
import com.example.warehoserestdata.entity.InputProduct;
import com.example.warehoserestdata.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
    Input findByInputId(Integer receipt_id);
    Product findByProduct_Id(Integer product_id);
}
