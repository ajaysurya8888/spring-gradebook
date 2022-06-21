package com.gradebook.Gradebook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;


@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Parent extends AppUser{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany
    private List<Student> kids;
}
