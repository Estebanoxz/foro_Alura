// TopicController.java
package com.ForoAlura.controller;

import com.ForoAlura.Service.TopicService;
import com.ForoAlura.dto.TopicRequestDTO;
import com.ForoAlura.dto.TopicResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public ResponseEntity<TopicResponseDTO> createTopic(@RequestBody TopicRequestDTO request) {
        TopicResponseDTO newTopic = topicService.createTopic(request);
        return ResponseEntity.ok(newTopic);
    }

    @GetMapping
    public ResponseEntity<List<TopicResponseDTO>> getAllTopics() {
        List<TopicResponseDTO> topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }
}
