package com.example.kursavaya.controller;

import com.example.kursavaya.entity.Users;
import com.example.kursavaya.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userAreaService;
    @CrossOrigin
    @GetMapping("/")
    public List<Users> getAllUsers() {
        return userAreaService.listUser();
    }

    @CrossOrigin
    @GetMapping("/getUsers")
    public Users getUsers(@RequestParam() String login) {
        if (userAreaService.getUsers(login) != null)
        return userAreaService.getUsers(login);
        else
            return new Users(-1L,"Пользоватлеь не найден","Пользоватлеь не найден","Пользоватлеь не найден","Пользоватлеь не найден","Пользоватлеь не найден");
    }

    @CrossOrigin
    @GetMapping("/getGroups")
    public List<String> getGroupList() {
        return userAreaService.distinctByGroup_id();
     }

    @CrossOrigin
    @PostMapping("/addUser")
    public void post(@RequestParam Map<String, String> usersMap) {
        Users users = new Users(
                usersMap.get("group_id"),
                usersMap.get("role"),
                usersMap.get("name"),
                usersMap.get("login"),
                usersMap.get("password")
        );
        System.out.println(usersMap);
        userAreaService.addUser(users);
    }
}

