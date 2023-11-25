package com.tp.neuralscan.person.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserResource {
    private String username;
    private String password;
    private String role;
}
