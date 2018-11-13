package io.ibicfly.service0.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/15 11:12
 * @Description: 作用描述
 */
public class BufferedReaderTest {
    public static void main(String[] args) {
        System.out.println(read());
    }
    public static String read(String... fileName)
    {
        BufferedReader bufferedReader=null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            bufferedReader= new BufferedReader(new FileReader("D://测试对象传输文件.txt"));
            String s;
            while ((s=bufferedReader.readLine())!=null)
                stringBuffer.append(s+"\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader!=null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
}
