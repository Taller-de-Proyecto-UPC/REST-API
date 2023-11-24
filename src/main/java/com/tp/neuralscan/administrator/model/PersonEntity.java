package com.tp.neuralscan.administrator.model;


import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@Entity
@Table(name = "person_entity")
@NoArgsConstructor
@AllArgsConstructor

public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "phone", length = 9, nullable = false)
    private String phone;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "birthday", length = 50, nullable = false)
    private String birthday;

}
