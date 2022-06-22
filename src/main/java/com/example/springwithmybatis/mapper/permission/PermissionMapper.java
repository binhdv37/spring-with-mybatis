package com.example.springwithmybatis.mapper.permission;

import com.example.springwithmybatis.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

@Mapper
public interface PermissionMapper {

    @Select(value = "select id as id, key as key, name as name, created_time as createdTime from permission")
    Collection<Permission> findAll();

}
