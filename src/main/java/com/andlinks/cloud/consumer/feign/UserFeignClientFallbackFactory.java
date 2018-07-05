package com.andlinks.cloud.consumer.feign;

import com.andlinks.cloud.consumer.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by sunshine on 2018/7/5.
 */
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        final Logger LOGGER=LoggerFactory.getLogger(UserFeignClientFallbackFactory.class);
        LOGGER.info("fallback due to: {}",throwable);
        return new UserFeignClient() {
            @Override
            public User findById(@PathVariable("id") Long id) {
                User user=new User();
                user.setId(-1L);
                user.setName("default");
                return user;
            }

            @Override
            public User get1(@RequestParam("id") Long id, @RequestParam("username") String username) {
                return null;
            }

            @Override
            public User get2(@RequestParam Map<String, Object> m) {
                return null;
            }

            @Override
            public User postUser(@RequestBody User user) {
                return null;
            }
        };
    }
}
