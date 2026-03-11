package com.camach.task_flow.controller;

import com.camach.task_flow.dto.task.TaskRequestDTO;
import com.camach.task_flow.dto.task.TaskResponseDTO;
import com.camach.task_flow.infrastructure.entity.Task;
import com.camach.task_flow.mapper.TaskMapper;
import com.camach.task_flow.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // Criar task
    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO dto){

        Task task = TaskMapper.toEntity(dto);

        Task savedTask = taskService.createTask(task);

        return TaskMapper.toDTO(savedTask);

    }

    // Listar todas tasks
    @GetMapping
    public List<TaskResponseDTO> getAllTasks(){

        return taskService.getAllTasks()
                .stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());

    }

    // Buscar tasks por usuário
    @GetMapping("/user/{userId}")
    public List<TaskResponseDTO> getTasksByUser(@PathVariable Long userId){

        return taskService.getTasksByUserId(userId)
                .stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());

    }

    // Atualizar task
    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable Long id,
                                      @RequestBody TaskRequestDTO dto){

        Task task = TaskMapper.toEntity(dto);
        task.setId(id);

        Task updatedTask = taskService.updateTask(task);

        return TaskMapper.toDTO(updatedTask);

    }

    // Deletar task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);

    }

}