package com.hand.testonetomore.config;

import com.hand.testonetomore.filter.PermissionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 谭春
 * Date: 2019/7/19
 * Description:过滤器配置类
 */
//@Configuration
public class FilterConfiguration {

    /**
     * 过滤器配置
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new PermissionFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}

