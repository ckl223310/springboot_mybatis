package com.yh.webservice;

import com.yh.vo.StuLeaveInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/studentActivitiService")
@Api(description = "流程处理类")
public interface StudentActivitiService {

    @PostMapping("/startProcess")
    @ApiOperation("开启流程")
    public void startProcess(@RequestBody StuLeaveInfoVO stuLeaveInfoVO);


    @GetMapping("/getConfirm")
    @ApiOperation("获取审批流程")
    public List<Map<String, Object>> getConfirm(@RequestParam("userId") String userId,
                                                @RequestParam("page") Integer page,
                                                @RequestParam("pageSize") Integer pageSize);


    @GetMapping("/confirmTask")
    @ApiOperation("审批请假")
    public void confirmTask(@RequestParam("taskId") String taskId,
                            @RequestParam("userId") Boolean isConfirm);
}
