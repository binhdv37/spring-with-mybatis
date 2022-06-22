package com.example.springwithmybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    private String id; // can not use UUID, does not know why yet
    private String name;
    private String key;
    private Long createdTime;

    @Override
    public String toString() {
        return "Permission(id= " + id + ", name= " + name + ", key= " + key + ", createdTime= " + createdTime + ")";
    }
}
