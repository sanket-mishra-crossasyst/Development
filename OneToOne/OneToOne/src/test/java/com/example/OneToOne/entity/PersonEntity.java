package com.example.OneToOne.entity;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class PersonEntity {
    @Id
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne
    @JoinColumn(name="address_id")
    private AddressEntity address;
}
