package com.example.onlinecreditbank.controller;

import com.example.onlinecreditbank.entity.CreditItem;
import com.example.onlinecreditbank.entity.CreditItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class OnlineBankController {

    private final CreditItemRepository repository;

    public OnlineBankController(CreditItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String formPage(Model model){
//        model.addAttribute("items",repository.findAll());
        model.addAttribute("item",new CreditItem());
        return "formCredit";
    }
    @PostMapping("/opdUser")
    public String emailUser(Model model){
        return "opdUser";
    }

    @PostMapping("/bank")
    public String newCredit(@ModelAttribute("item")CreditItem item,Model model){
//        model.addAttribute("item",new CreditItem());
        repository.save(item);
        model.addAttribute("items",repository.findAll());
        return "bank";
    }
    @DeleteMapping("/{id}")
    public String deleteCreditItem(@PathVariable("id") Long id){
        repository.deleteById(id);
        return "redirect:/bank";
    }
}
