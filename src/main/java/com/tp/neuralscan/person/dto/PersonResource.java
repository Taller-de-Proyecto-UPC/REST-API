package com.tp.neuralscan.person.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResource {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String birthday;
    //private AdministratorResource administrator;
}
