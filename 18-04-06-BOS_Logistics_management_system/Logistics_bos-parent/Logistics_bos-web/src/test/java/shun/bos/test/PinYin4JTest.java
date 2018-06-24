package shun.bos.test;

import org.junit.Test;
import shun.bos.utils.PinYin4jUtils;

/**
 * @author czs
 * @version 创建时间：2018年4月16日 下午10:43:01 用来测试拼音4j
 */
public class PinYin4JTest {

	@Test
	public void pinYinTest() {
		// 定义初始数据
		String sheng = "湖南省";
		String shi = "娄底市";
		String qu = "娄星区";
		// 截取去掉省、市、区这几个字
		sheng = sheng.substring(0, sheng.length() - 1);
		shi = shi.substring(0, shi.length() - 1);
		qu = qu.substring(0, qu.length() - 1);
		// 获得到即将转换成拼音的数据
		String info = sheng + shi + qu;
		// 获得区域简码的数组
		String[] regionShortCodeArray = PinYin4jUtils.getHeadByString(info);
		// 拼装区域简码
		StringBuffer regionShortCode = new StringBuffer();
		for (String string : regionShortCodeArray) {
			regionShortCode.append(string);
		}
		System.out.println("区域简码：" + regionShortCode);
		// 获得城市编码的数组
		String[] chenshiCodeArray = PinYin4jUtils.stringToPinyin(shi);
		// 拼装城市编码
		StringBuffer chenshiCode = new StringBuffer();
		for (String string : chenshiCodeArray) {
			chenshiCode.append(string);
		}
		System.out.println("城市编码：" + chenshiCode);
	}
}
