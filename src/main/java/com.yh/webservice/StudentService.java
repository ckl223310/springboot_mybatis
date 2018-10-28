package com.yh.webservice;


import com.yh.entity.Student;
import com.yh.exception.ResponseManager;
import com.yh.po.StudentPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@Api("学生处理类")
public interface StudentService {

    @PostMapping("/add")
    @ApiOperation("添加学生")
    ResponseManager addStudent(@RequestBody StudentPO studentPO);

    @GetMapping("/getStudentByUserId")
    ResponseManager<Student> getStudentByUserId(@RequestParam("stuId") String stuId);
}
