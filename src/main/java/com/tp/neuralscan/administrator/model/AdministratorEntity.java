package com.tp.neuralscan.administrator.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@Getter
@Setter
@Entity
@Table(name = "administrator_entity")
@NoArgsConstructor
@AllArgsConstructor
public class AdministratorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @OneToMany(mappedBy = "administratorEntity", orphanRemoval = true)
    private List<DoctorEntity> doctors = new ArrayList<>();


}