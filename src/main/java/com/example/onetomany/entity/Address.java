package com.example.onetomany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "address", schema = "fsweb")
public class Address {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column(name = "address_id")
    private int  adressId ;
    @Column(name = "street_no")
    private int streetNo ;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country ;
    @Column(name = "description")
    private String description ;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH},
    mappedBy = "address")
    private Customer customer ;
}
