package com.cheng.dao;

import com.cheng.model.AgriculturalTask;
import com.cheng.model.EnvironmentData;
import com.cheng.model.EnvironmentDataResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgriculturalTaskDAO extends JpaRepository<AgriculturalTask, Integer> {
    Iterable<AgriculturalTask> findAllBySchemeId(Integer schemeId);

    // 查询最新的环境数据
    @Query("SELECT e FROM EnvironmentData e ORDER BY e.id DESC LIMIT 1")
    EnvironmentData findLatestEnvironmentData();

    // 查询所有近期农事计划
    @Query("SELECT r.planItem FROM RecentPlan r")
    List<String> findAllRecentPlans();
}
