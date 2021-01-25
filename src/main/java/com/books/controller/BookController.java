package com.books.controller;


import com.books.bean.Book;
import com.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
     @Autowired
    private BookService bookService;

    @RequestMapping("/index.do")
    public ModelAndView doMain(){

        ModelAndView mv = new ModelAndView();
        List<Book> bookList = bookService.queryAll();
        mv.addObject("bookList",bookList);
        mv.setViewName("forward:/book/index.jsp");
        return mv;

    }

     @RequestMapping("/queryAllBook.do")
    public ModelAndView queryAllBook(){

        ModelAndView mv = new ModelAndView();
        List<Book> bookList = bookService.queryAll();
        mv.addObject("bookList",bookList);
        mv.setViewName("forward:/book/admin/bookManager.jsp");
        return mv;

    }

    @RequestMapping("/addBook.do")
    public ModelAndView addBook(Book book){

        ModelAndView mv = new ModelAndView();
        Boolean flag = bookService.addBook(book);
        List<Book> bookList = bookService.queryAll();
        mv.addObject("bookList",bookList);
        mv.setViewName("forward:/book/admin/bookManager.jsp");
        return mv;
    }

    @RequestMapping("/deleteBook.do")
    public ModelAndView deleteBook(String id){
         ModelAndView mv = new ModelAndView();
        Boolean flag = bookService.deleteBook(id);
        mv.setViewName("forward:/book/admin/bookManager.jsp");
        return mv;
    }

    @RequestMapping("/likeBook.do")
    public ModelAndView likeBook(String name){
        System.out.println(name);
        System.out.println("name");
        ModelAndView mv = new ModelAndView();
        List<Book> bookList = bookService.likeBook(name);
        mv.addObject("bookList",bookList);
        mv.setViewName("forward:/book/admin/bookManager.jsp");
        return mv;
    }

    @RequestMapping("/updateBook.do")
    public ModelAndView updateBook(Book book){
        System.out.println(book);
        System.out.println("551");
        ModelAndView mv = new ModelAndView();
        Boolean flag = bookService.updateBook(book);
        mv.setViewName("forward:/book/admin/bookManager.jsp");
        return mv;
    }


}
