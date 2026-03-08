package com.camach.task_flow.dto.task;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequestDTO {

    private String title;

    private String description;

    private LocalDate deadline;

    private Integer priority;

    private Long userId;

}
