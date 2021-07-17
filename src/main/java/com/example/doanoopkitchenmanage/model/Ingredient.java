package com.example.doanoopkitchenmanage.model;

import javax.persistence.*;

@Entity
@Table(name = "ingredient_for_day")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long amountBegin;
    private Long amountEnd;
    @ManyToOne
    @JoinColumn(name = "checklist_id")
    private Checklist checklist;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;

    public Ingredient() {
    }

    public Ingredient(Long id, String name, Long amountBegin, Long amountEnd, Checklist checklist, Report report) {
        this.id = id;
        this.name = name;
        this.amountBegin = amountBegin;
        this.amountEnd = amountEnd;
        this.checklist = checklist;
        this.report = report;
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

    public Long getAmountBegin() {
        return amountBegin;
    }

    public void setAmountBegin(Long amountBegin) {
        this.amountBegin = amountBegin;
    }

    public Long getAmountEnd() {
        return amountEnd;
    }

    public void setAmountEnd(Long amountEnd) {
        this.amountEnd = amountEnd;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
