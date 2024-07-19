package com.example.msproductcatalog.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

//    @PostMapping("/login")
//    public String loginPost(@RequestParam("username") String username,
//                            @RequestParam("password") String password,
//                            Model model) {
//        AuthenticationManager authenticationManager = authenticationManagerBean();
//
//        // Örnek kullanıcıları ve şifrelerini doğrula
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//            return "redirect:/dashboard"; // Başarılı giriş
//        } catch (AuthenticationException e) {
//            model.addAttribute("error", "Invalid username or password."); // Hatalı giriş
//            return "login";
//        }
//        return "swagger-ui.html";
//    }
}
