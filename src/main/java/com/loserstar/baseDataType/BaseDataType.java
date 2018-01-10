/**
 * author: loserStar
 * date: 2018年1月10日下午1:29:02
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.baseDataType;

import junit.framework.Test;

/**
 * author: loserStar
 * date: 2018年1月10日下午1:29:02
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
public class BaseDataType {

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("----------------test int");
		int a = 10;
		int a2 = 010;
		int a3 = 0xf;
	//	byte b = 200;
	//	System.out.println(b);
		System.out.println(a);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toOctalString(a));
		System.out.println(Integer.toHexString(a));
		
		int a5 = 10;
		long a6 = 200;
		byte b2 = 100;   //如果数据的大小没有超过byte/short/char的表述范围，则可以自动转型。
		
		long  a7 = 11123213232L;
		long l = 3;
		long l2 = l+3;    //L问题
		
		System.out.println("-----------------test float/double");
		//测试浮点数
		//double d = 3.14;   //浮点数常量默认类型是double。
		//float f = 6.28F;
		double d2 = 314e-2;   //采用科学计数法的写法
		System.out.println(d2);
		
		float f = 0.1f;
		double d = 1.0/10;
		System.out.println(f==d);   //false
		
		
		System.out.println("--------------------test char");
		char c1 = 'a';
		char c2 = '尚';   //unicode  2: 0-65535
		char c3 = '\n';
		System.out.print(c1);
		System.out.print(c3);
		System.out.print(c2);
		
		char c4 = 'a';
		int i = c4 + 2;
		char c5 = (char)i;   //强制转型
		System.out.println(c5);
		
		//循环打印a-z
		for(int j=0;j<26;j++){
			char temp = (char)(c4+j);
			System.out.print(temp);
		}
		
		//java里面的字符串，是定义成：String类了。
		String  str = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("\n"+str);
		
		System.out.println("------------------------测试自动转型和强制转型 ");
		//测试自动转型和强制转型 
		/*	
		byte b = 123;
		//byte b2 = 300;
		//char c = -3;
		char c2 = 'a';
		int i = c2;
		long d01 = 123213;
		float f = d01;
		
		//测试强制转型
		int i2 = -100;
		char c3 = (char)i2;   //-100超过char的表数范围，所以转换成完全不同的值，无意义的值！
		System.out.println(c3);
	*/	
	/*
		//表达式中的类型提升问题
		int a = 3;
		long b = 4;
		double d = 5.3;
		int c = (int)(a+b);   //做所有的二元运算符(+-/*%)，都会有类型提升的问题！
		float f = (float)(a + d);
	*/
	
		int money = 1000000000;  //10亿
		int years = 20;
		long total = (long)money*years;   //返回的是负数
		System.out.println(total);
		
		//一个人70年心跳多少次
		long times = 70L*60*24*365*70;
		System.out.println(times);
		
		
		
		System.out.println("----------------测试二进制数");
		int testBinaryNum1 = 0b0000_0000_0000_0000_0000_0000_0000_0011;
		int testBinaryNum2 = 1_2312_3131;
		System.out.println(testBinaryNum1);
		System.out.println(testBinaryNum2);
	}

}
