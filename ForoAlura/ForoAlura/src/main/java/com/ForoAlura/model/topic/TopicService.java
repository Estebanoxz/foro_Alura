package com.ForoAlura.model.topic;

import com.ForoAlura.dto.TopicRequestDTO;
import com.ForoAlura.dto.TopicResponseDTO;
import com.ForoAlura.model.topic.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> lista = new ArrayList<>();

    public List<TopicResponseDTO> listar() {
        return lista.stream().map(this::convertirADTO).toList();
    }

    public TopicResponseDTO registrar(TopicRequestDTO dto) {
        Topic t = new Topic();
        t.setId((long) (lista.size() + 1));
        t.setTitulo(dto.getTitulo());
        t.setContenido(dto.getContenido());
        lista.add(t);
        return convertirADTO(t);
    }

    public TopicResponseDTO actualizar(Long id, TopicRequestDTO dto) {
        for (Topic t : lista) {
            if (t.getId().equals(id)) {
                t.setTitulo(dto.getTitulo());
                t.setContenido(dto.getContenido());
                return convertirADTO(t);
            }
        }
        return null;
    }

    public boolean eliminar(Long id) {
        return lista.removeIf(t -> t.getId().equals(id));
    }

    private TopicResponseDTO convertirADTO(Topic t) {
        TopicResponseDTO dto = new TopicResponseDTO();
        dto.setId(t.getId());
        dto.setTitulo(t.getTitulo());
        dto.setContenido(t.getContenido());
        return dto;
    }
}
