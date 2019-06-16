package com.tim.controller;

import com.tim.dao.oracle.OracleDemoDao;
import com.tim.dao.primary.DemoDao;
import com.tim.service.DemoService;
import com.tim.vo.Demo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
@Api
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

    @DeleteMapping("/delete")
    public void delete() {
        service.delete();
    }

    @GetMapping("/get")
    public void getNormalBean() {
        System.out.println(service);

        System.out.println("proxy");
    }
}
