package com.andlinks.cloud.consumer.controller;

import com.andlinks.cloud.consumer.entity.User;
import com.andlinks.cloud.consumer.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    @PostMapping("/getu")
    public User findUser(@RequestBody User user){
        return this.userFeignClient.get1(user.getId(),user.getUsername());
    }

    @GetMapping("/getm")
    public User findUser2(@RequestParam Long id,@RequestParam String username){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("username",username);
        return this.userFeignClient.get2(map);
    }

    @PostMapping("/postu")
    public User postUser(@RequestBody User user){
        return this.userFeignClient.postUser(user);
    }


}
