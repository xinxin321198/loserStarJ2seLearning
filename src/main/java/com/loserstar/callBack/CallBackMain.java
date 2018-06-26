/**
 * author: loserStar
 * date: 2018年6月26日下午3:52:28
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.callBack;


/**
 * author: loserStar
 * date: 2018年6月26日下午3:52:28
 * remarks:
 */
public class CallBackMain{
	public static void main(String[] args) {
		CallBackTest test = new CallBackTest();
		String string = "A";//需要传入到内部类去的值
		CallBack callBack = new CallBack(string);//实现回调接口,此类提供构造方法可以传值进去
		test.Test(callBack);//该方法会调用回调接口中的call和setValue方法
		System.out.println(callBack.getValue());//验证方法是否调用
		new Thread();
		
		final String _string = string;
		//直接new匿名类实现回调
		test.Test(new ICallBack() {
			//匿名内部类只允许使用final修饰的变量，所以需要一个final变量来做中转
			@Override
			public void setVlaue(String s) {
				System.out.println("此内部类没有内部变量，无法设置");
			}
			
			@Override
			public void Call() {
				System.out.println("直接使用外部类的值："+_string);
			}
		});
	}
}
