package com.books.service.Impl;


import com.books.bean.User;
import com.books.dao.UserManagerDao;
import com.books.service.UserManagerService;
import com.books.utils.SqlReturnFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserManagerServiceImpl implements UserManagerService {
    @Autowired
    private UserManagerDao userManagerDao;
    /**
     * 查询所有的数据 用于视图展示
     *
     * @return 返回一个List集合
     */
    @Override
    public List<User> queryAllUser() {
        List<User> userList = userManagerDao.queryAllUser();
        return userList;
    }

    /**
     * 添加
     *
     * @param user 一个user对象
     * @return 成功返回true 失败返回false
     */
    @Override
    public Boolean addUser(User user) {
        int i = userManagerDao.addUser(user);
        boolean flag = SqlReturnFlag.updateLine(i);
        return flag;
    }

    /**
     * 删除用户
     *
     * @param id 需要删除的用户id
     * @return 成功返回true  失败返回false
     */
    @Override
    public Boolean delUser(String id) {
        int i = userManagerDao.delUser(id);
        boolean flag = SqlReturnFlag.updateLine(i);
        return flag;
    }

    /**
     * 修改用户信息
     *
     * @param user 需要一个user对象
     * @return 成功返回true 失败返回false
     */
    @Override
    public Boolean updateUser(User user) {
        int i = userManagerDao.updateUser(user);
        boolean flag = SqlReturnFlag.updateLine(i);
        return flag;
    }

    /**
     * 按照用户名查找用户
     *
     * @param username 需要查找的用户名
     * @return 返回一个List集合
     */
    @Override
    public List<User> likeUser(String username ) {
        List<User> userList = userManagerDao.likeUser(username);
        return userList;
    }


}
