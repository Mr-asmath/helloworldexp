package com.example.helloworldexp.controller;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.helloworldexp.entity.Username;
import com.example.helloworldexp.service.UsernameService;

@Controller
public class helloworldexp {

    @Autowired
    private UsernameService usernameService;

    // 🔹 Thread Pool (5 concurrent threads)
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    /* ================= INSERT ================= */
    // http://localhost:8080/result?name=Asmath
    @GetMapping("/result")
    public String insert(
            @RequestParam("name") String name,
            Model model) {

        executor.execute(() -> {
            usernameService.insert(name);
            System.out.println("Inserted by thread: " + Thread.currentThread().getName());
        });

        model.addAttribute("message", "Hello " + name + " 👋 (Saved)");
        return "result";
    }

    /* ================= READ ================= */
    // http://localhost:8080/read
    @GetMapping("/read")
    public String read(Model model) {

        List<Username> users = usernameService.getAllUsers();
        model.addAttribute("users", users);

        return "read"; // create read.html
    }

    /* ================= UPDATE ================= */
    // http://localhost:8080/update?id=1&name=NewName
    @GetMapping("/update")
    public String update(
            @RequestParam int id,
            @RequestParam String name,
            Model model) {

        executor.execute(() -> {
            usernameService.update(id, name);
            System.out.println("Updated by thread: " + Thread.currentThread().getName());
        });

        model.addAttribute("message", "Updated Successfully");
        return "result";
    }

    /* ================= DELETE ================= */
    // http://localhost:8080/delete?id=1
    @GetMapping("/delete")
    public String delete(
            @RequestParam int id,
            Model model) {

        executor.execute(() -> {
            usernameService.delete(id);
            System.out.println("Deleted by thread: " + Thread.currentThread().getName());
        });

        model.addAttribute("message", "Deleted Successfully");
        return "result";
    }

    /* ================= UI TEST ================= */
    // http://localhost:8080/test
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("message", "UI Working Fine");
        return "hello";
    }
}
