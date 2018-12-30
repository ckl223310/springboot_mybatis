package com.yh.service;

import com.yh.dao.ClassesDao;
import com.yh.dao.StudentDao;
import com.yh.entity.Student;
import com.yh.eum.ErrorEnum;
import com.yh.exception.ResponseManager;
import com.yh.po.StudentPO;
import com.yh.utils.ResultUtils;
import com.yh.utils.StringBaseUtils;
import com.yh.webservice.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * student 实现类
 */
@Service
public class StudentServiceImpl implements StudentService {

    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    /**
     * studentDao
     */
    @Autowired
    private StudentDao studentDao;

    /**
     * classesDao
     */
    @Autowired
    private ClassesDao classesDao;

    /**
     * 新增一个学生
     *
     * @param studentPO 前台向后台传递的参数对象
     * @return 返回所需信息
     */
    @Override
    public ResponseManager addStudent(@RequestBody StudentPO studentPO) {

        if (studentPO == null) {
            LOGGER.error(ErrorEnum.NOT_VALUE_ERROR.getMsg());
            return ResultUtils.error(ErrorEnum.NOT_VALUE_ERROR.getCode(), ErrorEnum.NOT_VALUE_ERROR.getMsg());
        }

        String phone = studentPO.getPhone();
        if (!StringBaseUtils.isPhone(phone)) {
            LOGGER.error(ErrorEnum.NOT_PHONE.getMsg());
            return ResultUtils.error(ErrorEnum.NOT_PHONE.getCode(),
                    ErrorEnum.NOT_PHONE.getMsg());
        }

        try {
            Student student = new Student();

            student.setStuId(StringBaseUtils.getId());
            student.setStuName(studentPO.getStuName());
            student.setPhone(phone);
            student.setBirth(studentPO.getBirth());
            student.setSex(studentPO.getSex());
            student.setAddr(studentPO.getAddr());
            student.setDetail(studentPO.getDetail());
            studentDao.add(student);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
            return ResultUtils.error("新增学生失败！");
        }

        return ResultUtils.success("新增学生成功！");
    }

    /**
     * 根据学号查询出该学生的信息
     *
     * @param stuId 学号
     * @return
     */
    @Override
    public ResponseManager<Student> getStudentByUserId(@RequestParam("stuId") String stuId) {

        if (StringUtils.isEmpty(stuId)) {
            LOGGER.error(ErrorEnum.NOT_VALUE_ERROR.getMsg());
            return ResultUtils.error(ErrorEnum.NOT_VALUE_ERROR.getCode(), ErrorEnum.NOT_VALUE_ERROR.getMsg());
        }


        Student student = null;
        try {
            student = studentDao.getStudentByUserId(stuId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResultUtils.error(e.getMessage());
        }
        System.out.println(student.toString());
        return ResultUtils.success(student);
    }

    /**
     * 删除学生
     *
     * @param stuId 学生Id
     * @return
     */
    @Override
    @Transactional
    public ResponseManager delStudent(@RequestParam("stuId") String stuId) {

        if (StringUtils.isEmpty(stuId)) {
            return ResultUtils.error(ErrorEnum.NOT_VALUE_ERROR.getMsg());
        }

        try {

            int count = studentDao.delByStuId(stuId);
            if (count <= 0) {
                return ResultUtils.error("删除学生信息失败");
            }

            count = classesDao.delByStuId(stuId);
            if (count <= 0) {
                return ResultUtils.error("删除学生课程信息失败");
            }

            return ResultUtils.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.error(e.getMessage());
        }
    }
}
