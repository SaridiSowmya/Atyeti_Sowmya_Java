package com.example.Oauth2Demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
    @GetMapping("/hello")
    public String Greet()
    {
      return " Welcome to Oauth2";
    }
}
