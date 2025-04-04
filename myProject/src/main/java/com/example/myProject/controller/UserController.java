package com.example.myProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.myProject.dto.UserDTO;
import com.example.myProject.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

//    // 모든 사용자 조회 (GET)
//    @GetMapping
//    public List<UserDTO> getUsers() {
//        return userService.getAllUsers();
//    }
//
//    // 새로운 사용자 추가 (POST)
//    @PostMapping
//    public String addUser(@RequestBody UserDTO user) {
//        userService.addUser(user);
//        return "User added successfully!";
//    }
}