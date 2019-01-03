package com.yh.service;

import com.yh.dao.TeacherDao;
import com.yh.entity.Teacher;
import com.yh.eum.ErrorEnum;
import com.yh.exception.ResponseManager;
import com.yh.po.TeacherPO;
import com.yh.utils.ResultUtils;
import com.yh.utils.StringBaseUtils;
import com.yh.webservice.TeacherService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author czh
 * @date 2019-01-03
 */
public class TeacherServiceImpl implements TeacherService {

    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);


    /**
     * dao
     */
    @Autowired
    private TeacherDao teacherDao;


    @Override
    public ResponseManager addTeacher(TeacherPO teacherPO) {

        if (teacherPO == null) {
            LOGGER.error(ErrorEnum.NOT_VALUE_ERROR.getMsg());
            return ResultUtils.error(ErrorEnum.NOT_VALUE_ERROR.getCode(), ErrorEnum.NOT_VALUE_ERROR.getMsg());
        }

        String teaName = teacherPO.getTeaName();
        teaName = StringUtils.isEmpty(teaName) ?  "" : teaName.trim();

        if (StringUtils.isEmpty(teaName)) {
            return ResultUtils.error("名称不能为空");
        }



        try {
            Teacher teacher = new Teacher();
            teacher.setTeaId(StringBaseUtils.getId());
            teacher.setTeaName(teaName);
            teacher.setBirth(teacherPO.getBirth());
            teacher.setDetail(teacherPO.getDetail());
            teacher.setSex(teacherPO.getSex());
            teacherDao.add(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.error(e.getMessage());
        }

        return ResultUtils.success();
    }


    @Override
    public ResponseManager delById(String teaId) {
        return null;
    }
}
