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

public class MailUtils_�ʼ����� {

	/**
	 * �����ʼ����Ѳ������ ʹ��ʾ�� MailUtils.sendMail("czssix@163.com", "ss2272389827",
	 * user.getEmail(), "ע��ɹ���֤", emailMsg, "smtp.163.com");
	 * 
	 * @param fa
	 *            ������
	 * @param sqm
	 *            smtp��Ȩ��
	 * @param shou
	 *            �ռ���
	 * @param title
	 *            ����������
	 * @param emailMsg
	 *            �ռ���Ϣ
	 * @param fwqAddr��������ַ
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void sendMail(final String fa, final String sqm, String shou, String title, String emailMsg,
			String fwqAddr) throws AddressException, MessagingException {
		// 1.����һ���������ʼ��������Ự���� Session

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");
		props.setProperty("mail.host", fwqAddr);// ��������ַ
		props.setProperty("mail.smtp.auth", "true");// ָ����֤Ϊtrue

		// ������֤��
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fa, sqm);// �����ߵ��˺ź���Ȩ��
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.����һ��Message�����൱�����ʼ�����
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(fa)); // ���÷�����

		message.setRecipient(RecipientType.TO, new InternetAddress(shou)); // ���÷��ͷ�ʽ�������

		message.setSubject(title);// ����
		// message.setText("����һ�⼤���ʼ�����<a href='#'>���</a>");

		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.���� Transport���ڽ��ʼ�����

		Transport.send(message);
	}
}
