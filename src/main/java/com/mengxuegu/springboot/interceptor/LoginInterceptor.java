package com.mengxuegu.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    //调用目标方法之前被拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginuser = request.getSession().getAttribute("loginUser");
        if(loginuser!=null){
            //已经登录过
            return  true;
        }
        //没有登录过
        request.setAttribute("msg","没有权限请先登录");
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
