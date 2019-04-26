package com.jumper.pdf.dao;

import com.jumper.pdf.dto.QueryCondition;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface InfoDAO {
    List<Map<Object,Object>>  searchWomanInfoByCondition(QueryCondition queryCondition);
    List<Map<Object,Object>>  searchWomanInfoWithName(QueryCondition queryCondition);
    List<Map<Object,Object>>  searchRecordInfoWithRecordID(QueryCondition queryCondition);
}
