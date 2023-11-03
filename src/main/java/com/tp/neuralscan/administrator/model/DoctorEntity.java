package com.tp.neuralscan.administrator.model;

import com.tp.neuralscan.patient.model.PatientEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "doctor_entity")
@NoArgsConstructor
@AllArgsConstructor
public class DoctorEntity {
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

    @ManyToOne
    @JoinColumn(name = "administrator_entity_id")
    private AdministratorEntity administratorEntity;

    @OneToMany(mappedBy = "doctorEntity", orphanRemoval = true)
    private List<PatientEntity> patients = new ArrayList<>();
}