package com.example.conferences.conferencesapp.mappers;

import com.example.conferences.conferencesapp.dtos.TopicDto;
import com.example.conferences.conferencesapp.rdbms.models.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TopicMapper {

    private final PersonMapper personMapper;

    public TopicDto mapToDto(Topic topic) {
        return TopicDto
                .builder()
                .title(topic.getTitle())
                .description(topic.getDescription())
                .presenter(personMapper.mapToDto(topic.getPresenter()))
                .build();
    }
}
