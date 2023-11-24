package com.tp.neuralscan.person.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@Getter
@Setter
@Entity
@Table(name = "person_entity")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy =  InheritanceType.JOINED)
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "birthday", length = 50, nullable = false)
    private String birthday;
}