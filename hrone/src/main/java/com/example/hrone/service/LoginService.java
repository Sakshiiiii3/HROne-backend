package com.example.hrone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrone.entity.Login;
import com.example.hrone.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login saveUser(Login login) {
        return loginRepository.save(login);
    }

    public List<Login> getAllUsers() {
        return loginRepository.findAll();
    }
}
