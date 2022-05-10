package com.example.bankingsystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int streetNumber;
    private String unitNumber;
    private String city;
    private String state;
    private String postCode;
}

