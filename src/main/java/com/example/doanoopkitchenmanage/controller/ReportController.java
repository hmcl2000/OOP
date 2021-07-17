package com.example.doanoopkitchenmanage.controller;

import com.example.doanoopkitchenmanage.model.Checklist;
import com.example.doanoopkitchenmanage.model.Employee;
import com.example.doanoopkitchenmanage.model.Ingredient;
import com.example.doanoopkitchenmanage.model.Report;
import com.example.doanoopkitchenmanage.service.checklist.ChecklistService;
import com.example.doanoopkitchenmanage.service.employee.EmployeeService;
import com.example.doanoopkitchenmanage.service.ingredient.IngredientService;
import com.example.doanoopkitchenmanage.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.Optional;

@Controller
public class ReportController {
    @Autowired
    ReportService reportService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    IngredientService ingredientService;
    @Autowired
    ChecklistService checklistService;
    @ModelAttribute("employees")
    public Iterable<Employee> employees() {
        return employeeService.findAll();
    }
    @GetMapping("/home/report")
    public String index(Model model) {
        model.addAttribute("reports", reportService.findAll());
        return "report/list";
    }
    //-----CREATE NEW REPORT
    @GetMapping("/home/report/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("report/create");
        modelAndView.addObject("report", new Report());
        return modelAndView;
    }
    @PostMapping("/home/report/save")
    public String save(Report report, RedirectAttributes redirectAttributes) {
        reportService.save(report);
        redirectAttributes.addFlashAttribute("message", "Created report successfully!");
        return "redirect:/home/report";
    }
    //-----VIEW REPORT
    @GetMapping("/home/report/{id}/view")
    public ModelAndView viewReport(@PathVariable("id") Long id) {
        Optional<Report> reportOptional = reportService.findById(id);
        if (!reportOptional.isPresent()) {
            return new ModelAndView("/error.404");
        }
        Iterable<Ingredient> ingredients = ingredientService.findAllByReport(reportOptional.get());
        ModelAndView modelAndView = new ModelAndView("/report/view");
        modelAndView.addObject("id", reportOptional.get().getId());
        modelAndView.addObject("report", reportOptional.get());
        modelAndView.addObject("ingredients", ingredients);
        return modelAndView;
    }

    //-----CREATE NEW INGREDIENT IN report
    @GetMapping("/home/report/{id}/create/ingredient")
    public ModelAndView createIngredient(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView("report/create-ingredient");
        modelAndView.addObject("id", id);
        Optional<Report> report = reportService.findById(id);
        Ingredient ingredient = new Ingredient();
        ingredient.setReport(report.get());
        modelAndView.addObject("ingredient", ingredient);
        return modelAndView;
    }
    @PostMapping("/home/report/{id}/save/ingredient")
    public String save(@PathVariable Long id, Ingredient ingredient, RedirectAttributes redirectAttributes) {
        ingredientService.save(ingredient);
        redirectAttributes.addFlashAttribute("message", "Created report successfully!");
        return "redirect:/home/report/{id}/create/ingredient";
    }

    //-----EDIT INGREDIENT IN report
    @GetMapping("/home/report/{id}/view/edit/{id2}")
    public ModelAndView editIngredient(@PathVariable("id") Long id, @PathVariable("id2") Long id2) {
        Optional<Ingredient> ingredient = ingredientService.findById(id2);
        ModelAndView modelAndView = new ModelAndView("report/edit-ingredient");
        modelAndView.addObject("id", id);
        modelAndView.addObject("ingredient", ingredient.get());
        return modelAndView;
    }

    @PostMapping("/home/report/{id}/view/update/{id2}")
    public String update(@PathVariable("id") Long id, @PathVariable("id2") Long id2, Ingredient ingredient, RedirectAttributes redirectAttributes) {
        ingredientService.save(ingredient);
        redirectAttributes.addFlashAttribute("message", "Update ingredient successfully");
        return "redirect:/home/report/{id}/view/edit/{id2}";
    }
    //-----DELETE INGREDIENT IN report
    @GetMapping("/home/report/{id}/view/delete/{id2}")
    public ModelAndView deleteIngredient(@PathVariable("id") Long id, @PathVariable("id2") Long id2) {
        Optional<Ingredient> ingredient = ingredientService.findById(id2);
        ModelAndView modelAndView = new ModelAndView("report/delete-ingredient");
        modelAndView.addObject("id", id);
        modelAndView.addObject("ingredient", ingredient.get());
        return modelAndView;
    }
    @PostMapping("/home/report/{id}/view/delete/{id2}")
    public String deleteIngredient(@PathVariable("id") Long id, @PathVariable("id2") Long id2, Ingredient ingredient, RedirectAttributes redirectAttributes) {
        ingredientService.remove(id2);
        redirectAttributes.addFlashAttribute("message", "Delete ingredient successfully");
        return "redirect:/home/report/{id}/view";
    }

    //-----DELETE REPORT
    @GetMapping("/home/report/{id}/delete")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Optional<Report> report = reportService.findById(id);
        ModelAndView modelAndView = new ModelAndView("report/delete");
        modelAndView.addObject("report", report.get());
        return modelAndView;
    }
    @PostMapping("/home/report/delete")
    public String delete(Report report, RedirectAttributes redirectAttributes) {
        reportService.remove(report.getId());
        redirectAttributes.addFlashAttribute("message", "Delete report successfully");
        return "redirect:/home/report";
    }
}
