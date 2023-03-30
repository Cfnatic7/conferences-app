package com.example.conferences.conferencesapp.rdbms.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne()
    @JoinColumn(name = "presenter_id")
    private Person presenter;

    @ManyToOne()
    @JoinColumn(name = "conference_id")
    private Conference conference;
}
