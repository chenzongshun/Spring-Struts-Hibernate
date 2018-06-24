package shun.bos.jobs;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils_邮件邮箱 {

	/**
	 * 发送邮件，已测试完好 使用示例 MailUtils.sendMail("czssix@163.com", "ss2272389827",
	 * user.getEmail(), "注册成功验证", emailMsg, "smtp.163.com");
	 * 
	 * @param fa
	 *            发件人
	 * @param sqm
	 *            smtp授权码
	 * @param shou
	 *            收件人
	 * @param title
	 *            邮箱标题标题
	 * @param emailMsg
	 *            收件信息
	 * @param fwqAddr服务器地址
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void sendMail(final String fa, final String sqm, String shou, String title, String emailMsg,
			String fwqAddr) throws AddressException, MessagingException {
		// 1.创建一个程序与邮件服务器会话对象 Session

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");
		props.setProperty("mail.host", fwqAddr);// 服务器地址
		props.setProperty("mail.smtp.auth", "true");// 指定验证为true

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fa, sqm);// 发送者的账号和授权码
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(fa)); // 设置发送者

		message.setRecipient(RecipientType.TO, new InternetAddress(shou)); // 设置发送方式与接收者

		message.setSubject(title);// 标题
		// message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送

		Transport.send(message);
	}
}
