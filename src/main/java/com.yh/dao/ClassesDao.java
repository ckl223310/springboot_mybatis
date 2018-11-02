package com.yh.dao;

import com.yh.po.ClassesPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ClassesDao {

    /**
     * 添加课程表
     * @param classesPO
     * @return
     */
    int add(ClassesPO classesPO);
}
