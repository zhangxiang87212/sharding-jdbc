package com.example.demo.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class TOrderItem {

    @TableId(value = "item_id")
    private Long itemId;

    private Long orderId;

    private String orderNo;

    private String itemName;

    private BigDecimal price;
}