package com.hand.testonetomore.aspect;

import com.alibaba.fastjson.JSON;
import com.hand.testonetomore.annotation.PermissionAnnotation;
import com.hand.testonetomore.domain.Stuinfo;
import com.hand.testonetomore.interceptor.ErrorMsg;
import com.hand.testonetomore.service.IStudentService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author 谭春
 * Date: 2019/7/18
 * Description:
 */
@Aspect
@Component
public class PermissionAdvice {

    @Autowired
    private IStudentService userService;

    @Pointcut("execution(* com.hand.testonetomore.controller.*.*(..))")
    public void  servicePointCut(){
    }

    /**
     * AOP动态代理
     * @param pjp
     */
    @Around("servicePointCut()")
    public Object aroundFunction(ProceedingJoinPoint pjp){
        Boolean validateResult=false;
        ServletRequestAttributes attributes =   (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();

        Object lz=null;
        System.out.println("Aroud开始啦");
        //before
        if(isValidate(pjp)){
            validateResult=validateUserPermission(request);
        }else {
            validateResult=true;
        }
        try {
            if (validateResult) {
                lz = pjp.proceed();
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
        } catch (Throwable throwable) {
            //throwing
            throwable.printStackTrace();
        }
        //after return
        System.out.println("aroundFunction");
        return lz;
    }

    /**
     * 用户权限验证
     * @return
     */
    public Boolean validateUserPermission(HttpServletRequest request){
        String userid=request.getParameter("sno");
        Boolean result=false;
        if(!StringUtils.isEmpty(userid)) {
            Stuinfo stuinfo = userService.queryStudent(userid);
            if(!StringUtils.isEmpty(stuinfo)){
                return  true;
            }

        }
        return  result;
    }

    private Boolean isValidate(ProceedingJoinPoint handler){

        Signature sig = handler.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
             throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = handler.getTarget();
        try {
            Method method = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());

//        HandlerMethod handlerMethod=(HandlerMethod)handler;
//        Method method = handlerMethod.getMethod();
        PermissionAnnotation methodAnnotation = method.getAnnotation(PermissionAnnotation.class);
        if (!StringUtils.isEmpty(methodAnnotation)) {
            return methodAnnotation.value();
        }else {
            PermissionAnnotation classAnotation=method.getDeclaringClass().getAnnotation(PermissionAnnotation.class);
            if (!StringUtils.isEmpty(classAnotation)){
                return classAnotation.value();
            }
        }
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    }
        return  false;
    }


}

