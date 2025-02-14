package com.cheng.model;

import java.util.List;

public class SchemeResponse {
    private Scheme scheme; // 农业方案信息
    private List<StageTask> agriculturalTasks; // 按阶段分组的任务

    // Getters and Setters
    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }

    public List<StageTask> getAgriculturalTasks() {
        return agriculturalTasks;
    }

    public void setAgriculturalTasks(List<StageTask> agriculturalTasks) {
        this.agriculturalTasks = agriculturalTasks;
    }
}
