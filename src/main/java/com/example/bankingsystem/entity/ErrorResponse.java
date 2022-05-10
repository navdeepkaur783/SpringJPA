package com.example.bankingsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
@Data
@Builder
@AllArgsConstructor

public class ErrorResponse {
    private int code;
    private String msg;
    private Instant dateTime;
    private String applicationId;
}
