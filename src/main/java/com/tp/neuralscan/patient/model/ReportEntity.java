package com.tp.neuralscan.patient.model;

import com.tp.neuralscan.doctor.model.DoctorEntity;
import com.tp.neuralscan.person.model.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.awt.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "report_entity")
@NoArgsConstructor
@AllArgsConstructor
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "summary", length = 50, nullable = false)
    private String summary;

    @Column(name = "description", length = 50, nullable = false)
    private String description;

    @Column(name = "comment", length = 50, nullable = true)
    private String comment;

    @OneToOne
    @JoinColumn(name = "image_entity", referencedColumnName = "id")
    private ImageEntity imageEntity;

    @ManyToOne
    @JoinColumn(name = "patient_entity")
    private PatientEntity patientEntity;

    @ManyToOne
    @JoinColumn(name = "doctor_entity")
    private DoctorEntity doctorEntity;
}