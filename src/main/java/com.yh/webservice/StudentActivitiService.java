package com.yh.webservice;

import com.yh.vo.StuLeaveInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentActivitiService")
@Api(description = "流程处理类")
public interface StudentActivitiService {

    @PostMapping("/startProcess")
    @ApiOperation("开启流程")
    public void startProcess(@RequestBody StuLeaveInfoVO stuLeaveInfoVO);
}
