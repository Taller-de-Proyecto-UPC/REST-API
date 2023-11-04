package com.tp.neuralscan.administrator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorResource {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
}
