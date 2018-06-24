package com.itheima.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 第一个入门案例
 * @author 疙瘩陈
 *
 */
public class MyJob {
	public void run() {
		System.out.println("入门完成案例，定时触发：" + 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}
