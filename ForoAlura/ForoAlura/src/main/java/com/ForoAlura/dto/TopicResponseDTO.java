// TopicResponseDTO.java
package com.ForoAlura.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopicResponseDTO {
    private Long id;
    private String title;
    private String message;
    private String author;
    private String course;
}

