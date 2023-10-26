package com.example.onetomany.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "address", schema = "fsweb")
public class Address {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column(name = "id")
    private int  id ;
    @Column(name = "street")
    private String street ;
    @Column(name = "no")
    private int no ;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country ;
    @Column(name = "description")
    private String description ;
    @OneToOne(mappedBy = "address",cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private Customer customer ;
}
