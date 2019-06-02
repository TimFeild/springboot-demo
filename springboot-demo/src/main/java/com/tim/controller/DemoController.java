package com.tim.controller;

import com.tim.dao.oracle.OracleDemoDao;
import com.tim.dao.primary.DemoDao;
import com.tim.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoDao dao;
    @Autowired
    private OracleDemoDao odao;
    @Autowired
    private DemoService service;

    @GetMapping("/select/{source}")
    public List<Map<String, String>> select(@PathVariable(name = "source") String source) {
        if ("mysql".equals(source)) {
            return dao.select();
        } else {
            return odao.select();
        }
    }

    @GetMapping("/delete")
    public void delete() {
        service.delete();
    }
}
