package com.tp.neuralscan.administrator.dto;

import com.tp.neuralscan.person.dto.CreateUserResource;
import com.tp.neuralscan.person.dto.UserResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorResource {
    private Long doctorId;
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
