package com.tim.service;

import com.tim.dao.primary.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class DemoService {
    @Autowired
    private DemoDao dao;
    @Transactional
    public void delete() {
        try {
            dao.update();
            dao.delete();
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
