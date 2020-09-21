package com.celestii.springboot.springbootreact.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class TodoDTO {

    private String title;
    private LocalDate dueDate;
}
