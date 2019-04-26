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
   /* QueryCondition[] queryConditions = new QueryCondition[]{
        new QueryCondition("15986632747", "2019-1-28 13:37:48"),
        new QueryCondition("15657935176", "2019-1-27 0:35:04"),
        new QueryCondition("13640976396", "2019-1-26 22:04:05"),
        new QueryCondition("18926482749", "2019-1-26 10:48:15"),
    };*/
    /* QueryCondition[] queryConditions = new QueryCondition[]{
        new QueryCondition("13590339201", "2019-1-26 21:58:09"),
        new QueryCondition("18580198272", "2019-1-24 22:29:02"),
        new QueryCondition("13425158205", "2019-1-27 22:22:00"),
        new QueryCondition("18123738851", "2019-1-28 9:53:07"),
        new QueryCondition("13692295532", "2019-1-24 23:03:50"),
        new QueryCondition("15267992041", "2019-1-16 12:28:22"),
        new QueryCondition("15099922040", "2018-12-28 2:29:42"),
        new QueryCondition("13924626275", "2019-1-23 21:54:18"),
        new QueryCondition("18899853813", "2019-1-24 22:29:19"),
        new QueryCondition("13794462455", "2019-1-26 20:27:34"),
        new QueryCondition("18718572279", "2019-1-23 9:40:49"),
        new QueryCondition("13566791077", "2019-1-24 19:55:22"),
        new QueryCondition("13528717776", "2019-1-27 13:52:26"),
        new QueryCondition("13603099251", "2019-1-21 20:45:56"),
        new QueryCondition("18966017005", "2019-1-22 20:40:36"),
        new QueryCondition("13566795297", "2019-1-25 21:01:41"),
        new QueryCondition("18123738851", "2019-1-27 18:28:11"),
        new QueryCondition("15924241343", "2019-1-25 21:26:13"),
        new QueryCondition("15019460623", "2019-1-26 19:55:02"),
        new QueryCondition("13925210478", "2019-1-19 20:00:51"),
        new QueryCondition("13423961883", "2019-1-24 21:21:19"),
        new QueryCondition("18267949764", "2019-1-27 16:07:20"),
        new QueryCondition("13632784180", "2019-1-26 21:14:35"),
        new QueryCondition("13058186844", "2019-1-24 10:50:45"),
        new QueryCondition("15988506067", "2019-1-25 18:33:11"),
        new QueryCondition("18875907492", "2019-1-24 21:35:19"),
        new QueryCondition("18138436173", "2019-1-24 21:09:03"),
        new QueryCondition("13760166560", "2019-1-21 11:34:06"),
        new QueryCondition("13566795297", "2019-1-25 21:01:41"),
        new QueryCondition("13588688440", "2019-1-21 20:59:37"),
        new QueryCondition("15099932331", "2019-1-1 21:46:33"),
        new QueryCondition("13670087848", "2019-1-21 20:17:46"),
        new QueryCondition("18319045257", "2019-1-19 20:23:01"),
        new QueryCondition("13590339201", "2019-1-26 19:53:45"),
        new QueryCondition("18666224720", "2019-1-23 13:21:29"),
        new QueryCondition("15988514214", "2019-1-26 19:37:58"),
        new QueryCondition("15268692095", "2019-1-17 21:28:47"),
        new QueryCondition("13544040833", "2019-1-26 15:05:45"),
        new QueryCondition("18321947205", "2019-1-27 19:43:59"),
        new QueryCondition("13538235792", "2019-1-24 10:50:44"),
        new QueryCondition("13798215344", "2019-1-9 22:58:32"),
        new QueryCondition("17606790320", "2019-1-23 20:15:27"),
        new QueryCondition("13417117113", "2019-1-25 22:43:23"),
        new QueryCondition("17857098706", "2019-1-24 16:34:30")
    };*/
 /*   QueryCondition[] queryConditions = new QueryCondition[]{
        new QueryCondition("15220221906", "2019-1-18 14:52:58"),
        new QueryCondition("15267992041", "2019-1-15 21:49:11"),
        new QueryCondition("18316997158", "2019-1-26 23:06:31"),
        new QueryCondition("18798785875", "2019-1-27 21:04:35"),
        new QueryCondition("13692221338", "2019-1-26 21:05:53")
    };*/
    /* QueryCondition[] queryConditions = new QueryCondition[]{
        new QueryCondition("13714769611", "2019-1-27 23:41:35"),
        new QueryCondition("15207915557", "2019-1-27 22:20:00"),
        new QueryCondition("13760182027", "2019-1-27 15:55:12"),
        new QueryCondition("15361050582", "2019-1-28 4:28:38"),
        new QueryCondition("13590161019", "2019-1-26 22:37:36"),
        new QueryCondition("15118846499", "2019-1-27 11:30:16"),
        new QueryCondition("17606790320", "2019-1-26 20:19:17"),
        new QueryCondition("13631624278", "2019-1-26 22:35:01"),
        new QueryCondition("13926559211", "2019-1-26 10:49:12"),
        new QueryCondition("13590161019", "2019-1-26 22:37:36"),
        new QueryCondition("18319045257", "2019-1-25 20:45:21"),
        new QueryCondition("18267949764", "2019-1-25 20:51:42"),
        new QueryCondition("13566791077", "2019-1-25 18:53:12"),
        new QueryCondition("13623009798", "2019-1-28 14:46:42"),
        new QueryCondition("15013435510", "2019-1-25 16:02:51"),
        new QueryCondition("18670088252", "2019-1-26 20:46:47"),
        new QueryCondition("13750932219", "2019-1-25 13:18:10"),
        new QueryCondition("15767005616", "2019-1-25 11:24:21"),
        new QueryCondition("18875907492", "2019-1-27 0:00:47"),
        new QueryCondition("18316997158", "2019-1-27 21:31:24"),
        new QueryCondition("18666224720", "2019-1-22 15:55:23"),
        new QueryCondition("15268692095", "2019-1-23 19:17:05")
    };*/
  /*   //2019年2月15日16:06:19 无效报告
     QueryCondition[] queryConditions = new QueryCondition[]{
        new QueryCondition("13427979367", "2019-2-15 11:29:30"),
        new QueryCondition("15012791235", "2019-2-15 10:51:49"),
        new QueryCondition("13823194564", "2019-2-15 10:43:52"),
        new QueryCondition("13925731639", "2019-2-15 7:42:44"),
        new QueryCondition("18682275119", "2019-2-15 4:25:47"),
        new QueryCondition("15118090320", "2019-2-14 22:55:57"),
        new QueryCondition("15012791235", "2019-2-15 10:51:48"),
        new QueryCondition("13923768513", "2019-2-11 20:49:14")
    };*/
        //2019年2月15日16:06:19 加速
    /*QueryCondition[] queryConditions = new QueryCondition[]{
        new QueryCondition("13246695400", "2019-2-15 11:23:29"),
        new QueryCondition("18566779633", "2019-2-15 11:02:16"),
        new QueryCondition("13925731639", "2019-2-15 7:44:47"),
        new QueryCondition("18118787425", "2019-2-15 2:01:46"),
        new QueryCondition("15812497076", "2019-2-15 0:12:16"),
        new QueryCondition("15914006549", "2019-2-15 0:11:09"),
        new QueryCondition("13798271995", "2019-2-14 23:33:36"),
        new QueryCondition("13689539223", "2019-2-14 23:26:18"),
        new QueryCondition("13427979367", "2019-2-14 23:07:40"),
        new QueryCondition("15999638942", "2019-2-14 22:57:03"),
        new QueryCondition("18576728022", "2019-2-14 22:46:57"),
        new QueryCondition("13427979367", "2019-2-14 16:28:38"),
        new QueryCondition("18868475819", "2019-2-15 11:42:32"),
        new QueryCondition("13760166560", "2019-2-13 14:42:38"),
        new QueryCondition("13728631007", "2019-2-15 11:39:50"),
        new QueryCondition("15012791235", "2019-2-12 20:39:49"),
        new QueryCondition("13923768513", "2019-2-11 11:44:05"),
        new QueryCondition("13923768513", "2019-2-7 21:52:32"),
        new QueryCondition("13823194564", "2019-2-13 19:42:10"),
        new QueryCondition("13823194564", "2019-2-8 11:13:52")
    };*/
        //2019年2月15日16:06:19 减速
   /* QueryCondition[] queryConditions = new QueryCondition[]{
        new QueryCondition("13760166560", "2019-2-6 12:03:32"),
        new QueryCondition("15200867022", "2019-2-1 13:02:06"),
        new QueryCondition("18675647524", "2019-2-1 14:54:02"),
        new QueryCondition("18798785875", "2019-2-1 16:14:18"),
        new QueryCondition("13360050214", " 2019-2-2 11:04:00"),
        new QueryCondition("13417117113", "2019-2-2 13:23:08"),
        new QueryCondition("13613051897", "2019-2-2 21:21:39"),
        new QueryCondition("13622377652", "2019-2-2 10:29:12"),
        new QueryCondition("15999657352", "2019-2-3 20:21:12")
    };*/
        //2019年2月15日16:06:19 不满意
   /* QueryCondition[] queryConditions = new QueryCondition[]{
        new QueryCondition("15812497076", "2019-2-14 23:12:09"),
        new QueryCondition("18868475819", "2019-2-14 12:30:32"),
        new QueryCondition("13760166560", "2019-2-15 11:45:23"),
        new QueryCondition("13728631007", "2019-2-6 23:08:08"),
        new QueryCondition("13728631007", "2019-2-5 9:32:50"),
        new QueryCondition("15012791235", "2019-2-12 19:31:14"),
        new QueryCondition("15012791235", "2019-2-9 13:28:53"),
        new QueryCondition("13823194564", "2019-2-4 19:32:11"),
        new QueryCondition("15002072349", "2019-2-2 19:37:06")
    };*/
   /*
   2019年2月19日17:5:14  无效报告
    */
      /*  QueryCondition[] queryConditions = new QueryCondition[]{
                new QueryCondition("13434764043", "2019-2-19 14:57:08"),
                new QueryCondition("13992859113", "2019-2-19 12:25:07"),
                new QueryCondition("18318065686", "2019-2-19 12:25:07"),
                new QueryCondition("13632926050", "2019-2-19 12:23:44"),
                new QueryCondition("18676942960", "2019-2-19 11:50:24"),
                new QueryCondition("17791459680", "2019-2-19 11:13:12"),
                new QueryCondition("13480123123", "2019-2-19 11:04:02"),
                new QueryCondition("15867891919", "2019-2-19 10:26:06"),
                new QueryCondition("18520896931", "2019-2-19 9:27:35"),
                new QueryCondition("13923768513", "2019-2-19 11:14:14"),
                new QueryCondition("13420952615", "2019-2-19 9:09:09"),
                new QueryCondition("15013728271", "2019-2-18 22:52:28"),
                new QueryCondition("15091831665", "2019-2-18 22:37:09"),
                new QueryCondition("18665886829", "2019-2-18 22:23:01"),
                new QueryCondition("15858996543", "2019-2-18 22:15:59"),
                new QueryCondition("18680664005", "2019-2-18 20:59:06"),
                new QueryCondition("13922888364", "2019-2-18 20:37:01")
        };*/
