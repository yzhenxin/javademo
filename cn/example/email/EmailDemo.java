package cn.example.email;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件创建步骤:
 * 创建一个邮件对象（MimeMessage）
 * 设置发件人，收件人，可选增加多个收件人，抄送人，密送人
 * 设置邮件的主题（标题）
 * 设置邮件的正文（内容）
 * 设置显示的发送时间
 * 保存到本地
 * 
 * 
 * @author yzx
 *
 */
public class EmailDemo {
	
	public static void main(String[] args) {
		try {
			sendSmtpMail("你好");
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void sendSmtpMail(String message) throws MessagingException, IOException {
		
		/**
		 * 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码(有的邮箱称为“授权码”)
		 * 对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码(授权码)
		 */
		
		String emailAccount = "yuan.zhenxin@lifecycle.cn";
		String emailPassword = "yzX123456";
		String emailSMTPHost = "smtp.exmail.qq.com";
		String receiveEmailAccount = "1415982984@qq.com";
		String mailProtocol = "smtp";
		String smtpPort = "465";
		
		// 1. Create an email
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", mailProtocol); // JavaMail protocol
		props.setProperty("mail.smtp.host", emailSMTPHost); // receiver's SMTP server address
		props.setProperty("mail.smtp.auth", "true"); // 请求认证
//		props.setProperty("mail.smtp.port", smtpPort);
		// SSL
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		
		Session session = Session.getInstance(props);
		session.setDebug(true);
		
		
		MimeMessage mimeMessage = new MimeMessage(session);
		/*
         * 也可以根据已有的eml邮件文件创建 MimeMessage 对象
         * MimeMessage message = new MimeMessage(session, new FileInputStream("MyEmail.eml"));
         */
		
		/*
		 *  2. From : sender
		 *  其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
		 *  真正要发送时, 邮箱必须是真实有效的邮箱。
		 */
		mimeMessage.setFrom(new InternetAddress("yuan.zhenxin@lifecycle.cn", "USER_SENDER", "UTF-8"));
		
		/**
		 * 3. To: receiver
		 */
		mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveEmailAccount, "USER_RECEIVER", "UTF-8"));
		/**
		 * To: add more receiver (optional)
		 */
		mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveEmailAccount, "USER_ADD_RECEIVER", "UTF-8"));
		 //    Cc: 抄送（可选）
		mimeMessage.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress(receiveEmailAccount, "USER_RECEIVER_CC", "UTF-8"));
        //    Bcc: 密送（可选）
		mimeMessage.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(emailAccount, "USER_RECEIVER_BCC", "UTF-8"));

		/**
		 * 4. email subject
		 */
		mimeMessage.setSubject("JMAIL DEMO", "UTF-8");
		
		/**
		 * 5. Content, can use html
		 */
		mimeMessage.setContent(message, "text/html;charset=UTF-8");
		
		/**
		 * 6. set send time
		 */
		mimeMessage.setSentDate(new Date());
		
		/**
		 * 7. save before setting
		 */
		mimeMessage.saveChanges();
		
		/**
		 * 8. save sended email to local file
		 */
		FileOutputStream fos = new FileOutputStream("D:/jmail.eml", true);
		mimeMessage.writeTo(fos);
		fos.flush();
		fos.close();
		
		Transport transport = session.getTransport();
		transport.connect(emailAccount, emailPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		
		transport.close();
	}
	
}
