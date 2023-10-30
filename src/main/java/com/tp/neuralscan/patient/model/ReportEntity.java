package com.tp.neuralscan.patient.model;

import jakarta.persistence.*;
import lombok.*;

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

    @Lob
    @Column(name = "image_data", nullable = true)
    private byte[] imageData;

}