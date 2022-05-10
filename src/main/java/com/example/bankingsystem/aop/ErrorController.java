package com.example.bankingsystem.aop;

import com.example.bankingsystem.entity.ErrorResponse;
import com.example.bankingsystem.exceptions.AccountNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler({AccountNotFoundException.class})
    public ResponseEntity<?> HandleNotFound(Exception ex,HttpServletRequest request) {
        System.out.println(request.getHeader("X-requester") );
        return ResponseEntity.status(404).header("X-FAULT", "No Data")
                .body(ErrorResponse.builder().code(100001).msg(ex.getMessage()).applicationId("DL1").dateTime(Instant.now()).build());
    }
    @ExceptionHandler({IllegalArgumentException.class,Exception.class})
    public ResponseEntity<?> handleInvalidId(Exception ex){
        return ResponseEntity.status(404).header("X-Fault","NO DATA")
                .body(ErrorResponse.builder().code(10001).msg(ex.getMessage()).applicationId("DL1").dateTime(Instant.now()).build());
    }
}
