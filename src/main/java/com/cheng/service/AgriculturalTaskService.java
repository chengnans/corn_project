package com.cheng.service;

import com.cheng.dao.AgriculturalTaskDAO;
import com.cheng.model.AgriculturalTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgriculturalTaskService {
    @Autowired
    private AgriculturalTaskDAO taskDAO;

    public List<AgriculturalTask> getTasksBySchemeId(Integer schemeId) {
        return (List<AgriculturalTask>) taskDAO.findAllBySchemeId(schemeId);
    }

    public AgriculturalTask addTask(AgriculturalTask task) {
        return taskDAO.save(task);
    }
}
