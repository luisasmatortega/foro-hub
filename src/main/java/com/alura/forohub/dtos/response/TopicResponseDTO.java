package com.alura.forohub.dtos.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TopicResponseDTO {
    private int id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private String status;
    private String author;
    private String course;
}
