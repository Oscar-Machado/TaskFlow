package com.camach.task_flow.infrastructure.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor //Contrutor com tudo
@NoArgsConstructor //Contrutor vazio
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Para gerar automaticamento o ID
    private Long id;

    @Email
    @NotBlank //Não permitir que o valor seja null
    @Column(unique = true)
    private String email;

    @NotBlank
    private String name;

    @OneToMany (mappedBy = "user") //Permite que o user use a FK criada em Task.java
                                   // sem criar uma nova coluna
    @JsonIgnore
    private List<Task> tasks;

    private LocalDateTime horaInsercao = LocalDateTime.now();

}
