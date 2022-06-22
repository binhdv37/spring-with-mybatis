package com.example.springwithmybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role2 {
    private UUID id;
    private String name;
    private Long createdTime;
    private String createdBy;
    private Long updatedTime;
    private String updatedBy;
}
