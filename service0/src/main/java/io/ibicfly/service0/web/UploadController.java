package io.ibicfly.service0.web;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@RestController
@RequestMapping("/upload")
@Api(value = "upload", description = "后台项目管理调用接口")
public class UploadController {

    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile input, HttpServletResponse response)
    {
        String res="Success";
        InputStream inputStream=null;
        FileOutputStream fileOutputStream =null;

        try {
            File file=new File("C://upload/"+
                    new SimpleDateFormat("yyyy-MM-dd-hh-ss-mm")
                    .format(Calendar.getInstance().getTime()));
            fileOutputStream= new FileOutputStream(file);

            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            input.transferTo(file);
            return "上传成功";
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            res="false";
        } catch (IOException e1) {
            e1.printStackTrace();
            res="false";
        }finally {
            try {
                CloseUtil.closeResource(inputStream);
                CloseUtil.closeResource(fileOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
                res="false";
            }
        }
        return res;
    }
}
class CloseUtil
{
    public static void closeResource(InputStream object) throws IOException {

        if(object!=null) {
                object.close();
        }
    }
    public static void closeResource(Channel object) throws IOException {
        if(object!=null) {
                object.close();
        }
    }
    //首先利用getClass方法得到obj的对应class
    public static void closeResource(Object object) throws IOException {
        Class<?> clazz=object.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        try {
            for(Method temp:methods)
            {
                if(temp.getName().equals("close"))
                {
                        temp.invoke(object,null);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

