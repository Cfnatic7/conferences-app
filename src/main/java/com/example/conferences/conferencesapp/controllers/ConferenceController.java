package com.example.conferences.conferencesapp.controllers;

import com.example.conferences.conferencesapp.dtos.PersonDto;
import com.example.conferences.conferencesapp.dtos.TopicDto;
import com.example.conferences.conferencesapp.enums.PersonType;
import com.example.conferences.conferencesapp.mappers.PersonMapper;
import com.example.conferences.conferencesapp.mappers.TopicMapper;
import com.example.conferences.conferencesapp.rdbms.models.Person;
import com.example.conferences.conferencesapp.rdbms.models.Topic;
import com.example.conferences.conferencesapp.rdbms.repositories.ConferenceRepository;
import com.example.conferences.conferencesapp.rdbms.repositories.HallRepository;
import com.example.conferences.conferencesapp.rdbms.repositories.PersonRepository;
import com.example.conferences.conferencesapp.rdbms.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConferenceController {

    private final ConferenceRepository conferenceRepository;

    private final HallRepository hallRepository;

    private final PersonRepository personRepository;

    private final TopicRepository topicRepository;

    private final PersonMapper personMapper;

    private final TopicMapper topicMapper;


    @GetMapping("/conferences/{conferenceId}/participants")
    public List<PersonDto> getAllParticipants(@PathVariable Long conferenceId) {
        return conferenceRepository.findAllParticipantsByConferenceId(conferenceId)
                .stream()
                .map(personMapper::mapToDto)
                .toList();
    }

    @GetMapping("/persons")
    public List<PersonDto> getPersonsByType(@RequestParam PersonType personType) {
        return personRepository.findByPersonType(personType)
                .stream()
                .map(personMapper::mapToDto)
                .toList();
    }

    @GetMapping("/persons/nationality")
    public List<PersonDto> getPersonsByNationality(@RequestParam String nationality) {
        return personRepository.findByNationality(nationality)
                .stream()
                .map(personMapper::mapToDto)
                .toList();
    }

    @GetMapping("/persons/most_presentations")
    public PersonDto getPersonWithMostPresentations() {
        return personMapper.mapToDto(personRepository.findPersonWithMostPresentations());
    }

    @GetMapping("/halls/presentations_count")
    public List<Object[]> getPresentationsPerHall() {
        return hallRepository.countPresentationsPerHall();
    }

    @GetMapping("/topics")
    public List<TopicDto> getTopicList() {
        return topicRepository.findAll()
                .stream()
                .map(topicMapper::mapToDto)
                .toList();
    }
}
