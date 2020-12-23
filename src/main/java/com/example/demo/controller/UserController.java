package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
@RequestMapping("/testBoot")
@Scope("prototype")
public class UserController {
    @Autowired
    private UserService userService;

    public static final HashMap<Integer, Integer> hashMap = new HashMap<>();

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable Integer id) {

        //        return userService.Sel(id).toString();
        //        this.hashMap = new HashMap<>();
        hashMap.put(id, id);
        return hashMap.toString();
    }

}
