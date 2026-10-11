package com.example.userservice.controller;

import com.example.userservice.dto.res.PageResponse;
import com.example.userservice.dto.res.UserResponseDTO;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public PageResponse<UserResponseDTO> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return userService.getUsers(page, Math.min(size, 100));
    }
}

