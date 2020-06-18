package com.zzdz.security.securityresourcetest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2019/11/1 13:16
 * @Created by joe
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        System.out.println(authorization);
        return "访问资源1";
    }

    @GetMapping("/r2")
    @PreAuthorize("hasAnyAuthority('p2')")
    public String r2() {
        return "访问资源2";
    }

    @GetMapping("/r7")
    @PreAuthorize("hasAnyAuthority('p7')")
    public String r7() {
        return "访问资源2";
    }

}
