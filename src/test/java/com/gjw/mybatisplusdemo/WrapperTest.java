package com.gjw.mybatisplusdemo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gjw.mybatisplusdemo.dao.UserMapper;
import com.gjw.mybatisplusdemo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 条件构造器实现查询
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test1(){
        //查询name不为空,邮箱不为空,年龄大于20的
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name");
        wrapper.isNotNull("email");
        wrapper.ge("age",20);
        userMapper.selectList(wrapper).forEach(System.out::println);//和之前的map对比一下
    }

    @Test
    void test2(){
        //查询 名字为郭经伟
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","gjw");
        User user = userMapper.selectOne(wrapper);//查询一个的时候
        System.out.println(user);
    }
    @Test
    void test3(){
        //查询 age 在20到30之间 的人数
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * 模糊查询
     */
    @Test
    void test4(){
        //查询 age 在20到30之间 的人数
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("name","e").likeLeft("email","t");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
