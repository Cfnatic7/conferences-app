package com.example.conferences.conferencesapp.rdbms.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="participant_conference",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    private List<Person> participants;

    @OneToMany(mappedBy = "conference")
    private List<Topic> topics;

    @ManyToOne()
    @JoinColumn(name = "hall_id")
    private Hall hall;
}
