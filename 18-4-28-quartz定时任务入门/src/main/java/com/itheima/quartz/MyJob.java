package com.itheima.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��һ�����Ű���
 * @author ����
 *
 */
public class MyJob {
	public void run() {
		System.out.println("������ɰ�������ʱ������" + 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
