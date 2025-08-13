package com.ForoAlura.Service;

import com.ForoAlura.Repository.TopicRepository;
import com.ForoAlura.dto.TopicRequestDTO;
import com.ForoAlura.dto.TopicResponseDTO;
import com.ForoAlura.model.topic.Topic;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    public TopicResponseDTO createTopic(TopicRequestDTO request) {
        Topic topic = new Topic();
        topic.setTitle(request.getTitle());
        topic.setMessage(request.getMessage());
        topic.setAuthor(request.getAuthor());
        topic.setCourse(request.getCourse());

        Topic savedTopic = topicRepository.save(topic);

        return new TopicResponseDTO(
                savedTopic.getId(),
                savedTopic.getTitle(),
                savedTopic.getMessage(),
                savedTopic.getAuthor(),
                savedTopic.getCourse()
        );
    }

    public List<TopicResponseDTO> getAllTopics() {
        return topicRepository.findAll()
                .stream()
                .map(t -> new TopicResponseDTO(
                        t.getId(),
                        t.getTitle(),
                        t.getMessage(),
                        t.getAuthor(),
                        t.getCourse()
                ))
                .collect(Collectors.toList());
    }


    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
