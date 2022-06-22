package com.example.springwithmybatis.mapper.permission;

import com.example.springwithmybatis.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select(value = "select id as id, key as key, name as name, created_time as createdTime from permission")
    List<Permission> findAll();

    @Select(value = "select id as id, key as key, name as name, created_time as createdTime " +
            "from permission " +
            "inner join role_and_permission on permission.id = role_and_permission.permission_id " +
            "where role_and_permission.role_id::varchar = #{roleId}")
    List<Permission> findAllByRoleId(String roleId);

}
