package com.tp.neuralscan.patient.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageResource {
    private Long id;
    private String path;
    private String added;
}
