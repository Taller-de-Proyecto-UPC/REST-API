package com.tp.neuralscan.person.model;

import com.tp.neuralscan.administrator.model.DoctorEntity;
import com.tp.neuralscan.patient.model.PatientEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "user_entity")
@NoArgsConstructor
@Transactional
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "role", length = 50, nullable = false)
    private String role;

}