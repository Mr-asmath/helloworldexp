package com.example.helloworldexp.controller;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.helloworldexp.entity.Username;
import com.example.helloworldexp.service.UsernameService;

@RestController
public class helloworldexp {
    @GetMapping("/")
    public String hello() {
        return "Hello Asmath! Jenkins Build Successful 🚀";
    }
    
}
