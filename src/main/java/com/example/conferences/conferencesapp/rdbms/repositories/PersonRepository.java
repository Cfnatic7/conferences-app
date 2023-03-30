package com.example.conferences.conferencesapp.rdbms.repositories;

import com.example.conferences.conferencesapp.enums.PersonType;
import com.example.conferences.conferencesapp.rdbms.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByPersonType(@NonNull PersonType personType);

    List<Person> findByNationality(@NonNull String nationality);

    @Query("SELECT p FROM Person p WHERE SIZE(p.topics) = (SELECT MAX(SIZE(p2.topics)) FROM Person p2)")
    Person findPersonWithMostPresentations();
}