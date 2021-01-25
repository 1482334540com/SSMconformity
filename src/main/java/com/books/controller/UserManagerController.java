package com.books.controller;

import com.books.bean.User;
import com.books.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;



    @RequestMapping("/queryAllUser.do")
    public ModelAndView queryAllUser(){
        ModelAndView mv = new ModelAndView();
        List<User> userList = userManagerService.queryAllUser();
        mv.addObject("userList",userList);
        mv.setViewName("forward:/book/admin/userManager.jsp");
        return mv;
    }

    @RequestMapping(value = "/addUser.do",method = RequestMethod.POST)
    public ModelAndView addUser (User user ){

        ModelAndView mv = new ModelAndView();
        userManagerService.addUser(user);
        List<User> userList = userManagerService.queryAllUser();
        mv.addObject("userList",userList);
        mv.setViewName("forward:/book/admin/userManager.jsp");
        return mv;
    }

    @RequestMapping(value = "/deleteUser.do",method = RequestMethod.POST)
    public ModelAndView deleteUser (String userId ){

        ModelAndView mv = new ModelAndView();
        userManagerService.delUser(userId);
        mv.setViewName("forward:/book/admin/userManager.jsp");
        return mv ;

    }

    @RequestMapping(value = "/likeUser.do",method = RequestMethod.GET)
    public ModelAndView likeUser(String username){

        ModelAndView mv = new ModelAndView();
        List<User> userList = userManagerService.likeUser(username);
        mv.addObject("userList",userList);
        mv.setViewName("forward:/book/admin/userManager.jsp");
        return mv ;
    }

    @RequestMapping(value = "/updateUser.do",method = RequestMethod.POST)
    public  ModelAndView updateUser(User user){

        ModelAndView mv = new ModelAndView();
        userManagerService.updateUser(user);
        List<User> userList = userManagerService.queryAllUser();
        mv.addObject("userList",userList);
        mv.setViewName("forward:/book/admin/userManager.jsp");
        return mv;
    }


}
