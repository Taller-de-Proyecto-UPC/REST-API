package com.tp.neuralscan.patient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportResource {
    private Long id;
    private String summary;
    private String description;
    private String comment;
    private CreateImageResource image;

    //private PatientResource patient;
}
