package com.cheng.dao;

import com.cheng.model.AgriculturalTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgriculturalTaskDAO extends JpaRepository<AgriculturalTask, Integer> {
    Iterable<AgriculturalTask> findAllBySchemeId(Integer schemeId);
}
