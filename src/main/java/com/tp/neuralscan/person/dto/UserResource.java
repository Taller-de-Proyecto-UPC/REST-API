package com.tp.neuralscan.person.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResource {
    private Long id;
    private String username;
    private String password;
    private String role;
    private Boolean active;

}
