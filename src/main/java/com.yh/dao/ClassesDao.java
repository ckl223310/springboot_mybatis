package com.yh.dao;

import com.yh.entity.Classes;
import com.yh.po.ClassesPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
