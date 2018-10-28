package com.yh.dao;

import com.yh.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StudentDao {

    int add(Student student);

    Student getStudentByUserId(@Param("stuId") String stuId);
}
