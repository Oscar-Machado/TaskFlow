package com.camach.task_flow.mapper;

import com.camach.task_flow.dto.task.TaskRequestDTO;
import com.camach.task_flow.dto.task.TaskResponseDTO;
import com.camach.task_flow.infrastructure.entity.Task;
import com.camach.task_flow.infrastructure.entity.User;

public class TaskMapper {

    //Converter RequestDTO -> Entity
    public static Task toEntity(TaskRequestDTO dto){

        //Relacionamento com task
        Task task = new Task();

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDeadline(dto.getDeadline());
        task.setPriority(dto.getPriority());

        //relacionamento com user
        User user = new User();

        user.setId(dto.getUserId());

        task.setUser(user);

        return task;
    }

    //Converter Entity -> ResponseDTO
    public static TaskResponseDTO toDTO(Task task){

        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setDeadline(task.getDeadline());
        dto.setPriority(task.getPriority());

        dto.setUserId(task.getUser().getId());

        return dto;
    }
}
