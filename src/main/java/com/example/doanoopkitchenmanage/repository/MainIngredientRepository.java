package com.example.doanoopkitchenmanage.repository;

import com.example.doanoopkitchenmanage.model.MainIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainIngredientRepository extends JpaRepository<MainIngredient, Long> {
}
