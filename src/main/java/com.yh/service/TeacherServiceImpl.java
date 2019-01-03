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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author czh
 * @date 2019-01-03
 */
@Service
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
    public ResponseManager addTeacher(@RequestBody TeacherPO teacherPO) {

        if (teacherPO == null) {
            LOGGER.error(ErrorEnum.NOT_VALUE_ERROR.getMsg());
            return ResultUtils.error(ErrorEnum.NOT_VALUE_ERROR.getCode(), ErrorEnum.NOT_VALUE_ERROR.getMsg());
        }

        String teaName = teacherPO.getTeaName();
        teaName = StringUtils.isEmpty(teaName) ?  "" : teaName.trim();

        if (StringUtils.isEmpty(teaName)) {
            return ResultUtils.error("名称不能为空");
        }

        char sex = teacherPO.getSex();

        sex = StringUtils.equals(sex + "", "男") ? '男' : '女';

        try {
            Teacher teacher = new Teacher();
            teacher.setTeaId(StringBaseUtils.getId());
            teacher.setTeaName(teaName);
            teacher.setBirth(teacherPO.getBirth());
            teacher.setDetail(teacherPO.getDetail());
            teacher.setSex(sex);
            teacherDao.add(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.error(e.getMessage());
        }

        return ResultUtils.success();
    }


    @Override
    public ResponseManager delById(@RequestParam("teaId") String teaId) {

        if (StringUtils.isEmpty(teaId)) {
            return ResultUtils.error(ErrorEnum.NOT_VALUE_ERROR.getMsg());
        }

        try {

            int count = teacherDao.delById(teaId);
            if (count <= 0) {
                return ResultUtils.error("删除老师信息失败");
            }

            return ResultUtils.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.error(e.getMessage());
        }
    }
}
