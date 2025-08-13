package com.foro.controller;

import com.ForoAlura.dto.TopicRequestDTO;
import com.ForoAlura.dto.TopicResponseDTO;
import com.ForoAlura.model.topic.TopicService;
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

    @GetMapping
    public ResponseEntity<List<TopicResponseDTO>> listar() {
        return ResponseEntity.ok(topicService.listar());
    }

    @PostMapping
    public ResponseEntity<TopicResponseDTO> registrar(@RequestBody TopicRequestDTO dto) {
        return ResponseEntity.ok(topicService.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> actualizar(@PathVariable Long id, @RequestBody TopicRequestDTO dto) {
        TopicResponseDTO actualizado = topicService.actualizar(id, dto);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (topicService.eliminar(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
