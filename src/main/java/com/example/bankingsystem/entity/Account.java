package com.example.bankingsystem.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;
    @OneToOne(cascade = CascadeType.ALL)
    private Profile userId;
    @Column(name="NAME",columnDefinition = "VARCHAR", length = 50,nullable = false)
    private String accountName;
    private AccountType accountType;
    private double balance;
    private Date createDate;
    private Date updateDate;



}
