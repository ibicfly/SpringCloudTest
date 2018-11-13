package io.ibicfly.service0.util;

import java.io.Console;
import java.io.File;

/**
 * @Author :cyh
 * @CreateDate: 2018/11/7 17:17
 * @Description: 作用描述
 */
public class KuGouTest {

    public static void Main(String[] args) {
        byte[] key = {(byte)0xAC, (byte)0xEC, (byte)0xDF, (byte)0x57};
        File input = new File("文件名");//输出文件
        //跳过1024字节的包头 用nio，或者使用io先读1024字节
//        待写
        byte[] buffer = new byte[key.length];
        int length;
        while (true) {
//            循环buffer
            for (int i = 0; i < buffer.length; i++) {
                int k = key[i];
                int kh = k >> 4;
                int kl = k & 0xf;
                int b = buffer[i];
                int low = b & 0xf ^ kl;//解密后的低4位
                int high = (b >> 4) ^ kh ^ low & 0xf;//解密后的高4位
                buffer[i] = (byte) (high << 4 | low);
            }
//            写
//            output.Write(buffer, 0, length);
        }
//        output.Close();
    }

}
