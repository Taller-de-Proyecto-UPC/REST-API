package com.tp.neuralscan.patient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePatientResource {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String birthday;
}
