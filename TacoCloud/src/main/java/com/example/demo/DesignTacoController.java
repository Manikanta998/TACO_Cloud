package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingrediants> ingredients = Arrays.asList(
                new Ingrediants("FLTO", "Flour Tortilla", Ingrediants.Type.WRAP),
                new Ingrediants("COTO", "COTO Tortilla", Ingrediants.Type.WRAP),
                new Ingrediants("GRBF", "GRBF Tortilla", Ingrediants.Type.PROTEIN),
                new Ingrediants("CARN", "Flour Tortilla", Ingrediants.Type.PROTEIN),
                new Ingrediants("TMTO", "Diced Tomatoes", Ingrediants.Type.VEGGIES),
                new Ingrediants("LETC", "Lettuce", Ingrediants.Type.VEGGIES),
                new Ingrediants("CHED", "Cheddar", Ingrediants.Type.CHEESE),
                new Ingrediants("SLSA", "Salsa", Ingrediants.Type.SAUCE),
                new Ingrediants("SRCR", "Sour Cream", Ingrediants.Type.SAUCE)
        );
        Ingrediants.Type[] types = Ingrediants.Type.values();
        for (Ingrediants.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    private List<Ingrediants> filterByType(List<Ingrediants> ingrediants, Ingrediants.Type type) {
        return ingrediants.stream().filter(it -> it.getType() == type).collect(Collectors.toList());
    }
    /*@PostMapping
    public String processDesign(Design design) {
// Save the taco design...
// We'll do this in chapter 3
        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }*/
    @PostMapping
    public String processOrder(Order order) {
        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}