package com.example.warehoserestdata.projection;

import com.example.warehoserestdata.entity.Measurement;
import com.example.warehoserestdata.entity.template.AbsEntity;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Measurement.class)
public interface CustomMeasurment {
    Integer getId();
    String getName();
    boolean getActive();
}
