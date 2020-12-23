package com.example.demo.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class TOrderDto {

    @TableId(value = "order_id")
    private Long orderId;

    private String orderNo;

    private String createName;

    private BigDecimal price;

    private Long userId;

    private Long itemId;

    private String itemName;
}