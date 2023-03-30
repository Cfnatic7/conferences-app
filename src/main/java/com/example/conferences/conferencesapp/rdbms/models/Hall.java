package com.example.conferences.conferencesapp.rdbms.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer capacity;

    @OneToMany(mappedBy = "hall", fetch = FetchType.EAGER)
    private List<Conference> conferences;
}
