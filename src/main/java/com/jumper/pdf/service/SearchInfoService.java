package com.jumper.pdf.service;

import com.jumper.pdf.dto.QueryCondition;

import java.util.List;
import java.util.Map;

public interface SearchInfoService {
    List<Map<Object,Object>> searchWomanInfoByCondition(QueryCondition queryCondition);
    List<Map<Object,Object>> searchWomanInfoWithName(QueryCondition queryCondition);
    List<Map<Object,Object>> searchRecordInfoWithID(QueryCondition queryCondition);
}
