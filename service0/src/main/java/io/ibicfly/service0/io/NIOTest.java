package io.ibicfly.service0.io;

import sun.nio.ch.FileChannelImpl;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/15 15:28
 * @Description: 作用描述
 */
public class NIOTest {
    private static final File TESTFILE = new File("D://测试对象传输文件.txt");

    public static void main(String[] args) {
        FileChannel fileChannel = null;
        FileChannel fileChannel1=null;
        try {
//          创建了一个只读Channel
            fileChannel = new FileInputStream(TESTFILE).getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(2048);
            fileChannel.read(buffer);
            buffer.flip();
            StringBuffer stringBuffer = new StringBuffer();
            while (buffer.hasRemaining())
                stringBuffer.append((char) buffer.get());
            System.out.println(stringBuffer.toString());
            String index=stringBuffer.subSequence(stringBuffer.lastIndexOf("t")+1,stringBuffer.length()).toString();
            Integer num=Integer.parseInt(index);
//           创建一个写Channel
            stringBuffer.append("test"+(++num));
            fileChannel1=new FileOutputStream(TESTFILE).getChannel();
            fileChannel1.write(ByteBuffer.wrap(stringBuffer.toString().getBytes()));
//            fileChannel1.write(ByteBuffer.wrap(stringBuffer.toString().getBytes()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileChannel!=null)
                    fileChannel.close();
                if(fileChannel1!=null)
                    fileChannel1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
