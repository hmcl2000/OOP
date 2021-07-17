package com.example.doanoopkitchenmanage.service.ingredient;
import com.example.doanoopkitchenmanage.model.Checklist;
import com.example.doanoopkitchenmanage.model.Ingredient;
import com.example.doanoopkitchenmanage.model.Report;
import com.example.doanoopkitchenmanage.service.GeneralService;

public interface IngredientService extends GeneralService<Ingredient> {
    Iterable<Ingredient> findAllByChecklist(Checklist checklist);
    Iterable<Ingredient> findAllByReport(Report report);
}
