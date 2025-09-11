package com.mattheusfernandes.agendadortarefas.infrastructure.client;

import com.mattheusfernandes.agendadortarefas.business.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user", url = "${user.url}")
public interface UserClient {

    @GetMapping("/usuario")
    UserDTO findUserByEmail(@RequestParam("email") String email, @RequestHeader("Authorization") String token);
}
