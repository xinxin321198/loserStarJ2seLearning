/**
 * author: loserStar
 * date: 2018年5月21日上午11:36:48
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.date;

import java.util.Date;

/**
 * author: loserStar
 * date: 2018年5月21日上午11:36:48
 * remarks:
 */
public class DateTest {
	public static void main(String[] args) {
		//标准纪元，1970.1.1 0点开始的毫秒数，类型long
		Date date = new Date();
		System.out.println(date.getTime());
		System.out.println(System.currentTimeMillis());
	}
}
