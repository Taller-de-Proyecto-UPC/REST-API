package com.tp.neuralscan.patient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateReportResource {
    private String summary;
    private String description;
    private String comment;
}
