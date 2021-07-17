package com.example.doanoopkitchenmanage.service.employee.impl;

import com.example.doanoopkitchenmanage.model.Employee;
import com.example.doanoopkitchenmanage.repository.EmployeeRepository;
import com.example.doanoopkitchenmanage.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement implements EmployeeService {
    @Autowired
    EmployeeRepository repository;
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
