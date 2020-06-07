package com.baomidou.service.impl;

import com.baomidou.entity.Student;
import com.baomidou.mapper.StudentMapper;
import com.baomidou.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郭经伟
 * @since 2020-06-06
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
