package com.proteccion.requests.controller;

import com.proteccion.requests.dto.CreateUserDTO;
import com.proteccion.requests.dto.UserDTO;
import com.proteccion.requests.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody CreateUserDTO dto) {
        UserDTO created = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO userDTO = userService.findById(id);
        return userDTO != null
                ? ResponseEntity.ok(userDTO)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
