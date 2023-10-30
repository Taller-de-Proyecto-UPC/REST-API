package com.tp.neuralscan.administrator.dto;

import com.tp.neuralscan.administrator.model.AdministratorEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorResource {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private AdministratorResource administrator;
}
