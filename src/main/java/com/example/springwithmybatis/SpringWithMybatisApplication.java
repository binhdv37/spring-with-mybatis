package com.example.springwithmybatis;

import com.example.springwithmybatis.mapper.role.RoleMapper;
import com.example.springwithmybatis.model.Role2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class SpringWithMybatisApplication implements CommandLineRunner {

    @Autowired
    RoleMapper roleMapper;

    public static void main(String[] args) {
        SpringApplication.run(SpringWithMybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Role2 role2 = new Role2(UUID.randomUUID(), "anh coder", System.currentTimeMillis(), null, null, null);
        roleMapper.save2(role2);
    }
}
