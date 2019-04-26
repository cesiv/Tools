package com.jumper.pdf.controller;

import com.alibaba.fastjson.JSON;
import com.jumper.pdf.dto.QueryCondition;
import com.jumper.pdf.service.ExcelService;
import com.jumper.pdf.service.SearchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/lady", method = RequestMethod.GET)
public class WomanInfoController {

    @Autowired
    SearchInfoService searchInfoService;

    @Autowired
    ExcelService excelService;

    @ResponseBody
    @RequestMapping("/info")
    public String getResponse(HttpServletRequest request) {
  
        QueryCondition[] queryConditions = new QueryCondition[]{
              


             


        };
   


        List<QueryCondition> queryList = CollectionUtils.arrayToList(queryConditions);
        List<List<Map<Object, Object>>> infoCollections = new ArrayList<>();
        for (QueryCondition q : queryList) {
            List<Map<Object, Object>> resultList = null;
            /*if (!StringUtils.isEmpty(q.getMobile())) {
                System.out.println("进来A");
                resultList = searchInfoService.searchWomanInfoByCondition(q);
            } else {
                System.out.println("进来B");
                resultList = searchInfoService.searchWomanInfoWithName(q);
            }*/
            resultList = searchInfoService.searchRecordInfoWithID(q);
            infoCollections.add(resultList);
        }
        System.out.println("查询出来的数据条数：" + infoCollections.size());
        excelService.generateExcel(infoCollections);
        return JSON.toJSONString(infoCollections);
    }

    @ResponseBody
    @RequestMapping("/info2")
    public String getResponse2(HttpServletRequest request) {
   
        return null;
    }

}
