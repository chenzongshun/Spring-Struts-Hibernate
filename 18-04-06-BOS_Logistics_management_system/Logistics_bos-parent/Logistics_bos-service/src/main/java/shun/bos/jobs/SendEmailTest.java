package shun.bos.jobs;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
* @author czs
* @version ����ʱ�䣺2018��4��29�� ����3:00:58 
*/
public class SendEmailTest {
	public static void main(String[] args) {
		try {
			MailUtils_�ʼ�����.sendMail("czssix@163.com", "sqm2272389827", "2272389827@qq.com", "ע��ɹ���֤", "����",
					"smtp.163.com");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("���ͳɹ�");
	}
}
