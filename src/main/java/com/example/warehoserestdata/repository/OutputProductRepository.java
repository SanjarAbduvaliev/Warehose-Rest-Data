package com.example.warehoserestdata.repository;

import com.example.warehoserestdata.entity.Product;
import com.example.warehoserestdata.entity.Input;
import com.example.warehoserestdata.entity.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputProductRepository extends JpaRepository<InputProduct,Integer> {
    Product findByProduct_Id(Integer product_id);
    Input findByInputId(Integer sale_id);


}
