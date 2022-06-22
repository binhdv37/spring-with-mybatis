package com.example.springwithmybatis.controller;

import com.example.springwithmybatis.mapper.role.RoleMapper;
import com.example.springwithmybatis.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/role")
@AllArgsConstructor
public class RoleController {

    private RoleMapper roleMapper; // demo purpose only, should have service layer in real life app

    @GetMapping("/all")
    public ResponseEntity<?> getAllRole() {
        return ResponseEntity.ok(roleMapper.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(roleMapper.findById(id.toString()));
    }

    @PostMapping
    public ResponseEntity<?> createOrUpdateRole(@RequestBody Role role) {
        if (role.getId() == null) {
            role.setId(UUID.randomUUID().toString());
            roleMapper.create(role);
        } else {
            roleMapper.update(role);
        }
        Role saved = roleMapper.findById(role.getId());
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable("id") UUID id) {
        roleMapper.delete(id.toString());
        return ResponseEntity.ok().build();
    }
}
