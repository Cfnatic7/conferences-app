package com.example.conferences.conferencesapp.dtos;

import com.example.conferences.conferencesapp.enums.PersonType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private String name;
    private String surname;
    private String email;

    private String nationality;

    private PersonType personType;
}
