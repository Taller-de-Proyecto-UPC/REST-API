package com.tp.neuralscan.patient.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "image_entity")
@NoArgsConstructor
@AllArgsConstructor
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "path", length = 200, nullable = false)
    private String path;

    @Column(name = "added", length = 50, nullable = false)
    private String added;
}
