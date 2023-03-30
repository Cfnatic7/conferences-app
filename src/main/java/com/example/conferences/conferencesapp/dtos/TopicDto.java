package com.example.conferences.conferencesapp.dtos;

import com.example.conferences.conferencesapp.rdbms.models.Person;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicDto {

    private String title;
    private String description;
    private PersonDto presenter;
}
