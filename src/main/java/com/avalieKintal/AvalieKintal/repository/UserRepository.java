package com.avalieKintal.AvalieKintal.repository;

import com.avalieKintal.AvalieKintal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByPhone(String phone);
}
