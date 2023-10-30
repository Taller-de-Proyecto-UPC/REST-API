package com.tp.neuralscan.patient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePatientResource {
    private String name;
    private String lastName;
    private String email;
}
