package com.cheng.model;

import java.util.ArrayList;
import java.util.List;

public class StageTask {
    private String stage; // 生长阶段
    private String startDate; // 阶段开始日期
    private String endDate; // 阶段结束日期
    private Double waterUsage = 0.0; // 默认值为 0.0
    private Double nitrogenUsage = 0.0; // 默认值为 0.0
    private Double phosphorusUsage = 0.0; // 默认值为 0.0
    private Double potassiumUsage = 0.0; // 默认值为 0.0
    private List<TaskDetail> tasks = new ArrayList<>(); // 初始化为空列表

    // Getters and Setters
    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getWaterUsage() {
        return waterUsage;
    }

    public void setWaterUsage(Double waterUsage) {
        this.waterUsage = waterUsage == null ? 0.0 : waterUsage; // 防止传入 null
    }

    public Double getNitrogenUsage() {
        return nitrogenUsage;
    }

    public void setNitrogenUsage(Double nitrogenUsage) {
        this.nitrogenUsage = nitrogenUsage == null ? 0.0 : nitrogenUsage; // 防止传入 null
    }

    public Double getPhosphorusUsage() {
        return phosphorusUsage;
    }

    public void setPhosphorusUsage(Double phosphorusUsage) {
        this.phosphorusUsage = phosphorusUsage == null ? 0.0 : phosphorusUsage; // 防止传入 null
    }

    public Double getPotassiumUsage() {
        return potassiumUsage;
    }

    public void setPotassiumUsage(Double potassiumUsage) {
        this.potassiumUsage = potassiumUsage == null ? 0.0 : potassiumUsage; // 防止传入 null
    }

    public List<TaskDetail> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDetail> tasks) {
        this.tasks = tasks == null ? new ArrayList<>() : tasks; // 防止传入 null
    }
}
