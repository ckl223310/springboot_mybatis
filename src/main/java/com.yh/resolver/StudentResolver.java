package com.yh.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.yh.dao.StudentDao;
import com.yh.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 添加类/接口功能描述
 *
 * @author czh
 * date 2019-04-29
 */
public class StudentResolver implements GraphQLResolver<Student> {

    @Autowired
    private StudentDao studentDao;

    public Student getStudentList(Student student) {
        return studentDao.getStudentByUserId(student.getStuId());
    }
}
