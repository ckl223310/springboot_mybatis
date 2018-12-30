package com.yh.webservice;


import com.yh.entity.Student;
import com.yh.exception.ResponseManager;
import com.yh.po.StudentPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 学生信息处理接口
 */
@RestController
@RequestMapping("/student")
@Api(description = "学生处理类")
public interface StudentService {

    @PostMapping("/add")
    @ApiOperation("添加学生")
    ResponseManager addStudent(@RequestBody StudentPO studentPO);

    @GetMapping("/getStudentByUserId")
    @ApiOperation("根据学号查询出该学生的信息")
    ResponseManager<Student> getStudentByUserId(@RequestParam("stuId") String stuId);

    @GetMapping("/del")
    @ApiOperation("删除学生")
    ResponseManager delStudent(@RequestParam("stuId") String stuId);
}
