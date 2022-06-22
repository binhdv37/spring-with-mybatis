package com.example.springwithmybatis.controller;

import com.example.springwithmybatis.mapper.permission.PermissionMapper;
import com.example.springwithmybatis.mapper.role.RoleMapper;
import com.example.springwithmybatis.mapper.roleAndPermission.RoleAndPermissionMapper;
import com.example.springwithmybatis.model.Role;
import com.example.springwithmybatis.model.RoleAndPermission;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/role")
@AllArgsConstructor
public class RoleController {

    private RoleMapper roleMapper; // demo purpose only, should have service layer in real life app
    private PermissionMapper permissionMapper;
    private RoleAndPermissionMapper roleAndPermissionMapper;

    @GetMapping("/all")
    public ResponseEntity<?> getAllRole() {
        List<Role> roleList = roleMapper.findAll();
        roleList.forEach(r -> {
            r.setPermissionList(permissionMapper.findAllByRoleId(r.getId()));
        });
        return ResponseEntity.ok(roleList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable("id") UUID id) {
        Role role = roleMapper.findById(id.toString());
        role.setPermissionList(permissionMapper.findAllByRoleId(role.getId()));
        return ResponseEntity.ok(role);
    }

    @PostMapping
    public ResponseEntity<?> createOrUpdateRole(@RequestBody Role role) {
        if (role.getId() == null) {
            // create
            role.setId(UUID.randomUUID().toString());
            role.setCreatedTime(System.currentTimeMillis());
            role.setCreatedBy("ea151d61-67a3-4a11-869e-9b240d69e9bc");
            roleMapper.create(role);
            if (role.getPermissionIdList() != null && role.getPermissionIdList().size() > 0) {
                role.getPermissionIdList().forEach(p -> {
                    RoleAndPermission roleAndPermission = new RoleAndPermission(role.getId(), p.toString());
                    roleAndPermissionMapper.save(roleAndPermission);
                });
            }
        } else {
            role.setUpdatedTime(System.currentTimeMillis());
            role.setUpdatedBy("ea151d61-67a3-4a11-869e-9b240d69e9bc");
            roleMapper.update(role);
            roleAndPermissionMapper.deleteByRoleId(role.getId());
            if (role.getPermissionIdList() != null && role.getPermissionIdList().size() > 0) {
                role.getPermissionIdList().forEach(p -> {
                    RoleAndPermission roleAndPermission = new RoleAndPermission(role.getId(), p.toString());
                    roleAndPermissionMapper.save(roleAndPermission);
                });
            }
        }
        Role saved = roleMapper.findById(role.getId());
        saved.setPermissionList(permissionMapper.findAllByRoleId(role.getId()));
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable("id") UUID id) {
        roleMapper.delete(id.toString());
        return ResponseEntity.ok().build();
    }
}
