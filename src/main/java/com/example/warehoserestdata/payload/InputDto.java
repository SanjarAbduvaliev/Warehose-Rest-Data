package com.example.warehoserestdata.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InputDto {
    private Timestamp timestamp;
    private Integer warehoseid;
    private Integer supplierId;
    private Integer currencyId;
}
