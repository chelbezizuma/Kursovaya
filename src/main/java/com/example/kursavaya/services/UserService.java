package com.example.kursavaya.services;


import com.example.kursavaya.entity.Users;
import com.example.kursavaya.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<Users> listUser() {
        return userRepository.findAll();
    }

    public Users getUsers(String login) {
        return userRepository.findByLogin(login);
    }

    public List<String> distinctByGroup_id() {
        return userRepository.distinctByGroup_id();
    }
    public void saveUser(Users users) {
        userRepository.save(users);
    }

    public void addUser(Users users) {
        userRepository.save(users);
    }
}
