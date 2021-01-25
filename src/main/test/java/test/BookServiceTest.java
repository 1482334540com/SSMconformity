package test;

import com.books.bean.Book;
import com.books.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void queryAllBook(){
        List<Book> bookList = bookService.queryAll();
        for (Book book : bookList) {
            System.out.println(book);
        }

    }

    @Test
    public void addBook(){
        Book book = new Book(null, "从入门到卸载jdk", "胡雨", 52, 32, 12, "/book_ctiy/book/img/timg.jpg");
        Boolean flag = bookService.addBook(book);
        System.out.println(flag);

    }

    @Test
    public void deleteBook(){
        Boolean flag = bookService.deleteBook("148");
        System.out.println(flag);

    }

    @Test
    public void updateBook(){
        Book book = new Book(149, "从入门到卸载jdk", "卡夫卡", 52, 32, 12, "/book_ctiy/book/img/timg.jpg");
        Boolean flag = bookService.updateBook(book);
        System.out.println(flag);

    }

    @Test
    public void likeBook(){
        List<Book> books = bookService.likeBook("入");
        for (Book book : books) {
            System.out.println(book);
        }

    }

}
