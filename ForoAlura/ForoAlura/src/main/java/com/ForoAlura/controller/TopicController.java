package com.foro.controller;

import com.foro.dto.TopicRequestDTO;
import com.foro.dto.TopicResponseDTO;
import com.foro.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<TopicResponseDTO> getTopics() {
        return topicService.listAll();
    }

    @PostMapping
    public TopicResponseDTO createTopic(@RequestBody TopicRequestDTO dto) {
        return topicService.createTopic(dto);
    }
}