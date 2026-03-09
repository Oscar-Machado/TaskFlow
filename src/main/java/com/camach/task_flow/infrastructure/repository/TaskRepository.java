package com.camach.task_flow.infrastructure.repository;

import com.camach.task_flow.infrastructure.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task, Long> {

    //buscar tarefas por usuario seguindo a regra de negocios
    List<Task> findByUserIdOrderByDeadlineAscPriorityDesc(Long userId);

    //buscar todas as tarefas seguindo a regra de negocios
    List<Task> findAllByOrderByDeadlineAscPriorityDesc();

}
