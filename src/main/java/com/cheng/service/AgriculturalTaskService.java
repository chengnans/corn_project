package com.cheng.service;

import com.cheng.dao.AgriculturalTaskDAO;
import com.cheng.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AgriculturalTaskService {

    @Autowired
    private AgriculturalTaskDAO taskDAO;
    // 根据方案 ID 获取任务列表
    public List<AgriculturalTask> getTasksBySchemeId(Integer schemeId) {
        return (List<AgriculturalTask>) taskDAO.findAllBySchemeId(schemeId);
    }

    // 新增任务
    public AgriculturalTask addTask(AgriculturalTask task) {
        return taskDAO.save(task); // 假设 DAO 层使用了 JPA 的 save 方法
    }
    // 新增方法：获取格式化后的任务数据
    public SchemeResponse getFormattedTasksBySchemeId(Integer schemeId) {
        // 获取所有与指定方案相关的任务
        List<AgriculturalTask> tasks = (List<AgriculturalTask>) taskDAO.findAllBySchemeId(schemeId);

        // 初始化结果对象
        SchemeResponse response = new SchemeResponse();

        // 提取 scheme 信息
        if (!tasks.isEmpty()) {
            Scheme scheme = tasks.get(0).getScheme();
            response.setScheme(scheme);
        }

        // 按阶段分组任务
        Map<String, StageTask> stageMap = new HashMap<>();
        for (AgriculturalTask task : tasks) {
            String stage = task.getStage();
            if (!stageMap.containsKey(stage)) {
                stageMap.put(stage, new StageTask());
                StageTask stageTask = stageMap.get(stage);
                stageTask.setStage(stage);
                stageTask.setStartDate(task.getStartDate().toString());
                stageTask.setEndDate(task.getEndDate().toString());
            }

            // 累加资源用量
            StageTask stageTask = stageMap.get(stage);
            stageTask.setWaterUsage(stageTask.getWaterUsage() + task.getWaterUsage());
            stageTask.setNitrogenUsage(stageTask.getNitrogenUsage() + task.getNitrogenUsage());
            stageTask.setPhosphorusUsage(stageTask.getPhosphorusUsage() + task.getPhosphorusUsage());
            stageTask.setPotassiumUsage(stageTask.getPotassiumUsage() + task.getPotassiumUsage());

            // 添加具体任务
            if (task.getTaskName() != null && task.getTaskDate() != null && task.getCondition() != null) {
                TaskDetail taskDetail = new TaskDetail();
                taskDetail.setName(task.getTaskName());
                taskDetail.setDate(task.getTaskDate().toString());
                taskDetail.setCondition(task.getCondition());
                stageTask.getTasks().add(taskDetail);
            }
        }

        // 将分组结果加入响应对象
        response.setAgriculturalTasks(new ArrayList<>(stageMap.values()));

        return response;
    }
    // 新增方法：获取实时环境数据和近期农事计划
    public EnvironmentDataResponse getEnvironmentDataAndRecentPlan() {
        EnvironmentDataResponse response = new EnvironmentDataResponse();

        // 查询最新的环境数据
        EnvironmentData envData = taskDAO.findLatestEnvironmentData();
        if (envData != null) {
            response.setTemperature(envData.getTemperature());
            response.setHumidity(envData.getHumidity());
            response.setSoilMoisture(envData.getSoilMoisture());
        }

        // 查询所有近期农事计划
        List<String> recentPlans = taskDAO.findAllRecentPlans();
        response.setRecentPlans(recentPlans);

        return response;
    }
}
