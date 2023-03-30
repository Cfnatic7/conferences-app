package com.example.conferences.conferencesapp.rdbms.repositories;

import com.example.conferences.conferencesapp.rdbms.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {

    @Query("SELECT h.name, COUNT(c) FROM Hall h JOIN h.conferences c GROUP BY h")
    List<Object[]> countPresentationsPerHall();
}