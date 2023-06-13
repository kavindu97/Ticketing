package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude

public class TicketingDto {
    private Integer id;
    private String studentId;

    private String name;

    private String contactNumber;

    private String email;
    private String isSentEmail;
    private String isSentMessage;
    private String status;
}
