package com.example.userservice.service;

import com.example.userservice.dto.res.InternalUserDTO;
import com.example.userservice.dto.res.PageMeta;
import com.example.userservice.dto.res.PageResponse;
import com.example.userservice.dto.res.UserResponseDTO;
import com.example.userservice.entity.User;
import com.example.userservice.exception.ResourceNotFoundException;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public PageResponse<UserResponseDTO> getUsers(int page, int size) {
        Page<User> result = userRepository.findAll(PageRequest.of(page, size));
        List<UserResponseDTO> data = result.getContent().stream()
                .map(u -> new UserResponseDTO(u.getId(), u.getFullName(), u.getEmail()))
                .toList();
        return new PageResponse<>(data,
                new PageMeta(result.getTotalElements(), page, size, result.isFirst(), result.isLast()));
    }

    public InternalUserDTO getInternalUser(Long id) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy user id = " + id));
        return new InternalUserDTO(u.getId(), u.getEmail());
    }
}

