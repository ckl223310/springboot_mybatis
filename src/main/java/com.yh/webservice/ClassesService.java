package com.yh.webservice;

import com.yh.exception.ResponseManager;
import com.yh.po.ClassesPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
@Api(description = "课程表相关接口")
public interface ClassesService {

    @PostMapping("/add")
    @ApiOperation("添加课程表")
    ResponseManager add(@RequestBody ClassesPO classesPO);

}
