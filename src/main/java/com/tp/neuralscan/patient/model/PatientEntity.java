package com.tp.neuralscan.patient.model;

import com.tp.neuralscan.administrator.model.AdministratorEntity;
import com.tp.neuralscan.administrator.model.DoctorEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "patient_entity")
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "doctor_entity_id")
    private DoctorEntity doctorEntity;

    @OneToMany(mappedBy = "patientEntity", orphanRemoval = true)
    private List<ReportEntity> reports  = new ArrayList<>();

}