package com.jumper.pdf.dao.impl;

import com.alibaba.fastjson.JSON;
import com.jumper.pdf.core.BaseDAO;
import com.jumper.pdf.dao.InfoDAO;
import com.jumper.pdf.dto.QueryCondition;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class InfoDAOImpl extends BaseDAO implements InfoDAO {

    @Override
    public List<Map<Object, Object>> searchWomanInfoByCondition(QueryCondition queryCondition) {
        return  super.query("")",new Object[]{queryCondition.getMobile(),queryCondition.getQueryTime(),queryCondition.getQueryTime(),queryCondition.getQueryTime(),queryCondition.getQueryTime()});
    }

    @Override
    public List<Map<Object, Object>> searchWomanInfoWithName(QueryCondition queryCondition) {
        String sql ="";

        System.out.println("sql = [" + sql + "]");
        System.out.println("queryCondition = [" + JSON.toJSONString(queryCondition) + "]");
        return  super.query(sql,new Object[]{queryCondition.getName(),queryCondition.getQueryTime(),queryCondition.getQueryTime(),queryCondition.getQueryTime(),queryCondition.getQueryTime()});
    }

    @Override
    public List<Map<Object, Object>> searchRecordInfoWithRecordID(QueryCondition queryCondition) {

        String sql ="";
        return super.query(sql,new Object[]{queryCondition.getRecordId()});
    }
}
