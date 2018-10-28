package com.yh.dao;

import com.yh.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * dao层
 */
@Mapper
@Component
public interface StudentDao {

    /**
     * 新加一个学生
     * @param student 学生对象
     * @return 返回新增信息
     */
    int add(Student student);

    /**
     * 根据学生Id获取学生信息
     * @param stuId
     * @return 返回查询结果
     */
    Student getStudentByUserId(@Param("stuId") String stuId);
}
