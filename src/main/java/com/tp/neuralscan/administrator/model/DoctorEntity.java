package com.tp.neuralscan.administrator.model;

import com.tp.neuralscan.patient.model.PatientEntity;
import com.tp.neuralscan.person.model.PersonEntity;
import com.tp.neuralscan.person.model.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "doctor_entity")
@NoArgsConstructor
@AllArgsConstructor
public class DoctorEntity extends PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "specialty", length = 50, nullable = false)
    private String specialty;

    @Column(name = "CIP", length = 50, nullable = false)
    private String CIP;

    @OneToOne
    @JoinColumn(name = "user_entity_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "doctorEntity", orphanRemoval = true)
    private List<PatientEntity> patients = new ArrayList<>();
}