package com.arpit.EventTicketingSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String phone;

}
