package shun.bos.test;

import org.junit.Test;
import shun.bos.utils.PinYin4jUtils;

/**
 * @author czs
 * @version ����ʱ�䣺2018��4��16�� ����10:43:01 ��������ƴ��4j
 */
public class PinYin4JTest {

	@Test
	public void pinYinTest() {
		// �����ʼ����
		String sheng = "����ʡ";
		String shi = "¦����";
		String qu = "¦����";
		// ��ȡȥ��ʡ���С����⼸����
		sheng = sheng.substring(0, sheng.length() - 1);
		shi = shi.substring(0, shi.length() - 1);
		qu = qu.substring(0, qu.length() - 1);
		// ��õ�����ת����ƴ��������
		String info = sheng + shi + qu;
		// ���������������
		String[] regionShortCodeArray = PinYin4jUtils.getHeadByString(info);
		// ƴװ�������
		StringBuffer regionShortCode = new StringBuffer();
		for (String string : regionShortCodeArray) {
			regionShortCode.append(string);
		}
		System.out.println("������룺" + regionShortCode);
		// ��ó��б��������
		String[] chenshiCodeArray = PinYin4jUtils.stringToPinyin(shi);
		// ƴװ���б���
		StringBuffer chenshiCode = new StringBuffer();
		for (String string : chenshiCodeArray) {
			chenshiCode.append(string);
		}
		System.out.println("���б��룺" + chenshiCode);
	}
}
