package com.example.doanoopkitchenmanage.service.checklist.impl;

import com.example.doanoopkitchenmanage.model.Checklist;
import com.example.doanoopkitchenmanage.repository.ChecklistRepository;
import com.example.doanoopkitchenmanage.service.checklist.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ChecklistServiceImplement implements ChecklistService {
    @Autowired
    private ChecklistRepository checklistRepository;

    @Override
    public Iterable<Checklist> findAll() {
        return checklistRepository.findAll();
    }

    @Override
    public Optional<Checklist> findById(Long id) {
        return checklistRepository.findById(id);
    }

    @Override
    public void save(Checklist checklist) {
        checklistRepository.save(checklist);
    }

    @Override
    public void remove(Long id) {
        checklistRepository.deleteById(id);
    }

}
