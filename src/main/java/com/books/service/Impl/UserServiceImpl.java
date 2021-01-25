package com.books.service.Impl;


import com.books.bean.User;
import com.books.dao.UserDao;
import com.books.service.UserService;
import com.books.utils.SqlReturnFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    /**
     * 验证用户名和密码是否正确
     *
     * @param username 用户名
     * @param password 密码
     * @return 如果正确返回一个 true 错误返回1一个false
     */
    @Override
    public Boolean queryUsernameAndPassword(String username, String password) {

        List<User> users = userDao.queryUsernameAndPassword(username, password);
        if(users != null && !users.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 验证用户名是否可用
     *
     * @param username 用户名
     * @return 如果不可用 返回false 可用返回true
     */
    @Override
    public Boolean queryUsername(String username) {
        List<User> userList = userDao.queryUsername(username);
        if (userList!=null&&!userList.isEmpty()){
            return false; //不为空,则用户存在
        }else {
            return true;
        }
    }

    /**
     * 将用户信息保存到数据库t_user表中
     *
     * @param user 一个user对象
     * @return 返回一个boolean值
     */
    @Override
    public Boolean saveUserInformation(User user) {
        int updateLines = userDao.saveUserInformation(user);
        boolean flag = SqlReturnFlag.updateLine(updateLines);
        return flag;
    }
}
