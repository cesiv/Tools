package com.jumper.pdf.utils;

/*
 * This example was written in answer to the question:
 * http://stackoverflow.com/questions/33952183
 */

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Bruno Lowagie (iText Software)
 */
public class OriginalAddContent {

    public static final String SRC = "F:\\pained";
    public static final String DEST = "F:\\pained";

    /*public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(SRC);
        *//*  System.out.println(file.getAbsolutePath());
        file.getParentFile().mkdirs();
        new OriginalAddContent().manipulatePdf(SRC, DEST);*//*

        String[] filelist = file.list();
        for (int i = 0; i < filelist.length; i++) {
            File readfile = new File(SRC + "\\" + filelist[i]);
            if (!readfile.isDirectory()) {
                System.out.println("path=" + readfile.getPath());
                System.out.println("absolutepath="
                        + readfile.getAbsolutePath());
                System.out.println("name=" + readfile.getName());
                manipulatePdf(readfile.getAbsolutePath(), DEST + readfile.getName());
            }

        }
    }*/

    public static void doWork(String dir) throws IOException, DocumentException {
        File file = new File(dir);
        /*  System.out.println(file.getAbsolutePath());
        file.getParentFile().mkdirs();
        new OriginalAddContent().manipulatePdf(SRC, DEST);*/

        System.out.println("文件夹");
        String[] filelist = file.list();
        for (int i = 0; i < filelist.length; i++) {
            File readfile = new File(dir + "\\" + filelist[i]);
            if (!readfile.isDirectory()) {
                System.out.println("path=" + readfile.getPath());
                System.out.println("absolutepath="
                        + readfile.getAbsolutePath());
                System.out.println("name=" + readfile.getName());
                manipulatePdf(readfile.getAbsolutePath(), DEST + File.separator + readfile.getName());
            }

        }
    }

    public static void westNorth(String dir) throws IOException, DocumentException {
        File file = new File(dir);

        /*  System.out.println(file.getAbsolutePath());
        file.getParentFile().mkdirs();
        new OriginalAddContent().manipulatePdf(SRC, DEST);*/

        //System.out.println("文件夹");
        String[] filelist = file.list();
        for (int i = 0; i < filelist.length; i++) {
            File readfile = new File(dir + "\\" + filelist[i]);
            if (!readfile.isDirectory()) {
                System.out.println("path=" + readfile.getPath());
                System.out.println("absolutepath="
                        + readfile.getAbsolutePath());
                System.out.println("name=" + readfile.getName());
                manipulatePdf2(readfile.getAbsolutePath(), DEST + File.separator + readfile.getName());
            }

        }
    }

    public static void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        System.out.println("src = [" + src + "], dest = [" + dest + "]");
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        /*   PdfContentByte canvas = stamper.getUnderContent(1);*/
        PdfContentByte canvas = stamper.getOverContent(1);

        canvas.saveState();
        canvas.setColorFill(BaseColor.GRAY);
   /*     //姓名
        canvas.rectangle(65, 534, 66, 16);
        //年龄
        canvas.rectangle(300, 534, 66, 16);
        //孕周
        canvas.rectangle(540, 534, 66, 16);
        //手机号码
        canvas.rectangle(710, 534, 66, 16);*/
        //个人信息栏坐标
        canvas.rectangle(534, -260, 16, PageSize.A4.getHeight());
        //医生签名
        canvas.rectangle(390, 0, 16, 65);
        //监护医生
        canvas.rectangle(415, -25, 16, 98);
        //医院标题
        canvas.rectangle(PageSize.A4.getWidth() - 25, 112, 22, 124);
        canvas.fill();
        canvas.restoreState();
        stamper.close();
        reader.close();
    }

    public static void manipulatePdf2(String src, String dest) throws IOException, DocumentException {
        System.out.println("src = [" + src + "], dest = [" + dest + "]");
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        /*   PdfContentByte canvas = stamper.getUnderContent(1);*/
        PdfContentByte canvas = stamper.getOverContent(1);

        canvas.saveState();
        canvas.setColorFill(BaseColor.GRAY);
        //姓名
        canvas.rectangle(528, 458, 16, 66);
        //年龄
        canvas.rectangle(528, 300, 16, 66);
        //孕周
        canvas.rectangle(508, 458, 16, 66);
        //手机号码
        canvas.rectangle(508, 300, 16, 66);
        //个人信息栏坐标
        //canvas.rectangle(534, -260, 16, PageSize.A4.getHeight()/2);
        //医生签名
        canvas.rectangle(390, 458, 16, 65);
        //监护医生
        // canvas.rectangle(415, -25, 16, 98);
        //医院标题
        canvas.rectangle(PageSize.A4.getWidth() - 25, 112, 22, 124);
        canvas.fill();
        canvas.restoreState();
        stamper.close();
        reader.close();
    }
}