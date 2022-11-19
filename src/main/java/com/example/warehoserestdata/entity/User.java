package com.example.warehoserestdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp date;
    private String firsName;
    private String lastName;
    @Column(unique = true,nullable = false)
    private String phoneNumber;
    private String code;
    private String password;
    private boolean active;
    @ManyToMany
    private Set<Warehouse> warehouses;
}
