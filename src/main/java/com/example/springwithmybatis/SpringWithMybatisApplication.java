package com.example.springwithmybatis;

import com.example.springwithmybatis.mapper.permission.PermissionMapper;
import com.example.springwithmybatis.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;

@SpringBootApplication
public class SpringWithMybatisApplication implements CommandLineRunner {

    @Autowired
    PermissionMapper permissionMapper;

    public static void main(String[] args) {
        SpringApplication.run(SpringWithMybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Collection<Permission> permissions = permissionMapper.findAll();
        permissions.forEach(System.out::println);
    }

}
