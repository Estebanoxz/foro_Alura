// TopicRequestDTO.java
package com.ForoAlura.dto;

import lombok.Data;

@Data
public class TopicRequestDTO {
    private String title;
    private String message;
    private String author;
    private String course;
}
