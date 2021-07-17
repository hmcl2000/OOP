package com.example.doanoopkitchenmanage.service.mainIngredient.impl;

import com.example.doanoopkitchenmanage.model.MainIngredient;
import com.example.doanoopkitchenmanage.repository.MainIngredientRepository;
import com.example.doanoopkitchenmanage.service.mainIngredient.MainIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainIngredientServiceImpl implements MainIngredientService {
    @Autowired
    MainIngredientRepository mainIngredientRepository;

    @Override
    public Iterable<MainIngredient> findAll() {
        return mainIngredientRepository.findAll();
    }

    @Override
    public Optional<MainIngredient> findById(Long id) {
        return mainIngredientRepository.findById(id);
    }

    @Override
    public void save(MainIngredient mainIngredient) {
        mainIngredientRepository.save(mainIngredient);
    }

    @Override
    public void remove(Long id) {
        mainIngredientRepository.deleteById(id);
    }
}
