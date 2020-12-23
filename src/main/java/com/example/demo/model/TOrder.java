package com.example.demo.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class TOrder {

    @TableId(value = "order_id")
    private Long orderId;

    private Long userId;

    private String orderNo;

    private String createName;

    private BigDecimal price;
}