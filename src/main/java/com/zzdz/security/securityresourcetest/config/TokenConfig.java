package com.zzdz.security.securityresourcetest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

/**
 * @Classname TokenConfig
 * @Description 配置令牌服务
 * @Date 2019/10/31 14:44
 * @Created by joe
 */
@Configuration
public class TokenConfig {

    private static final String SIGNING_KEY = "zzdz";

    @Bean
    public TokenStore tokenStore() {
        // 使用内存存储令牌（普通令牌）
        // return new InMemoryTokenStore();

        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }

    @Bean
    public TokenEnhancerChain tokenEnhancerChain() {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter()));
        return tokenEnhancerChain;
    }
}
