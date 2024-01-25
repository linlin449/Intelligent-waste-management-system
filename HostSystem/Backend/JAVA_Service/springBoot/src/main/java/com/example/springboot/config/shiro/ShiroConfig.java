package com.example.springboot.config.shiro;

import com.example.springboot.config.shiro.realm.UserRealm;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);

        //TODO 设置跨域过滤器


        Map<String, String> map = new LinkedHashMap<>();
        //无需授权
        map.put("/login", "anon");//登陆接口
        map.put("/captcha/**", "anon");//验证码接口
        map.put("/error/**", "anon");//错误页面
        map.put("/**", "authc-cors");

        //配置自定义错误返回
        bean.setUnauthorizedUrl("/error/401");
        bean.setLoginUrl("/error/10000");

        bean.setFilterChainDefinitionMap(map);
        return bean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //设置SessionManager,去除重定向时Url中的JSESSIONID
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);
        defaultWebSecurityManager.setSessionManager(defaultWebSessionManager);

        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

}

