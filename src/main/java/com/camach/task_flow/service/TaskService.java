package com.camach.task_flow.service;

import com.camach.task_flow.infrastructure.entity.Task;
import com.camach.task_flow.infrastructure.repository.TaskRepository;
import com.camach.task_flow.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //injecao de dependencias
public class TaskService {

    private final TaskRepository taskRepository; //O final significa que ela será iniciada apenas no construtor
    private final UserRepository userRepository;

    //Vamos fazer a criação dos metodos, será curto porque o JpaRepository já criou para nós os metodos

    //Criar Task
    public Task createTask (Task task){

        Long userId = task.getUser().getId();

        //Verificar se o user existe antes
        if(!userRepository.existsById(userId)){
            throw new RuntimeException("User Not Found");
        }

        return taskRepository.save(task);
    }

    //Atualizar Task
    public Task updateTask (Task task){

        //Verificar se a task existe antes
        if(!taskRepository.existsById(task.getId())){
            throw new RuntimeException("Task Not Found");
        }
        return taskRepository.save(task);
    }

    //Deletar Task
    public void deleteTask (Long id){
        //Verificar se a task existe antes
        if(!taskRepository.existsById(id)){
            throw new RuntimeException("Task Not Found");
        }
        taskRepository.deleteById(id);
    }

    //Ordem de Validade e Prioridade Geral
    public List<Task> getAllTasks (){
        return taskRepository.findAllByOrderByDeadlineAscPriorityDesc();
    }

    //Ordem de Validade e Prioriadade por Usuário
    public List<Task> getTasksByUserId
    (Long userId){
        return taskRepository.findByUserIdOrderByDeadlineAscPriorityDesc(userId);
    }
}
