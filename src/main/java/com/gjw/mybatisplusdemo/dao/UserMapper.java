package com.gjw.mybatisplusdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gjw.mybatisplusdemo.model.User;;

/**
 * Mapper接口
 * 基于MyBatis:在Mapper接口中写CRUD的方法 在Mapper接口对应的SQL映射文件中写与其方法对应的SQL语句
 * 基于MP: 让xxMapper继承BaseMapper接口就行
 *        BaseMapper<T>:泛型指定的就是当前Mapper对应的实体类
 *        开启Mapper扫描 分析UserMapper所对应的实体User所对应的User表
 *        生成一些基本的crud 注入到MyBatis Container中
 * CRUD全局配置=>MyBatis的配置文件
 */
public interface UserMapper extends BaseMapper<User> {
}
