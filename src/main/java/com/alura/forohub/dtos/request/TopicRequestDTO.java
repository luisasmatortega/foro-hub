package com.alura.forohub.dtos.request;


import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TopicRequestDTO {
    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Message is mandatory")
    @Size(min = 10, message = "Message must be at least 10 characters")
    private String message;

    @NotNull(message = "Status is mandatory")
    private String status;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @NotBlank(message = "Course is mandatory")
    private String course;
}
