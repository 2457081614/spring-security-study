package com.example.springsecurityoauthqq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Author : yangliu@tiduyun.com
 */
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/user/oauth")
    public String test(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/redirect")
    public String redirect() {
        return "这是认证接口";
    }


    @GetMapping("/callback")
    public String callBack() {
        return "这是回调函数";
    }

}
