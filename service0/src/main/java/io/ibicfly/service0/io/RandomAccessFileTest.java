package io.ibicfly.service0.io;

import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.RandomAccess;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/15 11:21
 * @Description: 作用描述
 */
public class RandomAccessFileTest  {
    private final static String NIOTEST = "D://niotest.txt";

    static class NIO {
        private final static String RW = "rw";
        private final static String R = "r";
        private final static String W = "w";
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
        fill(1024 * 1000);
//            fill();
//        }

//        getMiddle();
//        testIntBufferToDoubleBuffer();
//        testBufferToText();
//        test();
    }

    public static void test() {
        RandomAccessFile randomAccessFile = null;
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile("D://测试对象传输文件.txt", "rw");
//            byte[] bytes = new byte[1024];
//            int hasRead = 0;
//            while ((hasRead = randomAccessFile.read(bytes)) > 0) {
//                System.out.println(new String(bytes, 0, hasRead));
//                System.out.println(randomAccessFile.getFilePointer());
//            }

            fileChannel = randomAccessFile.getChannel();
//            创建缓冲区进行读操作
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fileChannel.read(buffer);
            buffer.flip();
            StringBuffer stringBuffer = new StringBuffer();
//           读
            while (buffer.hasRemaining())
                stringBuffer.append((char) buffer.get());
            System.out.println(stringBuffer.toString());
//          转写
//            fileChannel.position(fileChannel.size());

            buffer.clear();
            fileChannel.position(0);
            buffer.put("testNew3".getBytes());
            buffer.flip();
            fileChannel.write(buffer);
            buffer = ByteBuffer.wrap("testNew2".getBytes());
            fileChannel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileChannel != null)
                    fileChannel.close();
                if (randomAccessFile != null)
                    randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testBufferToText() {
        FileChannel fileChannel = null;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            fileChannel = new RandomAccessFile(NIOTEST, NIO.RW).getChannel();
            fileChannel.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining())
                System.out.println((char) buffer.get());
            fileChannel.position(0);
            fileChannel.write(ByteBuffer.wrap(("test2").getBytes()));
//            buffer.flip();
//            buffer.put("diff".getBytes());
//            buffer.flip();
//            fileChannel.position(0);
//            while (buffer.hasRemaining())
//                fileChannel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileChannel != null)
                    fileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testIntBufferToDoubleBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        for (int i = 0; i < 5; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((char) (i + 97));
            buffer.put(stringBuffer.toString().getBytes());
        }
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.flip();
        buffer.clear();
        CharBuffer charBuffer = buffer.asCharBuffer();
        boolean temp = false;
        while ((temp = charBuffer.hasRemaining()))
            System.out.println(charBuffer.get());
    }

    public static void fill(int... size) {
        FileChannel fileChannel = null;
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(NIOTEST, NIO.RW);
            fileChannel = randomAccessFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            int sizeTemp = (int) fileChannel.size();
            int min = 0;
            int max = 1024;
            if (sizeTemp != 0) {
                min = sizeTemp;
                max = sizeTemp << 1;
            }
//           这种方式是通过控制插入的Byte数组的长度，控制一次插入的数量
            for (int i = min; i < max; i++) {
                String temp=i+"";
                if(byteBuffer.position()+temp.length()<=byteBuffer.capacity())
                    byteBuffer.put(temp.getBytes());
                else{
                    fileChannel.position(fileChannel.size());
                    byteBuffer.flip();
                    fileChannel.write(byteBuffer);
                    byteBuffer.clear();
                    byteBuffer.put(temp.getBytes());
                }
            }

//           写完直接读
            byteBuffer=ByteBuffer.allocate(1024);
            System.out.println(fileChannel.position());
            fileChannel.position(0);
            System.out.println(fileChannel.size());
            int bytesRead = fileChannel.read(byteBuffer);
            while (bytesRead != -1) {
                // System.out.println("读取字节数："+bytesRead);
                //之前是写buffer，现在要读buffer
                byteBuffer.flip();// 切换模式，写->读
                System.out.print(Charset.forName("utf-8").decode(byteBuffer));  // 这样读取，如果10字节恰好分割了一个字符将出现乱码
                byteBuffer.clear();// 清空,position位置为0，limit=capacity
                //  继续往buffer中写
                bytesRead = fileChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileChannel != null)
                    fileChannel.close();
                if (randomAccessFile != null)
                    randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getMiddle(int... size) {
        FileChannel fileChannel = null;
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(NIOTEST, NIO.RW);
            fileChannel = randomAccessFile.getChannel();
            fileChannel.tryLock();
            fileChannel.position(fileChannel.size() / 2);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fileChannel.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((int) buffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileChannel != null)
                    fileChannel.close();
                if (randomAccessFile != null)
                    randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delLastHalf(int... size) {
        FileChannel fileChannel = null;
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(NIOTEST, NIO.RW);
            fileChannel = randomAccessFile.getChannel();
            int sizeTemp = (int) fileChannel.size();
            fileChannel.position(sizeTemp / 2);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fileChannel.truncate(sizeTemp / 2);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((int) buffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileChannel != null)
                    fileChannel.close();
                if (randomAccessFile != null)
                    randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
