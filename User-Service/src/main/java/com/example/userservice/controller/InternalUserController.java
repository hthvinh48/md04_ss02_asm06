package com.example.userservice.controller;

import com.example.userservice.dto.res.InternalUserDTO;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/internal/users")
@RequiredArgsConstructor
public class InternalUserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public InternalUserDTO getUser(@PathVariable Long id) {
        return userService.getInternalUser(id);
    }
}