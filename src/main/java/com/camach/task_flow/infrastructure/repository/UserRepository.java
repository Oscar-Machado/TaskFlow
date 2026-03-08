package com.camach.task_flow.infrastructure.repository;

import com.camach.task_flow.infrastructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //metodo para descobrir se o email existe
    boolean existsByEmail (String email);

}
