package io.ibicfly.service0.io;

import java.io.*;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/15 14:41
 * @Description: 作用描述
 */
public class PrintWriterTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter printWriter = null;
        BufferedInputStream bufferedInputStream = null;
        PrintStream printStream = System.out;
        try {
            printWriter = new PrintWriter(printStream);
            printWriter.append("a");
//        finally {
//            printWriter.close();
//        }
            bufferedInputStream = new BufferedInputStream(new FileInputStream("D://测试对象传输文件.txt"));
            byte[] bytes = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(bytes);
            String temp = new String(bytes);
            printStream.println(temp);
            printStream.println("temp");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null)
                    bufferedInputStream.close();
                if(printWriter!=null)
                    printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        printStream.print("test2");
    }
}
