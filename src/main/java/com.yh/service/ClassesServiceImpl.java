package com.yh.service;

import com.yh.dao.ClassesDao;
import com.yh.entity.Classes;
import com.yh.exception.ResponseManager;
import com.yh.po.ClassesPO;
import com.yh.utils.ResultUtils;
import com.yh.utils.StringBaseUtils;
import com.yh.webservice.ClassesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 课程service
 */
@Service
public class ClassesServiceImpl implements ClassesService {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassesServiceImpl.class);

    /**
     * 课程表dao层
     */
    @Autowired
    private ClassesDao classesDao;

    /**
     * 添加课程表
     *
     * @param classesPO
     * @return
     */
    @Override
    public ResponseManager add(@RequestBody ClassesPO classesPO) {

        String stuId = classesPO.getStuId();
        String teaId = classesPO.getTeaId();
        Integer hours = classesPO.getHours();
        String className = classesPO.getClassName();

        try {
            Classes classes = new Classes();
            classes.setClassId(StringBaseUtils.getId());
            classes.setClassName(className);
            classes.setHours(hours);
            classes.setTeaId(teaId);
            classes.setStuId(stuId);
            classes.setDetail(classesPO.getDetail());

            classesDao.add(classes);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResultUtils.error(e.getMessage());
        }
        return ResultUtils.success("添加课程表成功！");
    }

    @Override
    public ResponseManager queryClasses(Classes classes) {

        if (classes == null) {
            return ResultUtils.error("传参不能为空！");
        }

        try {
            List<Classes> classesList = classesDao.queryClasses(classes);
            return ResultUtils.success(classesList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResultUtils.error(e.getMessage());
        }
    }
}
