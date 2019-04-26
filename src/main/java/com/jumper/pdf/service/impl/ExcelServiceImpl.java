package com.jumper.pdf.service.impl;

import com.alibaba.fastjson.JSON;
import com.jumper.pdf.service.ExcelService;
import com.jumper.pdf.utils.OriginalAddContent;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@Service
public class ExcelServiceImpl implements ExcelService {

    private static String outPutFile = "F:" + File.separator + "user.xls";
    private static String pdfSavePath ="F:"+File.separator+"savepdf";
   private static final String BaseURL = "http://oss-yjk.oss-cn-shenzhen.aliyuncs.com";
   //private static final String BaseURL = "http://image.jumper-health.com";

    @Override
    public void generateExcel(List<List<Map<Object, Object>>> collections) {

        FileOutputStream fos = null;
        try {
            HSSFWorkbook workBook = new HSSFWorkbook();
            //在workBook对象中创建一张表格
            HSSFSheet sheet = workBook.createSheet();
            //设置每一列的宽度
       /* for(int i=0;i<resultList.size();i++){
            sheet.setColumnWidth(i, resultList.get(i).keySet());
        }*/
            //sheet.setDefaultColumnWidth(100*256);
            //单元格样式对象
            HSSFCellStyle cellStyle = workBook.createCellStyle();
            //设置文本居中
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            //创建第0行,作为表格的表头
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = null;

            for (int i = 0; i < collections.size(); i++) {
                List<Map<Object, Object>> resultList = collections.get(i);
                if(resultList.size()<=0){
                    continue;
                }
                Map<Object, Object> map = resultList.get(0);
                System.out.println("tttt:" + JSON.toJSONString(map));
                for (int j = 0; j < map.keySet().size(); j++) {
                    Iterator<Map.Entry<Object, Object>> iter = map.entrySet().iterator();
                    int counter = 0;
                    for (Map.Entry<Object, Object> entry : map.entrySet()) {
                        cell = row.createCell(counter);
                        cell.setCellValue(entry.getKey().toString());
                        cell.setCellStyle(cellStyle);
                        counter++;
                    }
                }
            }
            int rowIndex = 1;
            for (int x = 0; x < collections.size(); x++) {
                List<Map<Object, Object>> resultList = collections.get(x);   //数据集合
                if(resultList.size()<=0){
                    continue;
                }
                for (int y = 0; y < resultList.size(); y++) {
                    Map<Object, Object> map = resultList.get(y);        //真实数据
                    row=sheet.createRow(rowIndex);
                    for (int m = 0; m < map.keySet().size(); m++) {    //遍历每条数据
                        int count2 = 0;

                        for (Map.Entry<Object, Object> entry : map.entrySet()) {
                            if(null==entry.getValue()){
                                count2++;
                                continue;
                            }
                            cell = row.createCell(count2);
                            cell.setCellValue(entry.getValue().toString());
                            if (count2 == 3 || count2 == 5 || count2 == 6) {
                                String pdfUrl =BaseURL + entry.getValue().toString();
                                cell.setCellValue(pdfUrl);
                                if(count2==3){
                                   /* UrlGenarate.downLoadFromUrl(pdfUrl,entry.getValue().toString().substring(entry.getValue().toString().lastIndexOf("/")),pdfSavePath);*/
                                }
                            }
                            cell.setCellStyle(cellStyle);
                            count2++;
                        }
                    }
                    rowIndex++;
                }

            }
            fos = new FileOutputStream(outPutFile);
            //输出流将文件写到硬盘
            workBook.write(fos);
            fos.flush();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                OriginalAddContent.doWork(pdfSavePath);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
