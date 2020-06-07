package com.gjw.mybatisplusdemo;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjw.mybatisplusdemo.dao.UserMapper;
import com.gjw.mybatisplusdemo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class TestCrud {

    @Autowired
    private UserMapper userMapper;
    @Test
    void testInsert(){

        User user = new User();
        user.setName("张三").setAge(20).setEmail("1447851361@qq.com");
        userMapper.insert(user);
    }
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(1269256537126268930L).setName("郭经伟459");
        userMapper.updateById(user);
    }
    @Test
    void testOptimisticLock1(){
        //单线程情况
        //1.查询用户信息
        User user = userMapper.selectById(1L);
        //2.更新用户信息
        user.setName("郭经伟").setEmail("1447851361@qq.com");
        userMapper.updateById(user);
    }
    @Test
    void testOptimisticLock2(){
        //多线程 插队
        //1.查询用户信息
        User user = userMapper.selectById(1L);
        //2.更新用户信息
        user.setName("郭经伟1").setEmail("1447851361@qq.com");
        //模拟插队操作
        User user1 = userMapper.selectById(1L);
        user1.setName("gjw");
        userMapper.updateById(user1);
        userMapper.updateById(user);
    }
    @Test
    void testSelectBatchIds(){
        //测试查询
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4));
        users.forEach(System.out::println);
    }
    @Test
    void testSelectById(){
        //测试查询
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }
    @Test
    void testSelectByMap(){
        //条件查询
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name","gjw");
        List<User> users = userMapper.selectByMap(objectObjectHashMap);
        users.forEach(System.out::println);
    }
    @Test
    void testPage(){
        //测试分页查询
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }
    @Test
    void testDel(){
        userMapper.deleteById(3L);
    }

}
