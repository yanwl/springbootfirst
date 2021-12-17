package com.wlong.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Date;

@Import({com.wlong.annotation.Org.class,com.wlong.annotation.User.class})
public class TestImport {
    @Test
    public void testImport(){
        AnnotationConfigApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(TestImport.class);  //这里的参数代表要做操作的类
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println("注册的Bean名称："+name);
        }
        User user= (User) applicationContext.getBean("com.wlong.annotation.User");
        user.setUserId("1");
        user.setUpdTimeStr("2021-12-01 14:00:00");
        user.setUpdTime(new Date());
        System.out.println(user.toString());
    }
}
