package test;

import com.books.bean.User;
import com.books.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void queryUsernameAndPassword(){
        Boolean flag = userService.queryUsernameAndPassword("admin2", "admin");
        System.out.println(flag);

    }
    @Test
    public void saveUserInformation(){
        User user = new User(null,"胡雨","123","51561@qq.com","100212");
        Boolean flag = userService.saveUserInformation(user);
        System.out.println(flag);


    }
    @Test
    public void queryUsername(){
        Boolean flag = userService.queryUsername("admin");
        System.out.println(flag);
    }

}
