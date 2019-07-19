package com.hand.testonetomore.config;

import com.hand.testonetomore.interceptor.ControllerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 谭春
 * Date: 2019/7/19
 * Description:拦截器配置
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Autowired
    private ControllerInterceptor controllerInterceptor;

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(controllerInterceptor).addPathPatterns("/**");
    }
}

