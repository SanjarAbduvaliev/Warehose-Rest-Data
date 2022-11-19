package com.example.warehoserestdata.projection;

import com.example.warehoserestdata.entity.Supplier;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Supplier.class)
public interface CustomSupplier {
    String getPhoneNumber();
    String getName();
    String getId();
}
