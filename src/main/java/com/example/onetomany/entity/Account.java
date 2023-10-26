package com.example.onetomany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "account",schema = "fsweb")
public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name = "account_id")
    private int id;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "money_amount")
    private double moneyAmount ;


    @JoinColumn(name = "customer_id" )
            @ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
   private Customer customer;
}
