package test;


import com.books.bean.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserManagerServiceTest {
    @Autowired
    private com.books.service.UserManagerService userManagerService;


    @Test
    public void  configTest(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("容器中的对象"+beanDefinitionName);
        }

    }


    @Test
    public void queryUser(){
        List<User> userList = userManagerService.queryAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void  del(){
        Boolean flag = userManagerService.delUser("5");
        System.out.println(flag);

    }



    @Test
    public void  addUser(){

        User user = new User(null,"xiaoming","xiaoming123","1482334540@qq.com","156456456");

        Boolean flag = userManagerService.addUser(user);
        System.out.println(flag);



    }
    @Test
    public void  like(){
        List<User> userList = userManagerService.likeUser("admin");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void  update(){

        User user = new User(72,"huyu","huyu123","1482334540@qq.com","156456456");
        Boolean flag = userManagerService.updateUser(user);
        System.out.println(flag);


    }






}
