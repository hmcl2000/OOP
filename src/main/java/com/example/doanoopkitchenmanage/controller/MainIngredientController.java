package com.example.doanoopkitchenmanage.controller;


import com.example.doanoopkitchenmanage.model.Checklist;
import com.example.doanoopkitchenmanage.model.Employee;
import com.example.doanoopkitchenmanage.model.MainIngredient;
import com.example.doanoopkitchenmanage.service.employee.EmployeeService;
import com.example.doanoopkitchenmanage.service.mainIngredient.MainIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class MainIngredientController {
    @Autowired
    MainIngredientService mainIngredientService;
    @Autowired
    EmployeeService employeeService;
    @ModelAttribute("employees")
    public Iterable<Employee> employees() {
        return employeeService.findAll();
    }
    //-----HOME INGREDIENT
    @GetMapping("/home/main-ingredient")
    public String index(Model model) {
        model.addAttribute("ingredients", mainIngredientService.findAll());
        return "main-ingredient/list";
    }
    //-----CREATE INGREDIENT
    @GetMapping("/home/main-ingredient/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("main-ingredient/create");
        modelAndView.addObject("ingredient", new MainIngredient());
        return modelAndView;
    }
    @PostMapping("/home/main-ingredient/save")
    public String save(MainIngredient mainIngredient, RedirectAttributes redirectAttributes) {
        mainIngredientService.save(mainIngredient);
        redirectAttributes.addFlashAttribute("message", "Created ingredient successfully!");
        return "redirect:/home/main-ingredient";
    }
    //-----EDIT EMPLOYEE
    @GetMapping("/home/main-ingredient/{id}/edit")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Optional<MainIngredient> mainIngredient = mainIngredientService.findById(id);
        ModelAndView modelAndView = new ModelAndView("main-ingredient/edit");
        modelAndView.addObject("ingredient", mainIngredient.get());
        return modelAndView;
    }
    @PostMapping("/home/main-ingredient/update")
    public String update(MainIngredient mainIngredient, RedirectAttributes redirect) {
        mainIngredientService.save(mainIngredient);
        redirect.addFlashAttribute("message", "Edit ingredient successfully!");
        return "redirect:/home/main-ingredient";
    }
    //-----DELETE INGREDIENT
    @GetMapping("/home/main-ingredient/{id}/delete")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Optional<MainIngredient> mainIngredient = mainIngredientService.findById(id);
        ModelAndView modelAndView = new ModelAndView("main-ingredient/delete");
        modelAndView.addObject("ingredient",mainIngredient.get());
        return modelAndView;
    }
    @PostMapping("/home/main-ingredient/delete")
    public String delete(MainIngredient mainIngredient, RedirectAttributes redirect) {
        mainIngredientService.remove(mainIngredient.getId());
        redirect.addFlashAttribute("message", "Delete ingredient successfully!");
        return "redirect:/home/main-ingredient";
    }
    //-----View
    @GetMapping("/home/main-ingredient/{id}/view")
    public String view(@PathVariable("id") Long id, Model model) {
        Optional<MainIngredient> mainIngredient = mainIngredientService.findById(id);
        model.addAttribute("ingredient", mainIngredient.get());
        return "main-ingredient/view";
    }
}
