package com.example.dijagnosticki.service;


import com.example.dijagnosticki.model.User;


public interface AuthService {

    User login (String username, String password);
}
