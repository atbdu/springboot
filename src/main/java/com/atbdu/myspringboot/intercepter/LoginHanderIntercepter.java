package com.atbdu.myspringboot.intercepter;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHanderIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("========执行了preHandle方法==========");
        Object userName = request.getSession().getAttribute("userName");
        if (!StringUtils.isEmpty(userName)){
            //访问数据库
            String password = (String) request.getSession().getAttribute("password");
            if (userName.equals("tom")&&password.equals("123456")){
                return true;
            }else{

                request.getRequestDispatcher("/").forward(request,response);
                return false;
            }
        }else{
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("========执行了postHandle方法==========");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("========执行了afterCompletion方法==========");
    }
}