//*/
  /*
 2019年2月19日17:5:14  加速
    */
//       QueryCondition[] queryConditions = new QueryCondition[]{
//                new QueryCondition("13798431331", "2019-2-19 13:37:05"),
//                new QueryCondition("18681436906", "2019-2-19 8:25:23"),
//                new QueryCondition("18688984625", "2019-2-18 23:35:36"),
//                new QueryCondition("13662220193", "2019-2-18 23:21:01"),
//                new QueryCondition("15889786798", "2019-2-18 22:44:26"),
//                new QueryCondition("18666829309", "2019-2-18 22:44:00"),
//                new QueryCondition("13798398341", "2019-2-18 22:27:25"),
//                new QueryCondition("15857975846", "2019-2-18 22:31:01"),
//                new QueryCondition("13632506478", "2019-2-18 22:19:24"),
//                new QueryCondition("18681521086", "2019-2-18 22:16:55"),
//                new QueryCondition("13510952371", "2019-2-18 22:07:28"),
//                new QueryCondition("15757918027", "2019-2-18 22:13:20"),
//                new QueryCondition("15889356206", "2019-2-18 22:07:08"),
//                new QueryCondition("13425180210", "2019-2-18 22:04:51"),
//                new QueryCondition("15889468701", "2019-2-18 22:00:23"),
//                new QueryCondition("13417117113", "2019-2-18 21:41:57"),
//                new QueryCondition("18938852590", "2019-2-18 21:14:30"),
//                new QueryCondition("13802269038", "2019-2-18 21:03:53"),
//                new QueryCondition("15099924548", "2019-2-18 21:04:04"),
//                new QueryCondition("13632926050", "2019-2-18 21:07:51"),
//                new QueryCondition("18258101250", "2019-2-18 21:01:20")
//        };
        /*        *//**
         * 时间 2019年2月19日17:17:07 减速
         *//*
      QueryCondition[] queryConditions = new QueryCondition[]{
                new QueryCondition("13922888364", "2019-2-19 15:04:47"),
                new QueryCondition("13603062024", "2019-2-18 21:19:53"),
                new QueryCondition("18118787425", "2019-2-19 0:46:53"),
                new QueryCondition("15914003359", "2019-2-18 22:47:10"),
                new QueryCondition("13826551993", "2019-2-18 19:54:30")
        };*/
      /*  //不满意
        QueryCondition[] queryConditions = new QueryCondition[]{
                new QueryCondition("13777517351", "2019-2-18 22:29:04"),
                new QueryCondition("18192099302", "2019-2-18 21:43:51"),
                new QueryCondition("18291874438", "2019-2-18 20:55:41")

        };*/
        //加速
     /*   QueryCondition[] queryConditions = new QueryCondition[]{
                new QueryCondition("15389003535", "2019-2-16 10:20:19")
        };*/
    /*    QueryCondition[] queryConditions = new QueryCondition[]{
                new QueryCondition("13992309898", "2019-2-17 21:55:39"),
                new QueryCondition("13002958248", "2019-2-17 15:35:43"),
                new QueryCondition("13772076961", "2019-2-16 21:48:44")
        };*/

        //2019年2月21日09:55:48 //加速
      /*  QueryCondition[] queryConditions = new QueryCondition[]{
                new QueryCondition("15686117059", "2019-2-19 21:39:59"),
                new QueryCondition("17792828327", "2019-2-19 21:30:08"),
                new QueryCondition("18792430866", "2019-2-19 20:45:42"),
                new QueryCondition("15829622583", "2019-2-19 20:40:25"),
                new QueryCondition("15094052022", "2019-2-19 19:41:04"),
                new QueryCondition("13659219687", "2019-2-19 17:54:07"),
                new QueryCondition("15991744960", "2019-2-19 16:29:13"),
                new QueryCondition("13572321472", "2019-2-19 16:20:13"),
                new QueryCondition("15229369828", "2019-2-19 15:26:36"),
                new QueryCondition("13709289483", "2019-2-19 13:35:34"),
                new QueryCondition("17749021868", "2019-2-19 12:28:11"),
                new QueryCondition("15229888450", "2019-2-19 9:06:58"),
                new QueryCondition("15229079739", "2019-2-18 21:45:40"),
                new QueryCondition("15686000037", "2019-2-18 21:44:09"),
                new QueryCondition("13186015280", "2019-2-18 21:37:32"),
                new QueryCondition("18966920703", "2019-2-18 21:35:44"),
                new QueryCondition("15619059589", "2019-2-18 21:26:59"),
                new QueryCondition("18966920703", "2019-2-15 19:08:23"),
                new QueryCondition("15094052022", "2019-2-12 20:02:31"),
                new QueryCondition("15686000037", "2019-2-11 21:43:09"),
                new QueryCondition("13991187062", "2019-2-11 21:47:53"),
                new QueryCondition("15114823923", "2019-2-10 19:49:17")
        };*/
        //减速
     /* QueryCondition[] queryConditions = new QueryCondition[]{
                new QueryCondition("13909141720", "2019-2-19 20:16:07"),
                new QueryCondition("17792828327", "2019-2-15 19:14:54"),
                new QueryCondition("13892866586", "2019-2-9 21:54:06"),
                new QueryCondition("13992309898", "2019-2-9 10:25:39"),
                new QueryCondition("15619390189", "2019-2-7 22:00:11"),
                new QueryCondition("13992309898", "2019-2-7 21:42:56"),
                new QueryCondition("13991313120", "2019-2-7 19:33:11"),
                new QueryCondition("18092663964", "2019-2-6 21:01:05")
        };*/

        //不满意
     /*   QueryCondition[] queryConditions = new QueryCondition[]{
                new QueryCondition("13909141720", "2019-2-19 20:16:07"),
                new QueryCondition("18092105766", "2019-2-19 10:04:14"),
                new QueryCondition("13909141720", "2019-2-14 20:36:05")
        };*/

        /*QueryCondition[] queryConditions = new QueryCondition[]{
         *//*  new QueryCondition("汪学强", "15691669218", "2019-02-01 09:43:05"),
                new QueryCondition("何丽", "18992434666", "2019-02-01 09:41:32"),
                new QueryCondition("杜婀妮", "18992434666", "2019-02-01 09:37:55"),
                new QueryCondition("任侠", "13572321472", "2019-02-01 09:37:10"),*//*
                new QueryCondition("张骊", null, "2019-02-01 09:21:54"),
               new QueryCondition("童娉娉", null, "2019-02-01 09:13:42"),
                new QueryCondition("葛芹芹", null, "2019-02-01 09:02:57"),
                new QueryCondition("缪奶珠", null, "2019-02-01 08:59:48"),
                new QueryCondition("李静", null, "2019-02-01 08:49:10"),
                new QueryCondition("王小红", null, "2019-02-01 10:48:30"),
                new QueryCondition("肖鹤玲", null, "2019-02-01 10:40:00"),
                new QueryCondition("杨盼", null, "2019-02-01 10:21:07"),
                new QueryCondition("樊慧莲", null, "2019-02-01 10:14:22"),
                new QueryCondition("邓建丽", null, "2019-02-01 10:04:58"),
                new QueryCondition("田绒绒", null, "2019-02-01 10:03:03"),
                new QueryCondition("江韬双胎二", null, "2019-02-01 10:01:46"),
                new QueryCondition("刘雨霏", null, "2019-02-01 09:44:33"),
                new QueryCondition("李婷", null, "2019-02-01 14:55:28"),
                new QueryCondition("雒红", null, "2019-02-01 14:39:58"),
                new QueryCondition("李凡", null, "2019-02-01 14:38:42"),
                new QueryCondition("王婷婷", null, "2019-02-01 14:30:57"),
                new QueryCondition("王亚婷", null, "2019-02-01 14:29:17"),
                new QueryCondition("王亦忻", null, "2019-02-01 13:35:10"),
                new QueryCondition("马蕾", null, "2019-02-01 11:45:52"),
                new QueryCondition("李瑶瑶", null, "2019-02-01 11:44:06"),
                new QueryCondition("刘瑜", null, "2019-02-01 11:15:19"),
                new QueryCondition("李颜颜", null, "2019-02-01 17:27:58"),
                new QueryCondition("卞红丽", null, "2019-02-01 16:58:41"),
                new QueryCondition("柴宁宁", null, "2019-02-01 15:44:57"),
                new QueryCondition("杜青花", null, "2019-02-01 15:27:05"),
                new QueryCondition("郭会文", null, "2019-02-01 15:24:53"),
                new QueryCondition("王夏宁", null, "2019-02-01 15:13:15"),
                new QueryCondition("张丹", null, "2019-02-01 15:12:16"),
                new QueryCondition("师姣洁", null, "2019-02-01 15:08:38"),
                new QueryCondition("张欢", null, "2019-02-01 15:05:55"),
                new QueryCondition("汪玉", null, "2019-02-01 15:04:14"),
                new QueryCondition("肖鹤玲", null, "2019-02-02 12:30:08"),
                new QueryCondition("师姣洁", null, "2019-02-02 09:40:57"),
                new QueryCondition("喻佳", null, "2019-02-01 22:04:52"),
                new QueryCondition("熊伟玲", null, "2019-02-01 21:23:15"),
                new QueryCondition("张艺连", null, "2019-02-01 21:19:16"),
                new QueryCondition("杜文娟", null, "2019-02-01 21:18:34"),
                new QueryCondition("师姣洁", null, "2019-02-01 21:10:21"),
                new QueryCondition("曹京京", null, "2019-02-01 20:24:27"),
                new QueryCondition("李玥佳", null, "2019-02-01 19:29:50"),
                new QueryCondition("郭方方", null, "2019-02-02 18:53:08"),
                new QueryCondition("魏淑波", null, "2019-02-02 17:07:25"),
                new QueryCondition("胡丽萍", null, "2019-02-02 16:27:04"),
                new QueryCondition("谢娜", null, "2019-02-02 16:25:55"),
                new QueryCondition("李颜颜", null, "2019-02-02 13:47:56"),
                new QueryCondition("杨梅", null, "2019-02-02 12:31:25"),
                new QueryCondition("卫倩", null, "2019-02-05 16:42:41"),
                new QueryCondition("张艺连", null, "2019-02-05 13:51:06"),
                new QueryCondition("王玉娇", null, "2019-02-05 11:49:58"),
                new QueryCondition("赵千", null, "2019-02-05 10:51:04"),
                new QueryCondition("任侠", null, "2019-02-05 10:20:43"),
                new QueryCondition("师姣洁", null, "2019-02-05 10:19:26"),
                new QueryCondition("刘芬", null, "2019-02-05 10:05:43"),
                new QueryCondition("谢娜", null, "2019-02-04 21:56:19"),
                new QueryCondition("高雪侠", null, "2019-02-05 20:56:57"),
                new QueryCondition("熊伟玲", null, "2019-02-05 20:11:14"),
                new QueryCondition("仉天聪", null, "2019-02-05 20:10:27"),
                new QueryCondition("刘芬", null, "2019-02-05 19:48:35"),
                new QueryCondition("杨红利", null, "2019-02-05 19:29:19"),
                new QueryCondition("穆甜甜", null, "2019-02-05 17:30:15"),
                new QueryCondition("张艺连", null, "2019-02-08 21:15:28"),
                new QueryCondition("王小红", null, "2019-02-08 20:00:48"),
                new QueryCondition("李敏", null, "2019-02-08 17:53:59"),
                new QueryCondition("卞红丽", null, "2019-02-08 17:34:09"),
                new QueryCondition("赵欢", null, "2019-02-08 17:19:16"),
                new QueryCondition("赵欢", null, "2019-02-08 17:19:16"),
                new QueryCondition("任侠", null, "2019-02-08 16:37:38"),
                new QueryCondition("穆甜甜", null, "2019-02-08 16:32:18"),
                new QueryCondition("李文娟", null, "2019-02-08 16:30:24"),
                *//*new QueryCondition("酷儿阮阮", "13892809137", "2016-05-31 16:52:45"),
                new QueryCondition("王莹莹", "13992098194", "2016-05-31 14:05:55"),
                new QueryCondition("李薇", "13636806625", "2016-05-30 14:31:17"),
                new QueryCondition("张文", "15229229962", "2018-01-17 20:39:48"),
                new QueryCondition("周静", "18710802770", "2018-01-17 19:52:07"),
                new QueryCondition("刘颖", "18092029990", "2018-01-17 15:42:24"),
                new QueryCondition("罗媛媛", "13891886292", "2018-01-16 21:12:27"),
                new QueryCondition("马晚霞", "13919968515", "2018-01-16 20:54:32")*//*
        };*/
        /*QueryCondition[] queryConditions = new QueryCondition[]{
                new QueryCondition("师姣洁", null, "2019-02-01 10:31:42"),
                new QueryCondition("魏淑波", null, "2019-02-02 12:29:39"),
                new QueryCondition("颜蕾", null, "2019-02-02 16:25:35"),
                new QueryCondition("刘俊", null, "2019-02-02 14:32:11"),
                new QueryCondition("郭晓轩", null, "2019-02-02 12:39:29"),
                new QueryCondition("梁婷婷", null, "2019-02-05 13:46:34")
        };*/
        QueryCondition[] queryConditions = new QueryCondition[]{
              /*  new QueryCondition("252227"),
                new QueryCondition("366444"),
                new QueryCondition("275658"),
                new QueryCondition("376060"),
                new QueryCondition("361372"),
                new QueryCondition("269600"),
                new QueryCondition("335527"),
                new QueryCondition("240661"),
                new QueryCondition("384301"),
                new QueryCondition("349211"),
                new QueryCondition("474769"),
                new QueryCondition("245091"),
                new QueryCondition("331206"),
                new QueryCondition("215235"),
                new QueryCondition("319792"),
                new QueryCondition("465875"),
                new QueryCondition("359220"),
                new QueryCondition("368043"),
                new QueryCondition("342727"),
                new QueryCondition("322635"),
                new QueryCondition("424234"),
                new QueryCondition("324093"),
                new QueryCondition("386223"),
                new QueryCondition("305213"),
                new QueryCondition("324644"),
                new QueryCondition("436349"),
                new QueryCondition("417515"),
                new QueryCondition("352729"),
                new QueryCondition("216712"),
                new QueryCondition("295817"),
                new QueryCondition("209094"),
                new QueryCondition("278051"),
                new QueryCondition("278667"),
                new QueryCondition("356934"),
                new QueryCondition("357372"),
                new QueryCondition("226444"),
                new QueryCondition("228062"),
                new QueryCondition("228748"),
                new QueryCondition("299073"),
                new QueryCondition("302657"),
                new QueryCondition("369175"),
                new QueryCondition("436303"),
                new QueryCondition("320638"),
                new QueryCondition("387775"),
                new QueryCondition("332366"),
                new QueryCondition("332978"),
                new QueryCondition("471375"),
                new QueryCondition("264724"),
                new QueryCondition("337329"),
                new QueryCondition("413522"),
                new QueryCondition("420030"),
                new QueryCondition("333298"),
                new QueryCondition("243535"),
                new QueryCondition("397215"),
                new QueryCondition("314167"),
                new QueryCondition("415416"),
                new QueryCondition("337412"),
                new QueryCondition("273514"),
                new QueryCondition("370245"),
                new QueryCondition("470491"),
                new QueryCondition("382627"),
                new QueryCondition("220221"),
                new QueryCondition("364971"),
                new QueryCondition("332322"),
                new QueryCondition("370336"),
                new QueryCondition("360438"),
                new QueryCondition("343220"),
                new QueryCondition("294586"),
                new QueryCondition("409356"),
                new QueryCondition("245158"),
                new QueryCondition("423800"),
                new QueryCondition("296478"),
                new QueryCondition("297992"),
                new QueryCondition("350184"),
                new QueryCondition("442333"),
                new QueryCondition("277660"),
                new QueryCondition("341439"),
                new QueryCondition("301110"),
                new QueryCondition("360157"),
                new QueryCondition("299412"),
                new QueryCondition("304871"),
                new QueryCondition("422590"),
                new QueryCondition("301116"),
                new QueryCondition("426544"),
                new QueryCondition("439680"),
                new QueryCondition("265013"),
                new QueryCondition("208540"),
                new QueryCondition("389847"),
                new QueryCondition("467148"),
                new QueryCondition("398730"),
                new QueryCondition("342084"),
                new QueryCondition("348482"),
                new QueryCondition("332276"),
                new QueryCondition("306708"),
                new QueryCondition("346888"),
                new QueryCondition("290420"),
                new QueryCondition("417915"),
                new QueryCondition("393159"),
                new QueryCondition("215953"),
                new QueryCondition("331152")*/

               /* 295817 294586 296478 389847 290420*/
                new QueryCondition("295817"),
                new QueryCondition("294586"),
                new QueryCondition("296478"),
                new QueryCondition("389847"),
                new QueryCondition("290420"),
           /*     new QueryCondition("393159"),
                new QueryCondition("215953"),*/


                /* new QueryCondition(	"付玲"	,"13676847802",	"2018-11-06 22:12:05"	),
                 new QueryCondition(	"胡玉琼"	,"18072317737",	"2019-01-01 22:25:46"	),
                 new QueryCondition(	"谢桂平"	,"13530066047",	"2018-12-27 11:32:14"	),
                 new QueryCondition(	"刘嘉慧"	,"13751071884",	"2018-12-31 22:44:45"	),
                 new QueryCondition(	"王云云"	,"18930059857",	"2018-12-28 11:18:20"	),
                 new QueryCondition(	"孙金梅"	,"18926097392",	"2018-12-28 11:18:20"	),
                 new QueryCondition(	"陈红霞"	,"15012758812",	"2019-01-20 14:42:52"	),
                 new QueryCondition(	"张莎莎"	,"13006655777",	"2018-12-30 23:01:59"	),
                 new QueryCondition(	"丁雪晴"	,"15057969928",	"2019-01-02 23:01:40"	),
                 new QueryCondition(	"毛芳"	,"13549443175",	"2019-01-04 20:16:28"	),
                 new QueryCondition(	"陆梦晓"	,"13045885005",	"2018-12-31 23:18:09"	),
                 new QueryCondition(	"李梅芳"	,"13714396346",	"2018-12-31 22:38:45"	),
                 new QueryCondition(	"陈虹宇"	,"17722403965",	"2018-12-31 22:34:11"	),
                 new QueryCondition(	"韩丽冰"	,"15099932331",	"2018-12-31 22:32:19"	),
                 new QueryCondition(	"张梦玲"	,"18565785531",	"2018-12-31 22:29:38"	),
                 new QueryCondition(	"王海燕"	,"18680529290",	"2018-12-31 22:19:47"	),
                 new QueryCondition(	"欧海燕"	,"13510862112",	"2018-12-31 22:04:56"	),
                 new QueryCondition(	"梁倩"	,"13823211949",	"2018-12-31 22:02:09"	),
                 new QueryCondition(	"何婷"	,"15818595805",	"2018-12-31 21:58:56"	),
                 new QueryCondition(	"陈苏琴"	,"13590169689",	"2018-12-31 21:54:40"	),
                 new QueryCondition(	"刘小玲"	,"18507626225",	"2018-12-31 21:52:30"	),
                 new QueryCondition(	"陆定"	,"18038074078",	"2018-12-31 21:43:44"	),
                 new QueryCondition(	"周南希"	,"18938903468",	"2018-12-31 21:42:59"	),
                 new QueryCondition(	"林娇娇"	,"18867755533",	"2018-12-31 21:32:37"	),
                 new QueryCondition(	"黄瑞冰"	,"13794462455",	"2018-12-31 21:19:36"	),
                 new QueryCondition(	"叶梅连"	,"13530337693",	"2018-12-31 21:10:52"	),
                 new QueryCondition(	"陈娜"	,"15989852398",	"2018-12-31 21:10:01"	),
                 new QueryCondition(	"吴丹"	,"13716138215",	"2018-12-31 21:05:24"	),
                 new QueryCondition(	"方秀嫩"	,"13510012686",	"2018-12-31 21:04:48"	),
                 new QueryCondition(	"唐敏"	,"15915726573",	"2018-12-31 20:28:55"	),
                 new QueryCondition(	"倪惜华"	,"13682604483",	"2018-12-31 20:04:43"	),
                 new QueryCondition(	"王绮婷"	,"13714420389",	"2018-12-31 20:04:04"	),
                 new QueryCondition(	"黄巧凤"	,"15818546149",	"2018-12-31 19:52:51"	),
                 new QueryCondition(	"董月菊"	,"13480101118",	"2018-12-31 19:29:07"	),
                 new QueryCondition(	"利彩萍"	,"13510900612",	"2018-12-31 17:51:56"	),
                 new QueryCondition(	"黄惠云"	,"13620991823",	"2018-12-31 16:09:31"	),
                 new QueryCondition(	"肖秀全"	,"13430703213",	"2018-12-31 15:38:03"	),
                 new QueryCondition(	"李杰"	,"13632510653",	"2018-12-31 14:13:19"	),
                 new QueryCondition(	"张丽娟"	,"17688953808",	"2018-12-31 13:42:51"	),
                 new QueryCondition(	"倪惜华"	,"13682604483",	"2018-12-31 13:39:26"	),
                 new QueryCondition(	"倪惜华"	,"13682604483",	"2018-12-31 13:39:26"	),
                 new QueryCondition(	"胡婧"	,"15058554563",	"2018-12-31 12:48:34"	),
                 new QueryCondition(	"邵冉"	,"15915426110",	"2018-12-31 10:55:34"	),
                 new QueryCondition(	"邓巧玲"	,"15089459407",	"2018-12-31 10:44:08"	),
                 new QueryCondition(	"张丽娟"	,"17688953808",	"2018-12-31 10:30:17"	),
                 new QueryCondition(	"陶璐瑶"	,"18266911108",	"2018-12-30 22:33:06"	),
                 new QueryCondition(	"刘小玲"	,"18507626225",	"2018-12-30 20:57:08"	),
                 new QueryCondition(	"李慧萍"	,"13454988628",	"2019-02-01 22:30:09"	),
                 new QueryCondition(	"曾燕婷"	,"15089453464",	"2018-12-31 23:45:23"	),
                 new QueryCondition(	"刘健英"	,"13242780338",	"2018-12-30 22:34:58"	),
                 new QueryCondition(	"程成"	,"18058961126",	"2018-12-30 20:56:55"	),
                 new QueryCondition(	"覃子芮"	,"13603099251",	"2019-02-28 23:42:18"	),
                 new QueryCondition(	"张瑞旭"	,"18089265497",	"2019-02-28 23:38:06"	),
                 new QueryCondition(	"石方园"	,"18566688963",	"2019-02-28 23:35:44"	),
                 new QueryCondition(	"叶瑞芬"	,"13723466933",	"2019-02-28 23:20:17"	),
                 new QueryCondition(	"廖敏如"	,"13728631007",	"2019-02-28 23:16:57"	),
                 new QueryCondition(	"覃子芮"	,"13603099251",	"2019-02-28 23:16:35"	),
                 new QueryCondition(	"叶小眉"	,"13510600195",	"2019-02-28 23:10:36"	),
                 new QueryCondition(	"周云"	,"18858959226",	"2019-02-28 23:03:39"	),
                 new QueryCondition(	"李妍"	,"15857975846",	"2019-02-28 22:58:53"	),
                 new QueryCondition(	"夏苗"	,"13500064404",	"2019-02-28 22:54:27"	),
                 new QueryCondition(	"梁晞莹"	,"18820997602",	"2019-02-28 22:54:14"	),
                 new QueryCondition(	"张瑞旭"	,"18089265497",	"2019-02-28 22:52:28"	),
                 new QueryCondition(	"李小墨"	,"18938852590",	"2019-02-28 22:51:52"	),
                 new QueryCondition(	"俞燕娟"	,"13605826275",	"2019-02-28 22:45:07"	),
                 new QueryCondition(	"黄文琼"	,"13728678737",	"2019-02-28 22:44:49"	),
                 new QueryCondition(	"郑惠珍"	,"18948172329",	"2019-02-28 22:44:27"	),
                 new QueryCondition(	"张一楠"	,"15019410655",	"2019-02-28 22:44:10"	),
                 new QueryCondition(	"刘晓明"	,"13823101785",	"2019-02-28 22:43:53"	),
                 new QueryCondition(	"万香"	,"15014140511",	"2019-02-28 22:42:56"	)*/


        };
        /*QueryCondition[] queryConditions = new QueryCondition[]{
                new QueryCondition("李轶赟", null, "2019-01-31 22:14:55"),
                new QueryCondition("江韬双胎1", null, "2019-02-01 10:00:56"),
                new QueryCondition("时雨", null, "2019-02-01 15:00:59"),
                new QueryCondition("曹京京", null, "2019-02-05 15:16:27"),
                new QueryCondition("曹京京", null, "2019-02-05 19:36:14"),
                new QueryCondition("李文娟", null, "2019-02-08 16:30:24"),
                new QueryCondition("马龙玮", null, "2019-02-08 15:44:18"),
                new QueryCondition("王融", "15229010010","2018-01-16 21:29:07"),
                new QueryCondition("行冰玉", "17782475887","2018-01-16 21:14:55"),
        };*/


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
    /* QueryCondition[] queryConditions = new QueryCondition[]{
        new QueryCondition("13590339201", "2019-1-26 21:58:00"),
        new QueryCondition("18580198272", "2019-1-24 22:29:00"),
        new QueryCondition("13425158205", "2019-1-27 22:22:00"),
        new QueryCondition("18123738851", "2019-1-28 9:53:00"),
        new QueryCondition("13692295532", "2019-1-24 23:03:00"),
        new QueryCondition("15267992041", "2019-1-16 12:28:00"),
        new QueryCondition("15099922040", "2018-12-28 2:29:00"),
        new QueryCondition("13924626275", "2019-1-23 21:54:00"),
        new QueryCondition("18899853813", "2019-1-24 22:29:00"),
        new QueryCondition("13794462455", "2019-1-26 20:27:00"),
        new QueryCondition("18718572279", "2019-1-23 9:40:00"),
        new QueryCondition("13566791077", "2019-1-24 19:55:00"),
        new QueryCondition("13528717776", "2019-1-27 13:52:00"),
        new QueryCondition("13603099251", "2019-1-21 20:45:00"),
        new QueryCondition("18966017005", "2019-1-22 20:40:00"),
        new QueryCondition("13566795297", "2019-1-25 21:01:00"),
        new QueryCondition("18123738851", "2019-1-27 18:28:00"),
        new QueryCondition("15924241343", "2019-1-25 21:26:00"),
        new QueryCondition("15019460623", "2019-1-26 19:55:00"),
        new QueryCondition("13925210478", "2019-1-19 20:00:00"),
        new QueryCondition("13423961883", "2019-1-24 21:21:00"),
        new QueryCondition("18267949764", "2019-1-27 16:07:00"),
        new QueryCondition("13632784180", "2019-1-26 21:14:00"),
        new QueryCondition("13058186844", "2019-1-24 10:50:00"),
        new QueryCondition("15988506067", "2019-1-25 18:33:00"),
        new QueryCondition("18875907492", "2019-1-24 21:35:00"),
        new QueryCondition("18138436173", "2019-1-24 21:09:00"),
        new QueryCondition("13760166560", "2019-1-21 11:34:00"),
        new QueryCondition("13566795297", "2019-1-25 21:01:00"),
        new QueryCondition("13588688440", "2019-1-21 20:59:00"),
        new QueryCondition("15099932331", "2019-1-1 21:46:00"),
        new QueryCondition("13670087848", "2019-1-21 20:17:00"),
        new QueryCondition("18319045257", "2019-1-19 20:23:00"),
        new QueryCondition("13590339201", "2019-1-26 19:53:00"),
        new QueryCondition("18666224720", "2019-1-23 13:21:00"),
        new QueryCondition("15988514214", "2019-1-26 19:37:00"),
        new QueryCondition("15268692095", "2019-1-17 21:28:00"),
        new QueryCondition("13544040833", "2019-1-26 15:05:00"),
        new QueryCondition("18321947205", "2019-1-27 19:43:00"),
        new QueryCondition("13538235792", "2019-1-24 10:50:00"),
        new QueryCondition("13798215344", "2019-1-9 22:58:00"),
        new QueryCondition("17606790320", "2019-1-23 20:15:00"),
        new QueryCondition("13417117113", "2019-1-25 22:43:00"),
        new QueryCondition("17857098706", "2019-1-24 16:34:00")
    };*/


 /*   QueryCondition[] queryConditions = new QueryCondition[]{
        new QueryCondition("15220221906", "2019-1-18 14:52:00"),
        new QueryCondition("15267992041", "2019-1-15 21:49:00"),
        new QueryCondition("18316997158", "2019-1-26 23:06:00"),
        new QueryCondition("18798785875", "2019-1-27 21:04:00"),
        new QueryCondition("13692221338", "2019-1-26 21:05:00")
    };*/
    /* QueryCondition[] queryConditions = new QueryCondition[]{
        new QueryCondition("13714769611", "2019-1-27 23:41:00"),
        new QueryCondition("15207915557", "2019-1-27 22:20:00"),
        new QueryCondition("13760182027", "2019-1-27 15:55:00"),
        new QueryCondition("15361050582", "2019-1-28 4:28:00"),
        new QueryCondition("13590161019", "2019-1-26 22:37:00"),
        new QueryCondition("15118846499", "2019-1-27 11:30:00"),
        new QueryCondition("17606790320", "2019-1-26 20:19:00"),
        new QueryCondition("13631624278", "2019-1-26 22:35:00"),
        new QueryCondition("13926559211", "2019-1-26 10:49:00"),
        new QueryCondition("13590161019", "2019-1-26 22:37:00"),
        new QueryCondition("18319045257", "2019-1-25 20:45:00"),
        new QueryCondition("18267949764", "2019-1-25 20:51:00"),
        new QueryCondition("13566791077", "2019-1-25 18:53:00"),
        new QueryCondition("13623009798", "2019-1-28 14:46:00"),
        new QueryCondition("15013435510", "2019-1-25 16:02:00"),
        new QueryCondition("18670088252", "2019-1-26 20:46:00"),
        new QueryCondition("13750932219", "2019-1-25 13:18:00"),
        new QueryCondition("15767005616", "2019-1-25 11:24:00"),
        new QueryCondition("18875907492", "2019-1-27 0:00:00"),
        new QueryCondition("18316997158", "2019-1-27 21:31:00"),
        new QueryCondition("18666224720", "2019-1-22 15:55:00"),
        new QueryCondition("15268692095", "2019-1-23 19:17:00")
    };*/
        return null;
    }

}
