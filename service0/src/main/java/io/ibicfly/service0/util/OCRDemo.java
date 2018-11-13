package io.ibicfly.service0.util;

import java.io.File;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * 类说明 ： tess4j测试类
 */
public class OCRDemo {
    public static void main(String[] args) throws TesseractException {

        ITesseract instance = new Tesseract();
        //如果未将tessdata放在根目录下需要指定绝对路径
//        instance.setDatapath("the absolute path of tessdata");
        instance.setDatapath("E:/Tess4J-ocr-test/Tess4J-3.4.8-src/Tess4J/tessdata");
        //如果需要识别英文之外的语种，需要指定识别语种，并且需要将对应的语言包放进项目中
//        instance.setLanguage("chi_sim");
        instance.setLanguage("eng");

        // 指定识别图片
        File imgDir = new File("C://Users/Arvin/Desktop/test.png");
        long startTime = System.currentTimeMillis();
        String ocrResult = instance.doOCR(imgDir);

        // 输出识别结果
        System.out.println("OCR Result: \n" + ocrResult + "\n 耗时：" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
