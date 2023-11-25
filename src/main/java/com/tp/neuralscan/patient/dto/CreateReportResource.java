package com.tp.neuralscan.patient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReportResource {
    private String summary;
    private String description;
    private String comment;
    private CreateImageResource image;

}
