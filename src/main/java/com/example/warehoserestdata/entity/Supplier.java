package com.example.warehoserestdata.entity;

import com.example.warehoserestdata.entity.template.AbsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Supplier extends AbsEntity {
    private String phoneNumber;
}
