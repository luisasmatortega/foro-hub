package com.alura.forohub.mappers;

import com.alura.forohub.dtos.request.TopicRequestDTO;
import com.alura.forohub.dtos.response.TopicResponseDTO;
import com.alura.forohub.entities.Topic;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TopicMapper {

    public TopicResponseDTO toResponseDTO(Topic topic) {
        TopicResponseDTO dto = new TopicResponseDTO();
        dto.setId(topic.getId());
        dto.setTitle(topic.getTitle());
        dto.setMessage(topic.getMessage());
        dto.setCreationDate(topic.getCreationDate());
        dto.setStatus(topic.getStatus());
        dto.setAuthor(topic.getAuthor());
        dto.setCourse(topic.getCourse());
        return dto;
    }

    public Topic toEntity(TopicRequestDTO requestDTO) {
        Topic topic = new Topic();
        topic.setTitle(requestDTO.getTitle());
        topic.setMessage(requestDTO.getMessage());
        topic.setStatus(requestDTO.getStatus());
        topic.setAuthor(requestDTO.getAuthor());
        topic.setCourse(requestDTO.getCourse());
        topic.setCreationDate(LocalDateTime.now()); // Set creation date to now
        return topic;
    }

    public void updateEntityFromDTO(TopicRequestDTO requestDTO, Topic topic) {
        topic.setTitle(requestDTO.getTitle());
        topic.setMessage(requestDTO.getMessage());
        topic.setStatus(requestDTO.getStatus());
        topic.setAuthor(requestDTO.getAuthor());
        topic.setCourse(requestDTO.getCourse());

    }
}
