package com.example.oneToOneMapping.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "oto3person")
public class PersonEntity {
    @Id
    @SequenceGenerator(name = "seq_3person_id", sequenceName = "seq_3person_id", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_3person_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "id")
    private AddressEntity address;
}
