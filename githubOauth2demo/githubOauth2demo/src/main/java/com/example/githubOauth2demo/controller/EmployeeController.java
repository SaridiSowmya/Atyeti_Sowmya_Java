package com.example.githubOauth2demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/hello")
    public String Greet()
    {
        return "welcome to github login";
    }
}
