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
        return  super.query("SELECT u.user_id,u.age 年龄,u.last_period 末次月经,o.report_url 报告,o.report_time 解读时间,r.record_files 胎心文件,r.uterus_record 宫缩文件,r.fetal_move_value 胎动 FROM monitor_order_consumer o \n" +
                "LEFT JOIN user_extra_info u ON o.user_id=u.user_id\n" +
                "LEFT JOIN monitor_heartrate_record r ON o.record_id=r.id\n" +
                "LEFT JOIN user_info ui ON ui.id=o.user_id\n" +
                "WHERE o.is_auto=0 \n" +
                "AND ui.mobile =?\n" +
                "AND \n" +
                "( (UNIX_TIMESTAMP(r.add_time) >= UNIX_TIMESTAMP(?)-10000 AND UNIX_TIMESTAMP(r.add_time)<=UNIX_TIMESTAMP(?)+10000)\n" +
                "OR ( UNIX_TIMESTAMP(o.report_time) >= UNIX_TIMESTAMP(?)-10000 AND UNIX_TIMESTAMP(o.report_time)<=UNIX_TIMESTAMP(?)+10000)\n" +
                ")",new Object[]{queryCondition.getMobile(),queryCondition.getQueryTime(),queryCondition.getQueryTime(),queryCondition.getQueryTime(),queryCondition.getQueryTime()});
    }

    @Override
    public List<Map<Object, Object>> searchWomanInfoWithName(QueryCondition queryCondition) {
        String sql ="SELECT u.user_id,u.age 年龄,u.last_period 末次月经,o.report_url 报告,o.report_time 解读时间,r.record_files 胎心文件,r.uterus_record 宫缩文件,r.fetal_move_value 胎动 FROM monitor_order_consumer o \n" +
                "LEFT JOIN user_extra_info u ON o.user_id=u.user_id\n" +
                "LEFT JOIN monitor_heartrate_record r ON o.record_id=r.id\n" +
                "LEFT JOIN user_info ui ON ui.id=o.user_id\n" +
                "WHERE o.is_auto=0 \n" +
                "AND u.real_name =?\n" +
                "AND \n" +
                "( (UNIX_TIMESTAMP(r.add_time) >= UNIX_TIMESTAMP(?)-10000 AND UNIX_TIMESTAMP(r.add_time)<=UNIX_TIMESTAMP(?)+10000)\n" +
                "OR ( UNIX_TIMESTAMP(o.report_time) >= UNIX_TIMESTAMP(?)-10000 AND UNIX_TIMESTAMP(o.report_time)<=UNIX_TIMESTAMP(?)+10000)\n" +
                ")";

        System.out.println("sql = [" + sql + "]");
        System.out.println("queryCondition = [" + JSON.toJSONString(queryCondition) + "]");
        return  super.query(sql,new Object[]{queryCondition.getName(),queryCondition.getQueryTime(),queryCondition.getQueryTime(),queryCondition.getQueryTime(),queryCondition.getQueryTime()});
    }

    @Override
    public List<Map<Object, Object>> searchRecordInfoWithRecordID(QueryCondition queryCondition) {

        String sql ="SELECT u.user_id,u.age 年龄,u.last_period 末次月经,o.report_url 报告,o.report_time 解读时间,r.record_files 胎心文件,r.uterus_record 宫缩文件,r.fetal_move_value 胎动 ,r.id  监测记录ID FROM monitor_order_consumer o \n" +
                "LEFT JOIN user_extra_info u ON o.user_id=u.user_id\n" +
                "LEFT JOIN monitor_heartrate_record r ON o.record_id=r.id\n" +
                "LEFT JOIN user_info ui ON ui.id=o.user_id\n" +
                "WHERE o.is_auto=0 \n" +
                "AND r.id =?\n";
        return super.query(sql,new Object[]{queryCondition.getRecordId()});
    }
}
