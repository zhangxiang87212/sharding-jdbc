package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.TOrderItem;

//@Mapper
@Repository
public interface OrderItemRepository extends BaseMapper<TOrderItem> {

}

