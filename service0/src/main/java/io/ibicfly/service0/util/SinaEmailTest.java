package io.ibicfly.service0.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.util.StringUtils;

import java.util.Date;

public class SinaEmailTest {
    public static void send(String emailAddress, String content, String username, String password) {
        HtmlEmail email = new HtmlEmail();// 用来发送HTML格式的email，除了有MultipartEmail的所有能力，还可以发送内嵌的图象
        try {
            email.setHostName("smtp.sina.cn");
//        email.setSmtpPort(465);
            email.setAuthentication(username, password);
            email.setCharset("utf-8");// 设置编码集
            email.addTo(emailAddress);// 收件人邮箱
            email.setFrom(username);
            email.setSubject("test测试");// 发送主题（邮件主题）
            if (StringUtils.isEmpty(content))
                content = "";
            email.setMsg("测试内容test\n" + content + "\n发送时间" + new Date());// 邮件内容
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
        System.out.println("发送成功");
    }

    public static void main(String[] args) {
    }
}
