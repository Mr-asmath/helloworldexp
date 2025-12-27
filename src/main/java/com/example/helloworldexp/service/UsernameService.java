package com.example.helloworldexp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.helloworldexp.entity.Username;
import com.example.helloworldexp.repository.UsernameRepository;

@Service
@Transactional   // 🔐 ensures thread-safe DB operations
public class UsernameService {

    @Autowired
    private UsernameRepository usernameRepository;

    /* ================= INSERT ================= */
    public synchronized Username insert(String name) {
        Username user = new Username(name);
        return usernameRepository.save(user);
    }

    /* ================= READ ================= */
    public List<Username> getAllUsers() {
        return usernameRepository.findAll();
    }

    public Optional<Username> getUserById(int id) {
        return usernameRepository.findById(id);
    }

    /* ================= UPDATE ================= */
    public synchronized Username update(int id, String newName) {
        Username user = usernameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(newName);
        return usernameRepository.save(user);
    }

    /* ================= DELETE ================= */
    public synchronized void delete(int id) {
        if (!usernameRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        usernameRepository.deleteById(id);
    }
}
