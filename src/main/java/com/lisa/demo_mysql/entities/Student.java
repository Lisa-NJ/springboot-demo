package com.lisa.demo.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true,name = "email") //sets the database column name and sets it to unique
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "course")
    private String course;

    @Column(name = "registration_number")
    private String registrationNumber;
}
