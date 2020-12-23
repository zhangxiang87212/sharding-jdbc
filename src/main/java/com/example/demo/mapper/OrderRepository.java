package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.TOrder;
import com.example.demo.model.TOrderDto;

//@Mapper
@Repository
public interface OrderRepository extends BaseMapper<TOrder> {

    List<TOrderDto> selectOrderAndItemByOrderId(TOrderDto tOrder);

    //    List<TOrderDto> selectOrderListPage(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize,
    //                                        @Param("orderId") Long orderId);

    List<TOrderDto> selectOrderListPage();

    //    List<TOrder> selectList(QueryWrapper<Object> objectQueryWrapper);
}

