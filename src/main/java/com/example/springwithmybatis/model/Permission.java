package com.example.springwithmybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    private String id;
    private String name;
    private String key;
    private Long createdTime;

    @Override
    public String toString() {
        return "{ id: " + id + ", name: " + name + ", key: " + key + ", createdTime: " + createdTime + " }";
    }
}
