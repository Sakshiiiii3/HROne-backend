package com.example.hrone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrone.entity.Login;
import com.example.hrone.service.LoginService;

@RestController
@RequestMapping("/api/v1/register")
public class RegisterController {

    @Autowired
    private LoginService loginService;

    // POST method for registering a new user
    @PostMapping
    public ResponseEntity<Login> registerUser(@RequestBody Login login) {
        Login savedUser = loginService.saveUser(login);
        return ResponseEntity.ok(savedUser);
    }

    // GET method for fetching all registered users
    @GetMapping
    public ResponseEntity<List<Login>> getAllUsers() {
        List<Login> users = loginService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
