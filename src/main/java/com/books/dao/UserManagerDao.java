package com.books.dao;


import com.books.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserManagerDao {

    /**
     * 查询所有的数据 用于视图展示
     * @return 返回一个List集合
     */
    public List<User> queryAllUser();

    /**
     * 添加
     * @param user 一个user对象
     * @return 成功返回true 失败返回false
     */
    public int addUser(User user);

    /**
     * 删除用户
     * @param id 需要删除的用户id
     * @return 成功返回true  失败返回false
     */
    public int delUser(@Param("id") String id);

    /**
     * 修改用户信息
     * @param user 需要一个user对象
     * @return 成功返回true 失败返回false
     */
    public int  updateUser(User user);

    /**
     * 按照用户名查找用户
     * @param username 需要查找的用户名
     * @return  返回一个List集合
     */
    public List<User> likeUser(@Param("username") String username);



}
