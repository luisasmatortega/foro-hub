package com.alura.forohub.services;


import com.alura.forohub.dtos.request.TopicRequestDTO;
import com.alura.forohub.dtos.response.TopicResponseDTO;
import com.alura.forohub.entities.Topic;
import com.alura.forohub.exceptions.ResourceNotFoundException;
import com.alura.forohub.mappers.TopicMapper;
import com.alura.forohub.repositories.TopicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicServices
{
    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;



    public TopicServices(TopicRepository topicRepository, TopicMapper topicMapper) {
        this.topicRepository = topicRepository;
        this.topicMapper = topicMapper;
    }

    @Transactional
    public TopicResponseDTO createTopic(TopicRequestDTO requestDTO) {
        Topic topic = topicMapper.toEntity(requestDTO);
        topic = topicRepository.save(topic);
        return topicMapper.toResponseDTO(topic);
    }

    @Transactional(readOnly = true)
    public Page<TopicResponseDTO> getAllTopics(Pageable pagination) {
        return topicRepository.findAll(pagination)
                .map(topicMapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public TopicResponseDTO getTopicById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topic not found with id: " + id));
        return topicMapper.toResponseDTO(topic);
    }

    @Transactional
    public TopicResponseDTO updateTopic(Long id, TopicRequestDTO requestDTO) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topic not found with id: " + id));

        topicMapper.updateEntityFromDTO(requestDTO, topic);
        topic = topicRepository.save(topic);
        return topicMapper.toResponseDTO(topic);
    }

    @Transactional
    public void deleteTopic(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topic not found with id: " + id));

        topicRepository.delete(topic);
    }


}
