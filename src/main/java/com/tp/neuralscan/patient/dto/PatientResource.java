package com.tp.neuralscan.patient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientResource {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String birthday;
    private String bloodType;
    private String diseases;
    private Float height;
    private Float weight;
    //private DoctorResource doctor;
}
