package com.example.doanoopkitchenmanage.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee", schema = "kitchen-manage-do-an")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "number_contact")
    private String numberContact;
    @Column(name = "shift")
    private String shift;
    @Column(name = "salary")
    private String salary;
    @OneToMany(targetEntity = Checklist.class)
    private List<Checklist> checklists;
    @OneToMany(targetEntity = MainIngredient.class)
    private List<MainIngredient> mainIngredients;
    @OneToMany(targetEntity = Report.class)
    private List<Report> reports;

    public Employee() {
    }

    public Employee(Long id, String name, String numberContact, String shift, String salary, List<Checklist> checklists, List<MainIngredient> mainIngredients, List<Report> reports) {
        this.id = id;
        this.name = name;
        this.numberContact = numberContact;
        this.shift = shift;
        this.salary = salary;
        this.checklists = checklists;
        this.mainIngredients = mainIngredients;
        this.reports = reports;
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

    public String getNumberContact() {
        return numberContact;
    }

    public void setNumberContact(String numberContact) {
        this.numberContact = numberContact;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public List<Checklist> getChecklists() {
        return checklists;
    }

    public void setChecklists(List<Checklist> checklists) {
        this.checklists = checklists;
    }

    public List<MainIngredient> getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(List<MainIngredient> mainIngredients) {
        this.mainIngredients = mainIngredients;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
