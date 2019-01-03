package com.yh.webservice;

import com.yh.entity.Classes;
import com.yh.exception.ResponseManager;
import com.yh.po.ClassesPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程表相关接口
 */
@RestController
@RequestMapping("/class")
@Api(description = "课程表相关接口")
public interface ClassesService {

    /**
     * 添加课程表
     * @param classesPO
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加课程表")
    ResponseManager add(@RequestBody ClassesPO classesPO);

    /**
     * 获取课程表信息
     * @param classes
     * @return
     */
    @GetMapping("/queryClasses")
    @ApiOperation("获取课程表信息")
    ResponseManager queryClasses(Classes classes);
}
