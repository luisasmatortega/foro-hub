package com.alura.forohub.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "topics")
public class Topic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    @Column(unique = true)
    private String title;

    @NotBlank(message = "Message is mandatory")
    @Size(min = 10, message = "Message must be at least 10 characters")
    @Column(unique = true)
    private String message;

    @NotNull(message = "Creation date is mandatory")
    private LocalDateTime creationDate;

    @NotBlank(message = "Status is mandatory")
    private String status;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @NotBlank(message = "Course is mandatory")
    private String course;
}

