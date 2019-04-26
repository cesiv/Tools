package com.jumper.pdf.service.impl;

import com.jumper.pdf.dao.InfoDAO;
import com.jumper.pdf.dto.QueryCondition;
import com.jumper.pdf.service.SearchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;
@Service
public class SearchInfoServiceImpl implements SearchInfoService {
    private static String outPutFile = "F:" + File.separator + "user.xls";

    private static final  String BaseURL = "http://oss-yjk.oss-cn-shenzhen.aliyuncs.com";
    @Autowired
    InfoDAO infoDAO;

    @Override
    public List<Map<Object, Object>> searchWomanInfoByCondition(QueryCondition queryCondition) {
        return infoDAO.searchWomanInfoByCondition(queryCondition);
    }

    @Override
    public List<Map<Object, Object>> searchWomanInfoWithName(QueryCondition queryCondition) {
        return infoDAO.searchWomanInfoWithName(queryCondition);
    }

    @Override
    public List<Map<Object, Object>> searchRecordInfoWithID(QueryCondition queryCondition) {
        return infoDAO.searchRecordInfoWithRecordID(queryCondition);
    }
}
