package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.TConfig;

//@Mapper
@Repository
public interface ConfigRepository extends BaseMapper<TConfig> {

}

