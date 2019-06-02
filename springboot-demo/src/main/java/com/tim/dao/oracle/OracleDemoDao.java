package com.tim.dao.oracle;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OracleDemoDao {
    List<Map<String,String>> select();
}
