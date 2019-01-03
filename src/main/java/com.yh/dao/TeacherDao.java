package com.yh.dao;

import com.yh.entity.Student;
import com.yh.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * dao层
 */

@Mapper
@Component
public interface TeacherDao {

    /**
     * 新加一个老师
     * @param teacher 老师对象
     * @return 返回新增信息
     */
    int add(Teacher teacher);

    /**
     * 根据学生Id获取学生信息
     * @param stuId
     * @return 返回查询结果
     */
    Student getStudentByUserId(@Param("stuId") String stuId);

    /**
     * 根据老师Id删除老师信息
     * @param teaId
     * @return
     */
    int delById(@Param("teaId") String teaId);
}
