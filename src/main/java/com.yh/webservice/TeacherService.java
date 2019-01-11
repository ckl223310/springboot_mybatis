package com.yh.webservice;


import com.yh.exception.ResponseManager;
import com.yh.po.TeacherPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生信息处理接口
 */
@RestController
@RequestMapping("/teacher")
@Api(description = "老师处理类")
public interface TeacherService {

    /**
     * 添加老师
     * @param teacherPO
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加老师")
    ResponseManager addTeacher(@RequestBody TeacherPO teacherPO);

    /**
     * 删除老师
     * @param teaId
     * @return
     */
    @GetMapping("/del")
    @ApiOperation("删除老师")
    ResponseManager delById(@RequestParam("teaId") String teaId);
}
