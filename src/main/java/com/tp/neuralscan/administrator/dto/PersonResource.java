package com.tp.neuralscan.administrator.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResource {
    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String birthday;
}
