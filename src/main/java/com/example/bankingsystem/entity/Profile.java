package com.example.bankingsystem.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID uuid;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

}
