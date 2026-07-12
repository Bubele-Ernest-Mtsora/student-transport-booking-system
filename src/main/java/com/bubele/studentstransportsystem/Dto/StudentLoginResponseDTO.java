package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentLoginResponseDTO {

    private Long studentId;
    private String studentNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String message;

}