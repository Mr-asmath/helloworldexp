package com.example.helloworldexp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.helloworldexp.entity.Username;

public interface UsernameRepository extends JpaRepository<Username, Integer> {
}
