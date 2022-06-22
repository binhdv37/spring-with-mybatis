package com.example.springwithmybatis.mapper.roleAndPermission;

import com.example.springwithmybatis.model.RoleAndPermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleAndPermissionMapper {

    @Insert("insert into role_and_permission values ( uuid(#{roleId}), uuid(#{permissionId}) )")
    void save(RoleAndPermission roleAndPermission);

    @Delete("delete from role_and_permission where role_id::varchar = #{roleId}")
    void deleteByRoleId(String roleId);

}
