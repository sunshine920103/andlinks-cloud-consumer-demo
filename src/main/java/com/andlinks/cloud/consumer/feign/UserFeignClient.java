package com.andlinks.cloud.consumer.feign;

import com.andlinks.cloud.consumer.config.FeignDisableHystrixConfiguration;
import com.andlinks.cloud.consumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@FeignClient(name = "andlinks-cloud-provider-user",configuration = FeignDisableHystrixConfiguration.class,fallbackFactory = UserFeignClientFallbackFactory.class)
@FeignClient(name = "andlinks-cloud-provider-user",fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    @GetMapping("/getUser")
    public User get1(@RequestParam("id") Long id, @RequestParam("username") String username);

    @GetMapping("getByMap")
    public User get2(@RequestParam Map<String, Object> m);

    @PostMapping("/postUser")  //主要通过mapping地址来定位对应提供者的fun
    public User postUser(@RequestBody User user);

}

