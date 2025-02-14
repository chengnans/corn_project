package com.cheng.controller;

import com.cheng.model.Scheme;
import com.cheng.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schemes")
public class SchemeController {
    @Autowired
    private SchemeService schemeService;

    @GetMapping
    public List<Scheme> getAllSchemes() {
        return schemeService.getAllSchemes();
    }

    @PostMapping
    public Scheme addScheme(@RequestBody Scheme scheme) {
        return schemeService.addScheme(scheme);
    }
}
