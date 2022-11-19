package com.example.warehoserestdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double amount;
    private Date expireDate;
    @Column(nullable = false)
    private String price;
    @ManyToOne
    private Input input;
    @ManyToOne
    private Product product;

}
