package com.gjw.mybatisplusdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用一个第三方组件
 * 1.导入相关依赖
 * 2.研究依赖如何配置
 * 3.代码如何编写
 * 4.提高扩展技术能力
 * MyBatis Plus 核心功能
 * 代码生成器
 * CRUD接口
 * 条件构造器
 * 分页插件
 * Sequence主键
 * 自定义ID生成器
 */
@SpringBootApplication
public class MybatisplusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusDemoApplication.class, args);
    }

}
