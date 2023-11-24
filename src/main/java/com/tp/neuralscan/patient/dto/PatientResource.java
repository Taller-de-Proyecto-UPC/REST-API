package com.tp.neuralscan.patient.dto;

import com.tp.neuralscan.administrator.dto.DoctorResource;
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
    //private DoctorResource doctor;
}
