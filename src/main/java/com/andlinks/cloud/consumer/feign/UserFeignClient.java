package com.andlinks.cloud.consumer.feign;

import com.andlinks.cloud.consumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "andlinks-cloud-provider-user")
public interface UserFeignClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    @GetMapping("/getUser")
    public User get1(@RequestParam("id") Long id,@RequestParam("username") String username);

    @GetMapping("getByMap")
    public User get2(@RequestParam Map<String,Object> m );

    @PostMapping("/postUser")  //主要通过mapping地址来定位对应提供者的fun
    public User postUser(@RequestBody User user);

}
