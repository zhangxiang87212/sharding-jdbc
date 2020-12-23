package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User Sel(int id);
}
