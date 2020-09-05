//package com.exercise.exercise.Config;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        Object loginUser = request.getSession().getAttribute("loginUser");
//        if(loginUser==null){
//            request.setAttribute("msg","没有登录请先登录！");
//            request.getRequestDispatcher("/index.html").forward(request,response);
//            return false;
//        }else {
//            return true;
//        }
//
//        //登录成功之后应该有用户的session
//}
//
//}
