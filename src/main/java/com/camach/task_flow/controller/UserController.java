package com.camach.task_flow.controller;

import com.camach.task_flow.dto.user.UserRequestDTO;
import com.camach.task_flow.dto.user.UserResponseDTO;
import com.camach.task_flow.infrastructure.entity.User;
import com.camach.task_flow.mapper.UserMapper;
import com.camach.task_flow.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //Criar User
    @PostMapping
    public UserResponseDTO creatUser (@RequestBody @Valid UserRequestDTO dto){

        User user = UserMapper.toEntity(dto);

        User savedUser = userService.createUser(user);

        return UserMapper.toDTO(savedUser);

    }

    //Listar User
    @GetMapping
    public List<UserResponseDTO> getAllUsers(){

        return userService.getAllUsers()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());

    }

    //Buscar ByID
    @GetMapping("/{id}")
    public UserResponseDTO getUserById (@PathVariable Long id){

        User user = userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        return UserMapper.toDTO(user);

    }

    //Atualizar User
    @PutMapping("/{id}")
    public UserResponseDTO updateUser (@PathVariable Long id,
                                       @RequestBody UserRequestDTO dto){
        User user = UserMapper.toEntity(dto);
        user.setId(id);

        User updatedUser = userService.updateUser(user);

        return UserMapper.toDTO(updatedUser);

    }

    // Deletar usuário
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
