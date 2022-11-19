package com.example.warehoserestdata.repository;

import com.example.warehoserestdata.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository  extends JpaRepository<Currency,Integer> {
}
