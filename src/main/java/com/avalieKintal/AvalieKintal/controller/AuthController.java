package com.avalieKintal.AvalieKintal.controller;

import com.avalieKintal.AvalieKintal.dto.RequestLoginDto;
import com.avalieKintal.AvalieKintal.dto.ResponseApi;
import com.avalieKintal.AvalieKintal.dto.ResponseLoginDto;
import com.avalieKintal.AvalieKintal.entity.User;
import com.avalieKintal.AvalieKintal.service.TokenService;
import com.avalieKintal.AvalieKintal.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseApi login(@RequestBody RequestLoginDto loginRequest) {
        User user = userRepository.findByPhone(loginRequest.phone())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = tokenService.generateToken(user);

        ResponseLoginDto dto = new ResponseLoginDto(token);
        return ResponseApi.success("Success",dto);
    }
}