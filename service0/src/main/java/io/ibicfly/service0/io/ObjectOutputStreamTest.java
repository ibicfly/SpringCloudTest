package io.ibicfly.service0.io;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectOutputStreamTest {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("01"));
        List list=new ArrayList();
        Map map=new HashMap();

//      查询时使用有序机制
        Byte[] bytes=new Byte[1024];
        Test test=new Test("测试");
        File file=new File("D://测试对象传输文件.txt");
        ObjectOutputStream outputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {
            outputStream= new ObjectOutputStream(new FileOutputStream(file));
//            new Byte
//            bufferedOutputStream=outputStream
            outputStream.writeObject(test);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Test implements  Serializable
{
    private String name;
    public Test(String name){
        this.name=name;
    }
}
