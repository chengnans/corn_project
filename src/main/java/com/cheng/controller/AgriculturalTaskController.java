package com.cheng.controller;

import com.cheng.model.AgriculturalTask;
import com.cheng.model.EnvironmentData;
import com.cheng.model.EnvironmentDataResponse;
import com.cheng.model.SchemeResponse;
import com.cheng.service.AgriculturalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AgriculturalTaskController {

    @Autowired
    private AgriculturalTaskService taskService;

    // 原有接口：按方案 ID 获取任务列表
    @GetMapping("/by-scheme/{schemeId}")
    public List<AgriculturalTask> getTasksBySchemeId(@PathVariable Integer schemeId) {
        return taskService.getTasksBySchemeId(schemeId);
    }

    // 新增接口：按方案 ID 获取格式化后的任务数据
    @GetMapping("/scheme/{schemeId}")
    public SchemeResponse getFormattedTasksBySchemeId(@PathVariable Integer schemeId) {
        return taskService.getFormattedTasksBySchemeId(schemeId);
    }

    // 原有接口：新增任务
    @PostMapping
    public AgriculturalTask addTask(@RequestBody AgriculturalTask task) {
        return taskService.addTask(task);
    }
    // 新增接口：获取实时环境数据和近期农事计划
    @GetMapping("/environment-plan")
    public EnvironmentDataResponse getEnvironmentDataAndRecentPlan() {
        return taskService.getEnvironmentDataAndRecentPlan();
    }
}
