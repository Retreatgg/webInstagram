package com.example.webinstagram.controller;

import com.example.webinstagram.dto.UserCreateDto;
import com.example.webinstagram.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final UserService userService;

    @GetMapping("login")
    public String login(Model model) {
        return "/auth/login";
    }

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("userDto", new UserCreateDto());
        return "register";
    }

    @PostMapping("register")
    public String register(@Valid UserCreateDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "register";
        }
        userService.registerUser(userDto);
        return "redirect:/auth/login";
    }
}
