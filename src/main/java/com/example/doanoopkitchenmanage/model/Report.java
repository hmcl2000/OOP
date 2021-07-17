package com.example.doanoopkitchenmanage.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dateCreated;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @OneToMany(targetEntity = Ingredient.class, cascade = {CascadeType.ALL})
    private List<Ingredient> ingredients;

    public Report() {
    }

    public Report(Long id, String dateCreated, Employee employee, List<Ingredient> ingredients) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.employee = employee;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

