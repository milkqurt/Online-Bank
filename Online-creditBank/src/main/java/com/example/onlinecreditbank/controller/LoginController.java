package com.example.onlinecreditbank.controller;

import com.example.onlinecreditbank.service.UserRepo;
import com.example.onlinecreditbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/loginUser")
    public String loginUser(){
        return "loginUser";
    }
    @GetMapping("/registerUser")
    public String registerUser(Model model){
        model.addAttribute("user",new UserRepo());
        return "registerUser";
    }
    @PostMapping("/registerUser")
    public String registerNewUser(@Valid UserRepo userRepo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "registerUser";
        }
        if (!userRepo.getPassword().equals(userRepo.getRepeatPassword())){
            bindingResult.rejectValue("password","","Пароли не совпадают");
            return "registerUser";
        }
        userService.create(userRepo);
        return "redirect:/loginUser";
    }

    @GetMapping("/loginAdmin")
    public String loginAdmin(){
        return "loginAdmin";
    }
}
