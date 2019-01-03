package com.yh.service;

import com.yh.webservice.StudentActivitiService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author czh
 * date 2019-01-03
 */
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

    @Override
    public void startProcess() {


        runtimeService.startProcessInstanceById("");

    }
}
