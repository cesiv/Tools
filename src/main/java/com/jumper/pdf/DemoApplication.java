package com.jumper.pdf;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan({"com.jumper.pdf.mapper","com.jumper.pdf.dao"})
@SpringBootApplication
public class DemoApplication
{
    public static void main(String[] args)
        throws IOException
    {
        SpringApplication.run(DemoApplication.class, args);
       // Runtime.getRuntime().exec("cmd.exe /c start /min http://127.0.0.1:8080/user/all");
    }
}
