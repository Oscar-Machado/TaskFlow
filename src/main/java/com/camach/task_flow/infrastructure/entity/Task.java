package com.camach.task_flow.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor //Contrutor com tudo
@NoArgsConstructor //Contrutor vazio
@Table (name = "tasks")
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @Column (length = 500)
    private String description;

    @NotNull
    private LocalDate deadline;

    @NotNull
    @Min(value = 1, message = "The minimum value is 1")
    @Max(value = 3, message = "O maximum value is 3")
    private Integer priority;

    @ManyToOne //indica um user pode ter varias tasks
    @JoinColumn (name = "user_id") //cria a FK user_id
    private User user; //criar uma entidade que pertence à User

    private LocalDateTime horaInsercao = LocalDateTime.now();
}
