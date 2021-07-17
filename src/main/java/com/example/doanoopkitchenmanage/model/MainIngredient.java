package com.example.doanoopkitchenmanage.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "main_ingredient")
public class MainIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long amount;
    private String dateImport;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public MainIngredient() {
    }

    public MainIngredient(Long id, String name, Long amount, String dateImport, Employee employee) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.dateImport = dateImport;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDateImport() {
        return dateImport;
    }

    public void setDateImport(String dateImport) {
        this.dateImport = dateImport;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
