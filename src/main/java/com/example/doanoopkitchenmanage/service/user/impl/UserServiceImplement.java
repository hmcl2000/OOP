package com.example.doanoopkitchenmanage.service.user.impl;

import com.example.doanoopkitchenmanage.model.User;
import com.example.doanoopkitchenmanage.repository.UserRepository;
import com.example.doanoopkitchenmanage.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository repository;
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
