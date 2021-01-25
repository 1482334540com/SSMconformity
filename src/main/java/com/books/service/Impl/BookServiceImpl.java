package com.books.service.Impl;


import com.books.bean.Book;
import com.books.bean.Paging;
import com.books.dao.BookDao;
import com.books.service.BookService;
import com.books.utils.SqlReturnFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired //通过set方法注入dao对象
    private BookDao bookDao;


    /**
     * 查询所有的图书·
     *
     * @return 装在List集合里面
     */
    @Override
    public List<Book> queryAll() {
        List<Book> bookList = bookDao.queryAll();
        return bookList;
    }

    /**
     * 查询一条数据
     *
     * @param id 需要查询的id
     * @return 返回一个Book对象
     */
    @Override
    public Book queryBook(int id) {
        return null;
    }

    /**
     * 删除图书
     *
     * @param id 需要删除图书的id
     * @return 成功返回true 失败返回false
     */
    @Override
    public Boolean deleteBook(String id) {
        int updateLine = bookDao.deleteBook(id);
        boolean  flag = SqlReturnFlag.updateLine(updateLine);
        return flag;
    }

    /**
     * 修改图书
     *
     * @param book 需要修改的图书对象
     * @return 成功返回true 失败返回false
     */
    @Override
    public Boolean updateBook(Book book) {
        int i = bookDao.updateBook(book);
        boolean flag = SqlReturnFlag.updateLine(i);
        return flag;
    }

    /**
     * 添加图书
     *
     * @param book
     * @return 添加成功返回true 失败返回false
     */
    @Override
    public Boolean addBook(Book book) {
        int i = bookDao.addBook(book);
        boolean flag = SqlReturnFlag.updateLine(i);
        return flag;
    }

    /**
     * 按照书名查找图书
     *
     * @param name 需要查找的书名
     * @return 查询到返回一个List集合
     */
    @Override
    public List<Book> likeBook(String name) {
        List<Book> bookList = bookDao.likeBook(name);
        return bookList;
    }

    /**
     * 分页对象 处理分页查询
     *
     * @param pageNo   当前页
     * @param pageSize 当前显示数量
     * @return
     */
    @Override
    public Paging<Book> page(int pageNo, int pageSize) throws SQLException {
        return null;
    }

    /**
     * 处理价格区间的分页查询
     *
     * @param pageNO   当前页数据
     * @param pageSize 每页显示多少条数据
     * @param min      最小价格
     * @param max      最大价格
     * @return 返回一个page对象
     */
    @Override
    public Paging<Book> pageByPrice(int pageNO, int pageSize, int min, int max) throws SQLException {
        return null;
    }
}
