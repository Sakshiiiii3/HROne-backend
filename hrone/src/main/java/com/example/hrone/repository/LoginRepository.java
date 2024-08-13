/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

 package com.example.hrone.repository;

 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

import com.example.hrone.entity.Login;
 //import com.example.entity.Employee;
 /**
  *
  * @author ATS
  */
 @Repository
 public interface LoginRepository extends JpaRepository<Login, Long>{
    boolean existsByEmail(String email);
    //Login findByUsername(String username);
 }