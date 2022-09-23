package com.alwa.annualleavewebapp.entities;

import lombok.*;

import javax.persistence.*;

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
    @Column(name = "full_name")
    private String fullName;

}
