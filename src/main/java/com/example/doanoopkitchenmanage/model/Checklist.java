package com.example.doanoopkitchenmanage.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "checklist")
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dateCreated;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @OneToMany(targetEntity = Ingredient.class)
    private List<Ingredient> ingredients;


    public Checklist() {
    }

    public Checklist(Long id, Long numberImport, Long numberBegin, Long numberEnd, String dateCreated, Employee employee, List<Ingredient> ingredients) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.employee = employee;
        this.ingredients = ingredients;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
