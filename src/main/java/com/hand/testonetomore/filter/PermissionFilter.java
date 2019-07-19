package com.hand.testonetomore.filter;

import com.hand.testonetomore.constant.PermissionConstant;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 谭春
 * Date: 2019/7/17
 * Description:过滤器
 * 过滤器三种方法
 * 1： @Component
 * 2:   @WebFilter(filterName = "permissionFilter",urlPatterns = "/*") 然后启动类：@ServletComponentScan("com.hand.train1907.user.filter")
 * 3：  配置文件
 */
@Order(99)
public class PermissionFilter implements Filter {


    /**
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("permission init()");
    }

    /**
     * 过滤路径处理
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        Boolean validateResult = validateUserPermission(httpServletRequest.getHeader("token"));
        System.out.println(validateResult);
        if(validateResult){
            //传回给Servlet处理
            filterChain.doFilter(servletRequest,servletResponse);
            httpServletResponse.setStatus(200);
        }else {
            httpServletResponse.setStatus(403);
        }

        System.out.println("token:"+httpServletRequest.getHeader("token"));
    }

    /**
     *
     */
    @Override
    public void destroy() {
        System.out.println("permission destroy()");
    }

    /**
     * @param token
     * @return
     */
    private Boolean validateUserPermission(String token){
        if (PermissionConstant.EXISTS_TOKEN.equals(token)){
            return true;
        }
        return  false;
    }
}

