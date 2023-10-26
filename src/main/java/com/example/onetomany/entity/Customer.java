package com.example.onetomany.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer", schema = "fsweb")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId ;
  @Column(name = "first_name")
    private String firstName;
  @Column (name = "last_name")
   private String lastName;
   @Column(name = "email")
    private String email;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "address_id")
   private Address address ;

   @OneToMany (mappedBy = "customer", cascade = {CascadeType.DETACH, CascadeType.MERGE,
           CascadeType.PERSIST, CascadeType.REFRESH})
   private List<Account> accounts ;

}
