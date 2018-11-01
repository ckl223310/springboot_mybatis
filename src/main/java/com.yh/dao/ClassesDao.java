package com.yh.dao;

import com.yh.po.ClassesPO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ClassesDao {

    int add(ClassesPO classesPO);
}
