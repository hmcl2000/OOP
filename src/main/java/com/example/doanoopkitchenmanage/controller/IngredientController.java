package com.example.doanoopkitchenmanage.controller;

import com.example.doanoopkitchenmanage.model.Checklist;
import com.example.doanoopkitchenmanage.model.Employee;
import com.example.doanoopkitchenmanage.model.Ingredient;
import com.example.doanoopkitchenmanage.service.checklist.ChecklistService;
import com.example.doanoopkitchenmanage.service.ingredient.IngredientService;
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
public class IngredientController {
    @Autowired
    IngredientService ingredientService;
    @Autowired
    ChecklistService checklistService;

    @ModelAttribute("checklists")
    public Iterable<Checklist> checklists() {
        return checklistService.findAll();
    }

/*    //-----HOME PAGE
    @GetMapping("/home/ingredient")
    public String index(Model model) {
        model.addAttribute("ingredients", ingredientService.findAll());
        return "ingredient-for-day/list";
    }

    //-----CREATE NEW INGREDIENT
    @GetMapping("/home/ingredient/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("ingredient-for-day/create");
        modelAndView.addObject("ingredient", new Ingredient());
        return modelAndView;
    }

    @PostMapping("/home/ingredient/save")
    public String save(Ingredient ingredient, RedirectAttributes redirectAttributes) {

        ingredientService.save(ingredient);
        redirectAttributes.addFlashAttribute("message", "Created ingredient successfully!");
        return "redirect:/home/ingredient/create";
    }

    //-----EDIT INGREDIENT
    @GetMapping("/home/ingredient/{id}/edit")
    public ModelAndView edit(@PathVariable("id") Long id) {
        Optional<Ingredient> ingredient = ingredientService.findById(id);
        ModelAndView modelAndView = new ModelAndView("ingredient-for-day/edit");
        modelAndView.addObject("ingredient", ingredient.get());
        return modelAndView;
    }

    @PostMapping("/home/ingredient/update")
    public String update(Ingredient ingredient, RedirectAttributes redirect) {
        ingredientService.save(ingredient);
        redirect.addFlashAttribute("message", "Edit ingredient successfully!");
        return "redirect:/home/ingredient";
    }

    //-----DELETE INGREDIENT
    @GetMapping("/home/ingredient/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        Optional<Ingredient> ingredient = ingredientService.findById(id);
        ModelAndView modelAndView = new ModelAndView("ingredient-for-day/delete");
        modelAndView.addObject("ingredient", ingredient.get());
        return modelAndView;
    }

    @PostMapping("/home/ingredient/delete")
    public String delete(Ingredient ingredient, RedirectAttributes redirect) {
        ingredientService.remove(ingredient.getId());
        redirect.addFlashAttribute("message", "Delete ingredient successfully!");
        return "redirect:/home/ingredient";
    }

    //-----View
    @GetMapping("/home/ingredient/{id}/view")
    public ModelAndView view(@PathVariable("id") Long id) {
        Optional<Ingredient> ingredient = ingredientService.findById(id);
        ModelAndView modelAndView = new ModelAndView("ingredient-for-day/view");
        modelAndView.addObject("ingredient", ingredient.get());
        return modelAndView;
    }*/
}