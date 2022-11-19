package com.example.warehoserestdata.entity;

import com.example.warehoserestdata.entity.template.AbsEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Product extends AbsEntity {
    private String code;
    @ManyToOne
    private Category category;
    @OneToOne
    private Attachment attachment;
    @ManyToOne
    private Measurement measurement;

}
