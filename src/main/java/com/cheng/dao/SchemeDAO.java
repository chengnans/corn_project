package com.cheng.dao;

import com.cheng.model.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchemeDAO extends JpaRepository<Scheme, Integer> {
}
