package com.example.conferences.conferencesapp.controllers;

import com.example.conferences.conferencesapp.enums.PersonType;
import com.example.conferences.conferencesapp.rdbms.models.Person;
import com.example.conferences.conferencesapp.rdbms.repositories.ConferenceRepository;
import com.example.conferences.conferencesapp.rdbms.repositories.HallRepository;
import com.example.conferences.conferencesapp.rdbms.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConferenceController {

    private final ConferenceRepository conferenceRepository;

    private final HallRepository hallRepository;

    private final PersonRepository personRepository;


    @GetMapping("/conferences/{conferenceId}/participants")
    public List<Person> getAllParticipants(@PathVariable Long conferenceId) {
        return conferenceRepository.findAllParticipantsByConferenceId(conferenceId);
    }

    @GetMapping("/persons")
    public List<Person> getPersonsByType(@RequestParam PersonType personType) {
        return personRepository.findByPersonType(personType);
    }

    @GetMapping("/persons/nationality")
    public List<Person> getPersonsByNationality(@RequestParam String nationality) {
        return personRepository.findByNationality(nationality);
    }

    @GetMapping("/persons/most_presentations")
    public Person getPersonWithMostPresentations() {
        return personRepository.findPersonWithMostPresentations();
    }

    @GetMapping("/halls/presentations_count")
    public List<Object[]> getPresentationsPerHall() {
        return hallRepository.countPresentationsPerHall();
    }
}
