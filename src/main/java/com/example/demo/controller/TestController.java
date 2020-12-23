package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.ConfigRepository;
import com.example.demo.mapper.OrderItemRepository;
import com.example.demo.mapper.OrderRepository;
import com.example.demo.model.TConfig;
import com.example.demo.model.TOrder;
import com.example.demo.model.TOrderDto;
import com.example.demo.model.TOrderItem;

/**
 * @Author: xiaofu
 * @Description:
 */
@Controller
@RequestMapping
public class TestController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ConfigRepository configRepository;

    @GetMapping(value = "/insertOrder")
    @ResponseBody
    public String insertOrder() {

        for (int i = 5; i < 50; i++) {
            //            HintManager.clear();
            //            HintManager hintManager = HintManager.getInstance();
            //            hintManager.setDatabaseShardingValue(1);
            //            hintManager.addTableShardingValue("t_order" , 0);
            //            hintManager.addTableShardingValue("t_order" , 1);
            //            hintManager.addTableShardingValue("t_order" , 2);

            TOrder order = new TOrder();
            order.setOrderNo("A000" + i);
            order.setCreateName("订单 " + i);
            order.setUserId(Long.parseLong(i + ""));
            order.setPrice(new BigDecimal("" + i));
//            System.out.println(orderRepository);
            orderRepository.insert(order);

            System.out.println(order.getOrderId());
            TOrderItem orderItem = new TOrderItem();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setOrderNo("A000" + i);
            orderItem.setItemName("服务项目" + i);
            orderItem.setPrice(new BigDecimal("" + i));
            orderItemRepository.insert(orderItem);
        }
        return "success";
    }

    @GetMapping(value = "/config")
    @ResponseBody
    public String config() {

        TConfig tConfig = new TConfig();
        tConfig.setRemark("我是广播表");
        tConfig.setCreateTime(new Date());
        tConfig.setLastModifyTime(new Date());
        configRepository.insert(tConfig);
        return "success";
    }

    @GetMapping(value = "/getOneOrder")
    @ResponseBody
    public String getOne(String orderId) {
        return JSON.toJSONString(orderRepository.selectById(Long.parseLong(orderId)));
    }

    @GetMapping(value = "/selectOrderAndItemByOrderId")
    @ResponseBody
    public String selectOrderAndItemByOrderId(String orderId) {
        TOrderDto tOrder = new TOrderDto();
        if (!StringUtils.isEmpty(orderId)) {
            tOrder.setOrderId(Long.parseLong(orderId));
        }
        return JSON.toJSONString(orderRepository.selectOrderAndItemByOrderId(tOrder));
    }

    @GetMapping("/orderList")
    @ResponseBody
    public List<TOrder> list() {
        QueryWrapper<TOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("order_id",1326363623657414658L,1326363628954820610L);
        queryWrapper.orderByAsc("order_id");
        return orderRepository.selectList(queryWrapper);
    }

    @GetMapping(value = "/selectOrderListPage")
    @ResponseBody
    public List<TOrderDto> selectOrderListPage() {

        return orderRepository.selectOrderListPage();
    }

//    public static void main(String[] args) {
//
//    }
}
