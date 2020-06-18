package com.zzdz.security.securityresourcetest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @Classname WebSecurityConfig
 * @Description 配置安全相关，由于ResourceServerConfig已经配置，这里就不用再配置了
 * @Date 2019/10/31 15:08
 * @Created by joe
 */
//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 安全拦截机制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/r1").hasAnyAuthority("p1")
//                .antMatchers("/r2").hasAnyAuthority("p2")
                .antMatchers("/hello").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                //允许表单登录
                .formLogin()
                // 自定义登录成功页面
//                .successForwardUrl("/login-success")
        ;
    }
}
