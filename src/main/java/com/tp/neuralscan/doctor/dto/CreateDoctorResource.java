package com.tp.neuralscan.doctor.dto;

import com.tp.neuralscan.person.dto.CreateUserResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDoctorResource {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String birthday;
    private String CIP;
    private String specialty;
    private CreateUserResource user;

}
