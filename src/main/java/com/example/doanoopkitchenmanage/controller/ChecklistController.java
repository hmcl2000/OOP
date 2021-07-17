package com.example.doanoopkitchenmanage.controller;

import com.example.doanoopkitchenmanage.model.Checklist;
import com.example.doanoopkitchenmanage.model.Employee;
import com.example.doanoopkitchenmanage.model.Ingredient;
import com.example.doanoopkitchenmanage.service.checklist.ChecklistService;
import com.example.doanoopkitchenmanage.service.employee.EmployeeService;
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
public class ChecklistController {
    @Autowired
    private ChecklistService checklistService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private IngredientService ingredientService;


    @ModelAttribute("employees")
    public Iterable<Employee> employees() {
        return employeeService.findAll();
    }

    @ModelAttribute("checklists")
    public Iterable<Checklist> checklists() {
        return checklistService.findAll();
    }

    @GetMapping("/home/checklist")
    public String index(Model model) {
        model.addAttribute("checklists", checklistService.findAll());
        return "checklist/list";
    }

    //-----CREATE NEW CHECKLIST
    @GetMapping("/home/checklist/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("checklist/create");
        modelAndView.addObject("checklist", new Checklist());
        return modelAndView;
    }

    @PostMapping("/home/checklist/save")
    public String save(Checklist checklist, RedirectAttributes redirectAttributes) {
        checklistService.save(checklist);
        redirectAttributes.addFlashAttribute("message", "Created checklist successfully!");
        return "redirect:/home/checklist";
    }

    //-----VIEW CHECKLIST
    @GetMapping("/home/checklist/{id}/view")
    public ModelAndView viewChecklist(@PathVariable("id") Long id) {
        Optional<Checklist> checklistOptional = checklistService.findById(id);
        if (!checklistOptional.isPresent()) {
            return new ModelAndView("/error.404");
        }
        Iterable<Ingredient> ingredients = ingredientService.findAllByChecklist(checklistOptional.get());
        ModelAndView modelAndView = new ModelAndView("/checklist/view");
        modelAndView.addObject("id", checklistOptional.get().getId());
        modelAndView.addObject("checklist", checklistOptional.get());
        modelAndView.addObject("ingredients", ingredients);
        return modelAndView;
    }

    //-----CREATE NEW INGREDIENT IN CHECKLIST
    @GetMapping("/home/checklist/{id}/create/ingredient")
    public ModelAndView createIngredient(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView("checklist/create-ingredient");
        modelAndView.addObject("id", id);
        Optional<Checklist> checklist = checklistService.findById(id);
        Ingredient ingredient = new Ingredient();
        ingredient.setChecklist(checklist.get());
        modelAndView.addObject("ingredient", ingredient);

        return modelAndView;
    }

    @PostMapping("/home/checklist/{id}/save/ingredient")
    public String save(@PathVariable Long id, Ingredient ingredient, RedirectAttributes redirectAttributes) {
        ingredientService.save(ingredient);
        redirectAttributes.addFlashAttribute("message", "Created checklist successfully!");
        return "redirect:/home/checklist/{id}/create/ingredient";
    }


    //-----EDIT INGREDIENT IN CHECKLIST
    @GetMapping("/home/checklist/{id}/view/edit/{id2}")
    public ModelAndView editIngredient(@PathVariable("id") Long id, @PathVariable("id2") Long id2) {
        Optional<Ingredient> ingredient = ingredientService.findById(id2);
        ModelAndView modelAndView = new ModelAndView("checklist/edit-ingredient");
        modelAndView.addObject("id", id);
        modelAndView.addObject("ingredient", ingredient.get());
        return modelAndView;
    }

    @PostMapping("/home/checklist/{id}/view/update/{id2}")
    public String update(@PathVariable("id") Long id, @PathVariable("id2") Long id2, Ingredient ingredient, RedirectAttributes redirectAttributes) {
        ingredientService.save(ingredient);
        redirectAttributes.addFlashAttribute("message", "Update ingredient successfully");
        return "redirect:/home/checklist/{id}/view/edit/{id2}";
    }

    //-----DELETE INGREDIENT IN CHECKLIST
    @GetMapping("/home/checklist/{id}/view/delete/{id2}")
    public ModelAndView deleteIngredient(@PathVariable("id") Long id, @PathVariable("id2") Long id2) {
        Optional<Ingredient> ingredient = ingredientService.findById(id2);
        ModelAndView modelAndView = new ModelAndView("checklist/delete-ingredient");
        modelAndView.addObject("id", id);
        modelAndView.addObject("ingredient", ingredient.get());
        return modelAndView;
    }
    @PostMapping("/home/checklist/{id}/view/delete/{id2}")
    public String deleteIngredient(@PathVariable("id") Long id, @PathVariable("id2") Long id2, Ingredient ingredient, RedirectAttributes redirectAttributes) {
        ingredientService.remove(id2);
        redirectAttributes.addFlashAttribute("message", "Delete ingredient successfully");
        return "redirect:/home/checklist/{id}/view";
    }

    //-----DELETE CHECKLIST
    @GetMapping("/home/checklist/{id}/delete")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Optional<Checklist> checklist = checklistService.findById(id);
        ModelAndView modelAndView = new ModelAndView("checklist/delete");
        modelAndView.addObject("checklist", checklist.get());
        return modelAndView;
    }
    @PostMapping("/home/checklist/delete")
    public String delete(Checklist checklist, RedirectAttributes redirectAttributes) {
        checklistService.remove(checklist.getId());
        redirectAttributes.addFlashAttribute("message", "Delete checklist successfully");
        return "redirect:/home/checklist";
    }
}
