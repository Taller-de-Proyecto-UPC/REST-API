package com.tp.neuralscan.person.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

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

    @Column(name = "active", length = 50, nullable = false)
    private Boolean active;

}