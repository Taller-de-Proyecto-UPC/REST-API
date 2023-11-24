package com.tp.neuralscan.administrator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePersonResource {
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String birthday;
}
