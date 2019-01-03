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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
        taskService.complete(task.getId(), map);
    }

    /**
     * 获取审批流程
     * @param userId
     */
    @Override
    public List<Map<String, Object>> getConfirm(@RequestParam("userId") String userId,
                                                @RequestParam("page") Integer page,
                                                @RequestParam("pageSize") Integer pageSize) {

        page = page == null ? 0 : page - 1;
        pageSize = pageSize == null? 10 : pageSize;

        List<Task> taskList = taskService.createTaskQuery().processDefinitionKey("myProcess_1").taskAssignee(userId).listPage(page, pageSize);

        List<Map<String, Object>> mapList = new ArrayList<>();
        if (taskList == null || taskList.size() == 0) {
            return mapList;
        }

        for (Task task : taskList) {
            Map<String, Object> map = taskService.getVariables(task.getId());
            map.put("taskId", task.getId());
            mapList.add(map);
        }


        return mapList;
    }

    @Override
    public void confirmTask(@RequestParam("taskId") String taskId,
                            @RequestParam("userId") Boolean isConfirm) {

        Map<String, Object> map = new HashMap<>();
        map.put("isTrue", isConfirm);
        taskService.complete(taskId, map);
    }


}
