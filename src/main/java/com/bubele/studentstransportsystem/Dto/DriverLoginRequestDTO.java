package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverLoginRequestDTO {

    private String email;
    private String password;

}