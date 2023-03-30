package com.example.conferences.conferencesapp.rdbms.models;

import com.example.conferences.conferencesapp.enums.PersonType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;

    private String nationality;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

    @OneToMany(mappedBy = "presenter", fetch = FetchType.EAGER)
    private Set<Topic> topics = new HashSet<>();

    @ManyToMany(mappedBy = "participants", fetch = FetchType.EAGER)
    private List<Conference> conferences;
}
