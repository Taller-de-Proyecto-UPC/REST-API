package com.tp.neuralscan.patient.model;

import com.tp.neuralscan.doctor.model.DoctorEntity;
import com.tp.neuralscan.person.model.PersonEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "patient_entity")
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity extends PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dni", length = 8, nullable = false)
    private String dni;

    @Column(name = "bloodType", length = 50, nullable = false)
    private String bloodType;

    @Column(name = "diseases", length = 50, nullable = false)
    private String diseases;

    @Column(name = "height", length = 50, nullable = false)
    private Float height;

    @Column(name = "weight", length = 50, nullable = false)
    private Float weight;

    @ManyToOne
    @JoinColumn(name = "doctor_entity_id")
    private DoctorEntity doctorEntity;

    @OneToMany(mappedBy = "patientEntity", orphanRemoval = true)
    private List<ReportEntity> reports  = new ArrayList<>();

}