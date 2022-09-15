package com.alwa.annualleavewebapp.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private int days_off;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.MERGE)
    private User user;


}

