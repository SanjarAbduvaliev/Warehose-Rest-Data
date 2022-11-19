package com.example.warehoserestdata.projection;

import com.example.warehoserestdata.entity.Client;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Client.class)
public interface CustomClient {
    String getPhoneNumber();
    String getName();
    String getId();
}
