package com.example.doanoopkitchenmanage.service.ingredient.impl;

import com.example.doanoopkitchenmanage.model.Checklist;
import com.example.doanoopkitchenmanage.model.Ingredient;
import com.example.doanoopkitchenmanage.model.Report;
import com.example.doanoopkitchenmanage.repository.IngredientRepository;
import com.example.doanoopkitchenmanage.service.ingredient.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Optional<Ingredient> findById(Long id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Override
    public void remove(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public Iterable<Ingredient> findAllByChecklist(Checklist checklist) {
        return ingredientRepository.findAllByChecklist(checklist);
    }

    @Override
    public Iterable<Ingredient> findAllByReport(Report report) {
        return ingredientRepository.findAllByReport(report);
    }
}
