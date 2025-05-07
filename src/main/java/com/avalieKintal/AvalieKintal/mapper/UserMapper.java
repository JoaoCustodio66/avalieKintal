package com.avalieKintal.AvalieKintal.mapper;
import com.avalieKintal.AvalieKintal.dto.RequestUserDto;
import com.avalieKintal.AvalieKintal.dto.ResponseUserDto;
import com.avalieKintal.AvalieKintal.entity.User;

public class UserMapper {

    public static ResponseUserDto toResponse(User user) {
        if (user == null) {
            return null;
        }
        return new ResponseUserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getStatus()
        );
    }

    public static User toEntity(RequestUserDto dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setName(dto.name());
        user.setPhone(dto.phone());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setStatus(dto.status());
        return user;
    }
}
