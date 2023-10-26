package com.example.onetomany.entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "account", schema = "fsweb")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "money_amount")
    private double moneyAmount;


    @JoinColumn(name = "customer_id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Customer customer;
}
