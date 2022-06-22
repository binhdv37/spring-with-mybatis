package com.example.springwithmybatis.mapper.role;

import com.example.springwithmybatis.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("" +
            "select id, name, created_time as createdTime, " +
            "created_by as createdBy, updated_time as updatedTime, " +
            "updated_by as updatedBy " +
            "from role " +
            "")
    List<Role> findAll();

    @Select("" +
            "select id, name, created_time as createdTime, " +
            "created_by as createdBy, updated_time as updatedTime, " +
            "updated_by as updatedBy " +
            "from role " +
            "where role.id::varchar = #{id}"
    )
    Role findById(String id);

    @Insert("" +
            " insert into role " +
            " values ( uuid(#{id}), #{name}, #{createdTime}, uuid(#{createdBy}), #{updatedTime}, uuid(#{updatedBy}) ) " +
            "")
    void create(Role role);

    @Update("" +
            "update role" +
            "set" +
            "name = #{name}, created_time = #{createdTime}, created_by = #{createdBy}," +
            "updated_time = #{updated_time}, updated_by = #{updatedBy}" +
            "where id = #{id}" +
            "")
    void update(Role role);

    @Delete("" +
            "delete from role where id = #{id}" +
            "")
    void delete(String id);
}
