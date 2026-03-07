package com.camach.task_flow.infrastructure.repository;

import com.camach.task_flow.infrastructure.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task, Long> {
}
