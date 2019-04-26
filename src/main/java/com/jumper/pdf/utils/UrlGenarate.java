package com.jumper.pdf.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlGenarate {
    public static void main(String[] args) throws IOException {
        final String baseUrl = "http://image.jumper-health.com";
        final String baseStorePath = "F://report";
        File baseDir = new File(baseStorePath);
        if (!baseDir.exists()) {
            baseDir.mkdir();
        }
        File input = new File("F://report.htm");
        Document doc = Jsoup.parse(input, "UTF-8");
        Elements urls = doc.select("body > table > tbody"); // 具有 href 属性的链接
        Elements tr = urls.select("tr");
        Elements pdfs = urls.select("td:nth-child(1)");
        System.out.println("args = [" + urls.size() + "]");
        System.out.println("args = [" + pdfs.size() + "]");
        int counter = 1;
        for (Element el : pdfs) {
            if(counter==1){

            }else{
                String uri = baseUrl + el.text();
                System.out.println("uri = [" + uri + "]");

               String filename = baseStorePath+File.separator+el.text().substring(el.text().lastIndexOf("/"));
                System.out.println("filename = [" + filename + "]");
               downLoadFromUrl(uri,el.text().substring(el.text().lastIndexOf("/")),filename);
              /*  URL url = new URL(uri);
                System.out.println(baseUrl + el.text());
                String fileName = baseDir+File.separator+el.text();
                downloadNet(url,fileName);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }

            counter++;
        }
    }

    public static void downloadNet(URL url, String fileName) throws MalformedURLException {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;
        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(fileName);

            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
        URL url = new URL(urlStr);
        System.out.println("urlStr = [" + urlStr + "], fileName = [" + fileName + "], savePath = [" + savePath + "]");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3 * 1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }
        File file = new File(saveDir + File.separator + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if (fos != null) {
            fos.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
        System.out.println("info:" + url + " download success");
    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();

    }
}
