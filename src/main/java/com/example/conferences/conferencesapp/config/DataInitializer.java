package com.example.conferences.conferencesapp.config;

import com.example.conferences.conferencesapp.enums.PersonType;
import com.example.conferences.conferencesapp.rdbms.models.Conference;
import com.example.conferences.conferencesapp.rdbms.models.Hall;
import com.example.conferences.conferencesapp.rdbms.models.Person;
import com.example.conferences.conferencesapp.rdbms.models.Topic;
import com.example.conferences.conferencesapp.rdbms.repositories.ConferenceRepository;
import com.example.conferences.conferencesapp.rdbms.repositories.HallRepository;
import com.example.conferences.conferencesapp.rdbms.repositories.PersonRepository;
import com.example.conferences.conferencesapp.rdbms.repositories.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(ConferenceRepository conferenceRepository, HallRepository hallRepository,
                                      PersonRepository personRepository, TopicRepository topicRepository) {
        return (args) -> {
            Hall hall1 = new Hall(null, "Sala A", 100, null);
            Hall hall2 = new Hall(null, "Sala B", 80, null);
            hallRepository.save(hall1);
            hallRepository.save(hall2);


            Person scientist = new Person(null, "test1", "test1", "test1@example.com",
                    "Poland", PersonType.SCIENTIST, null, new ArrayList<>());
            Person student = new Person(null, "test2", "test2", "test2@example.com",
                    "Poland", PersonType.STUDENT, null, new ArrayList<>());
            Person organizer = new Person(null, "test3", "test3", "test3@example.com",
                    "Poland", PersonType.ORGANIZER, null, new ArrayList<>());
            personRepository.save(scientist);
            personRepository.save(student);
            personRepository.save(organizer);

            Topic topic1 = new Topic(null, "Temat 1", "Opis tematu 1", scientist, null);
            Topic topic2 = new Topic(null, "Temat 2", "Opis tematu 2", scientist, null);
            topicRepository.save(topic1);
            topicRepository.save(topic2);

            Conference conference1 = new Conference(null,
                    List.of(scientist, student, organizer),
                    List.of(topic1, topic2), hall1);
            conferenceRepository.save(conference1);

            topic1.setConference(conference1);
            topic2.setConference(conference1);
            topicRepository.save(topic1);
            topicRepository.save(topic2);

            scientist.getConferences().add(conference1);
            student.getConferences().add(conference1);
            organizer.getConferences().add(conference1);
            personRepository.save(scientist);
            personRepository.save(student);
            personRepository.save(organizer);
        };
    }
}
