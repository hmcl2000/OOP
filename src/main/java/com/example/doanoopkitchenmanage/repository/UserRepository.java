package com.example.doanoopkitchenmanage.repository;

import com.example.doanoopkitchenmanage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
