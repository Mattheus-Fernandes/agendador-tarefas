package com.mattheusfernandes.agendadortarefas.infrastructure.security;


import com.mattheusfernandes.agendadortarefas.business.UserDTO;
import com.mattheusfernandes.agendadortarefas.infrastructure.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl  {

    @Autowired
    private UserClient userClient;

    public UserDetails loadDataUser(String token, String email) {

        UserDTO userDTO = userClient.findUserByEmail(email, token);

        return User
                .withUsername(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();

    }
}
