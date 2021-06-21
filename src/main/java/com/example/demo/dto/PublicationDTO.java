package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class PublicationDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long userId;
    private String text;
}
