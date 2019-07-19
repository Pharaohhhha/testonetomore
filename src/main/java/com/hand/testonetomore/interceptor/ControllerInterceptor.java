package com.hand.testonetomore.interceptor;

import com.alibaba.fastjson.JSON;
import com.hand.testonetomore.annotation.PermissionAnnotation;
import com.hand.testonetomore.domain.Stuinfo;
import com.hand.testonetomore.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author 谭春
 * Date: 2019/7/17
 * Description:拦截器
 * 拦截器一种方法：
 * 在拦截类中写@Component 再配置文件
 */
@Component
public class ControllerInterceptor implements HandlerInterceptor {
    @Autowired
    private IStudentService userService;

    /**
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     * 用户拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("ControllerInterceptor:preHandle");
        Boolean validateResult=false;
        if(isValidate(handler)){
            validateResult=validateUserPermission(request);
        }else {
            validateResult=true;
        }
        if(validateResult){
            return true;
        }else {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
            response.setStatus(HttpStatus.FORBIDDEN.value());
            ErrorMsg errorMsg = new ErrorMsg("permission,not.found","该用户没有权限");
            PrintWriter writer=response.getWriter();
            String msg=JSON.toJSONString(errorMsg);
            writer.print(msg);
            writer.close();

        }
        return false;
    }

    /**
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("ControllerInterceptor:postHandle");
    }

    /**
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("ControllerInterceptor:afterCompletion");
    }

    /**
     * 是否需要使用自定义注解校验
     * @param handler
     * @return
     */
    private Boolean isValidate(Object handler){
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        PermissionAnnotation methodAnnotation = method.getAnnotation(PermissionAnnotation.class);
        if (!StringUtils.isEmpty(methodAnnotation)) {
            return methodAnnotation.value();
        }else {
            PermissionAnnotation classAnotation=method.getDeclaringClass().getAnnotation(PermissionAnnotation.class);
            if (!StringUtils.isEmpty(classAnotation)){
                return classAnotation.value();
            }
        }
        return  false;
    }

    /**
     * 用户权限验证
     * @param request
     * @return
     */
    public Boolean validateUserPermission(HttpServletRequest request){
        String userid=request.getParameter("sno");
        Boolean result=false;
        if(!StringUtils.isEmpty(userid)) {
            Stuinfo stuinfo = userService.queryStudent(userid);
            if (!StringUtils.isEmpty(stuinfo)){
                result=true;
                }
            }
        return  result;
    }
}

