package com.alwa.annualleavewebapp.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String address;

}
