package com.cheng.controller;

import com.cheng.model.AgriculturalTask;
import com.cheng.service.AgriculturalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class AgriculturalTaskController {
    @Autowired
    private AgriculturalTaskService taskService;

    @GetMapping("/by-scheme/{schemeId}")
    public List<AgriculturalTask> getTasksBySchemeId(@PathVariable Integer schemeId) {
        return taskService.getTasksBySchemeId(schemeId);
    }

    @PostMapping
    public AgriculturalTask addTask(@RequestBody AgriculturalTask task) {
        return taskService.addTask(task);
    }
}
