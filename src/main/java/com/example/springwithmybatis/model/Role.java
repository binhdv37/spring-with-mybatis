package com.example.springwithmybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private String id;
    private String name;
    private Long createdTime;
    private String createdBy;
    private Long updatedTime;
    private String updatedBy;

    private List<Permission> permissionList; // custom
    private List<UUID> permissionIdList;
}
