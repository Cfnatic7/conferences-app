package com.example.conferences.conferencesapp.mappers;

import com.example.conferences.conferencesapp.dtos.PersonDto;
import com.example.conferences.conferencesapp.rdbms.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper {

    public PersonDto mapToDto(Person person) {
        return PersonDto
                .builder()
                .personType(person.getPersonType())
                .email(person.getEmail())
                .name(person.getName())
                .surname(person.getSurname())
                .nationality(person.getNationality())
                .build();
    }
}
