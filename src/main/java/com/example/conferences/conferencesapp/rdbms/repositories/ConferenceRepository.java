package com.example.conferences.conferencesapp.rdbms.repositories;

import com.example.conferences.conferencesapp.rdbms.models.Conference;
import com.example.conferences.conferencesapp.rdbms.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {

    @Query("SELECT c.participants FROM Conference c WHERE c.id = :conferenceId")
    List<Person> findAllParticipantsByConferenceId(@Param("conferenceId") Long conferenceId);
}