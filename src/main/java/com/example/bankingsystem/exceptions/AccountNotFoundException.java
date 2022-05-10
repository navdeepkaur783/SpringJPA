package com.example.bankingsystem.exceptions;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(){
        this("No Matching account");
    }


}
