package com.hunqin.demo;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;
public class MailUtil implements Runnable{
	private String email;//收件人邮箱
	private String code;//激活码
	 
	public MailUtil(String email,String code) {
		this.email = email;
		this.code = code;
	}
		public void run() {
		//创建连接对象java.mail.Session
				//创建邮件对象java.mail.Message
				//发送一封激活邮件
		String from = "422977930@qq.com";
		String host = "smtp.qq.com";//指定发件主机smtp.qq.com(QQ)/smtp.163.com(网易)
		Properties poProperties = System.getProperties();//获取系统属性
		poProperties.setProperty("mail.smtp.host", host);//设置邮件服务器
		poProperties.setProperty("mail.smtp.auth", "true");//打开认证
		//QQ邮箱需要的以下代码163不需要
		try {
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			poProperties.put("mail.smtp.ssl.enable","true");
			poProperties.put("mail.smtp.ssl.socketFactory", sf);
			//获取默认Session对象
			Session session = Session.getDefaultInstance(poProperties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("422977930@qq.com", "yithhmdapqndbjfa");  
                }
            });
			// 2.创建邮件对象
            Message message = new MimeMessage(session);
            //披上马甲，防止成为垃圾邮箱
            message.addHeader("X-MimeOLE", "Produced By Microsoft MimeOLE V6.00.2900.2869");
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            // 2.3设置邮件主题
            message.setSubject("账号激活");
            // 2.4设置邮件内容
            //随机生成数字
             
            String content = "您的验证码是:"+code;
            message.setContent(content, "text/html;charset=UTF-8");
         // 3.发送邮件
            System.out.println("开始发送邮件");
            Transport.send(message);
            System.out.println("邮件成功发送!");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}