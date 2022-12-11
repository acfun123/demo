package cn.cc.demo;

import cn.cc.demo.entity.Blog;
import cn.cc.demo.entity.User;
import cn.cc.demo.mapper.blog.BlogMapper;
import cn.cc.demo.mapper.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Autowired
    BlogMapper blogMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testUser(){
        List<Map<String, Object>> user = userMapper.getUser();
        user.stream().forEach(System.out::println);
    }

    @Test
    void testBlog(){
        List<Map<String, Object>> blog = blogMapper.getBlog();
        blog.stream().forEach(System.out::println);
    }

}
