package com.avalieKintal.AvalieKintal.controller;

import com.avalieKintal.AvalieKintal.dto.RequestUserDto;
import com.avalieKintal.AvalieKintal.dto.ResponseApi;
import com.avalieKintal.AvalieKintal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseApi> create(@RequestBody RequestUserDto dto){
        ResponseApi response = userService.save(dto);
        return ResponseEntity.status(response.status()).body(response);
    }


}
