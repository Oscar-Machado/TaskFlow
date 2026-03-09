package com.camach.task_flow.mapper;

import com.camach.task_flow.dto.user.UserRequestDTO;
import com.camach.task_flow.dto.user.UserResponseDTO;
import com.camach.task_flow.infrastructure.entity.User;

public class UserMapper {

    //DTO -> Entity
    public static User toEntity(UserRequestDTO dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return user;
    }

    //Entity -> Entity
    public static UserResponseDTO toDTO (User user){

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        return dto;
    }

}
