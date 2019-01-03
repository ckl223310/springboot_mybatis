package com.yh.dao;

import com.yh.entity.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 课程dao
 */
@Component
@Mapper
public interface ClassesDao {

    /**
     * 添加课程表
     * @param classesPO
     * @return
     */
    int add(Classes classes);

    /**
     * 返回课程信息
     * @param classes
     * @return
     */
    List<Classes> queryClasses(Classes classes);

    /**
     * 根据学生Id删除学生课程信息
     * @param stuId
     * @return
     */
    int delByStuId(@Param("stuId") String stuId);
}
