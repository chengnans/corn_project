package com.cheng.service;

import com.cheng.dao.SchemeDAO;
import com.cheng.model.Scheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeService {
    @Autowired
    private SchemeDAO schemeDAO;

    public List<Scheme> getAllSchemes() {
        return schemeDAO.findAll();
    }

    public Scheme addScheme(Scheme scheme) {
        return schemeDAO.save(scheme);
    }
}
