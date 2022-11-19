package com.example.warehoserestdata.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SaleDto {
    private Timestamp timesDate;
    private Integer warehoseId;
    private Integer clientId;
    private Integer currencyId;
}
