package com.loserstar.string;

public class StringFormat {
/*
 http://blog.csdn.net/thc1987/article/details/17528093
 */
	public static void main(String[] args) {
	    String str=null;  
	    str=String.format("Hi,%s", "王力");  
	    System.out.println(str);  
	    str=String.format("Hi,%s:%s.%s", "王南","王力","王张");            
	    System.out.println(str);                           
	    System.out.printf("字母a的大写是：%c %n", 'A');  
	    System.out.printf("3>7的结果是：%b %n", 3>7);  
	    System.out.printf("100的一半是：%04d %n", 100/2);  
	    System.out.printf("100的16进制数是：%x %n", 100);  
	    System.out.printf("100的8进制数是：%o %n", 100);  
	    System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);  
	    System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);  
	    System.out.printf("上面价格的指数表示：%e %n", 50*0.85);  
	    System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);  
	    System.out.printf("上面的折扣是%d%% %n", 85);  
	    System.out.printf("字母A的散列码是：%h %n", 'A');  
		
	}

	/**
	 * 数字格式化
	 */
	public static void DecimalFormat() {
		System.out.println("数字格式化");
		//(1)、如果数字1是字符串，如下处理：
        String str1="1";
		java.text.DecimalFormat df=new java.text.DecimalFormat("0000");
		    String str2=df.format(Integer.parseInt(str1));
		    System.out.println(str2);
		//(2)、如果数字1是整型，如下处理：
		        int str3=1;
		java.text.DecimalFormat df2=new java.text.DecimalFormat("0000");
	    String str4=df.format(str2);
	    System.out.println(str2);
	}
}
