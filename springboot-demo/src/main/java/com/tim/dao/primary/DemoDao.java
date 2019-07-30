package com.tim.dao.primary;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DemoDao {
    List<Map<String,Object>> select();

    void delete();

    void update();
}
