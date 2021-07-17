package com.example.doanoopkitchenmanage.service.user;

import com.example.doanoopkitchenmanage.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
