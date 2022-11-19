package com.example.warehoserestdata.payload;

import lombok.Data;

@Data
public class CategoryDto {
    private String name;
    private Integer parrenCategoryId;
}
