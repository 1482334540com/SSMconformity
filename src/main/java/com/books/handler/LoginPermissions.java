package com.books.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPermissions implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    try {
            String username = (String)request.getSession().getAttribute("username");
        if (username!=null||!username.isEmpty()){
            return true;
        }else{
            request.getRequestDispatcher("/book/Login.jsp").forward(request,response);
            return false;
        }
        }catch (Exception e){
        request.getRequestDispatcher("/book/Login.jsp").forward(request,response);
        return false;
    }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
