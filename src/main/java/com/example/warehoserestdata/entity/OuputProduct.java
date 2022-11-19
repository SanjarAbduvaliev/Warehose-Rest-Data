package com.example.warehoserestdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OuputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String amount;
    @Column(nullable = false)
    private String price;
    @ManyToOne
    private Output output;
    @ManyToOne
    private Product product;

}
