package com.books.controller;

import com.books.bean.User;
import com.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(String username, String password, HttpSession session){
        ModelAndView mv = new ModelAndView();
        Boolean flag = userService.queryUsernameAndPassword(username, password);
        if (flag){
            session.setAttribute("username",username);
            mv.setViewName("forward:/index.jsp");
        }else {
            mv.addObject("loginMessage","账号或用户名错误");
           mv.setViewName("forward:/book/Login.jsp");
        }
        return mv;
    }

    @RequestMapping("/loginOut")
    public  ModelAndView loginOut(HttpSession session){
        ModelAndView mv = new ModelAndView();
         session.removeAttribute("username");
         mv.setViewName("forward:/index.jsp");
        return mv;
    }

    @RequestMapping("/register.do")
    public ModelAndView Register(User user,String code,HttpSession session){
        ModelAndView mv = new ModelAndView();
        //获取客户端生成的验证码
        String codeGoogle =(String)session.getAttribute(KAPTCHA_SESSION_KEY);
        //删除客户端验证码
        session.removeAttribute(KAPTCHA_SESSION_KEY);
        if (userService.queryUsername(user.getUsername())){
            if (code.equalsIgnoreCase(codeGoogle)&&code!=null){
               userService.saveUserInformation(user);
               mv.setViewName("forward:/index.jsp");
            } else{
               mv.addObject("message","验证码错误");
               mv.setViewName("forward:/book/Registered.jsp");
            }
        }else {
            mv.addObject("message","用户名已存在");
            mv.setViewName("forward:/book/Registered.jsp");
        }

        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/ajaxVerifyUsername.do",produces = "text/plain;charset=utf-8")
    public String ajaxVerifyUsername(String username){
        Boolean flag = userService.queryUsername(username); //如果用户名可用,返回true ,反之就返回false
        return String.valueOf(flag);
    }
}
