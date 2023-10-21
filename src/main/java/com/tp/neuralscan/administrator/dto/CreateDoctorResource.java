package com.tp.neuralscan.administrator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDoctorResource {
    private String name;
    private String lastName;
    private String password;
    private String email;
}
