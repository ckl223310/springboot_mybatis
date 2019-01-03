package com.yh.service;

import com.yh.vo.StuLeaveInfoVO;
import com.yh.webservice.StudentActivitiService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author czh
 * date 2019-01-03
 */
@Service
public class StudentActivitiServiceImpl implements StudentActivitiService {

    /**
     * 部署服务
     */
    @Autowired
    private RepositoryService repositoryService;

    /**
     * 运行服务
     */
    @Autowired
    private RuntimeService runtimeService;

    /**
     * 历史服务
     */
    @Autowired
    private HistoryService historyService;

    /**
     * 任务服务
     */
    @Autowired
    private TaskService taskService;

    /**
     * 启动流程
     */
    @Override
    public void startProcess(@RequestBody StuLeaveInfoVO stuLeaveInfoVO) {


        Map<String, Object> map = new HashMap<>();

        map.put(stuLeaveInfoVO.getStuId(), stuLeaveInfoVO);
        map.put("stuId", stuLeaveInfoVO.getStuId());

        //开启流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1", map);
        System.out.println(processInstance.getId());

        Task task = taskService.createTaskQuery().taskAssignee(stuLeaveInfoVO.getStuId()).singleResult();
        System.out.println(task.getId());

        map.put("teaId", stuLeaveInfoVO.getTeaId());
        taskService.complete(task.getId());
    }
}
