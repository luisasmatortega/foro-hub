package com.alura.forohub.controller;


import com.alura.forohub.dtos.request.TopicRequestDTO;
import com.alura.forohub.dtos.response.TopicResponseDTO;
import com.alura.forohub.entities.Topic;
import com.alura.forohub.repositories.TopicRepository;
import com.alura.forohub.services.TopicServices;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController
{
    private final TopicServices topicServices;


    public TopicController(TopicServices topicServices) {
        this.topicServices = topicServices;

    }

    @PostMapping
    public ResponseEntity<TopicResponseDTO> createTopic(
            @RequestBody @Valid TopicRequestDTO requestDTO
            ) {

        TopicResponseDTO responseDTO = topicServices.createTopic(requestDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<TopicResponseDTO>> listTopics(
            @PageableDefault(size = 10) Pageable pagination) {

        Page<TopicResponseDTO> page = topicServices.getAllTopics(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> getTopicById(@PathVariable Long id) {
        TopicResponseDTO responseDTO = topicServices.getTopicById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> updateTopic(
            @PathVariable Long id,
            @RequestBody @Valid TopicRequestDTO requestDTO) {

        TopicResponseDTO responseDTO = topicServices.updateTopic(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicServices.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

}
