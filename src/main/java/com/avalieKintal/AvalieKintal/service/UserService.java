package com.avalieKintal.AvalieKintal.service;

import com.avalieKintal.AvalieKintal.dto.RequestUserDto;
import com.avalieKintal.AvalieKintal.dto.ResponseApi;
import com.avalieKintal.AvalieKintal.dto.ResponseUserDto;
import com.avalieKintal.AvalieKintal.entity.User;
import com.avalieKintal.AvalieKintal.mapper.UserMapper;
import com.avalieKintal.AvalieKintal.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseApi save(RequestUserDto dto){
        User user = UserMapper.toEntity(dto);
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        ResponseUserDto responseDto = UserMapper.toResponse(userRepository.save(user));
        return ResponseApi.success("Success",responseDto);
    }

}
