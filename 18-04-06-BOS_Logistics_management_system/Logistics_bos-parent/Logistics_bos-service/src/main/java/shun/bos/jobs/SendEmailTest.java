package shun.bos.jobs;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
* @author czs
* @version 创建时间：2018年4月29日 下午3:00:58 
*/
public class SendEmailTest {
	public static void main(String[] args) {
		try {
			MailUtils_邮件邮箱.sendMail("czssix@163.com", "sqm2272389827", "2272389827@qq.com", "注册成功验证", "内容",
					"smtp.163.com");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("发送成功");
	}
}
