package com.camach.task_flow.service;

import com.camach.task_flow.infrastructure.entity.User;
import com.camach.task_flow.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //injecao de dependencias
public class UserService {

    private final UserRepository userRepository; //O final significa que ela será iniciada apenas no construtor

    //Vamos fazer a criação dos metodos, será curto porque o JpaRepository já criou para nós os metodos

    //Criar Usuário
    public User createUser(User user){
        String email = user.getEmail(); //criar uma variavel para essa funcao, assim fica mais legivel
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }

    //Listar Usuarios
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //Buscar por ID
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    //Atualizar User
    public User updateUser(User user){
        //Verificar se o user existe antes
        if(!userRepository.existsById(user.getId())) {
            throw new RuntimeException("User Not Found");
        }
        return userRepository.save(user);
    }

    //Apagar Usuario usando o ID
    public void deleteUser(Long id){
        //Verificar se o user existe antes
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User Not Found");
        }
        userRepository.deleteById(id);
    }


}
