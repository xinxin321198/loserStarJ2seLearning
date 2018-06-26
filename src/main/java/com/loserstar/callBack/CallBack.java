/**
 * author: loserStar
 * date: 2018年6月26日下午3:49:43
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.callBack;

/**
 * author: loserStar
 * date: 2018年6月26日下午3:49:43
 * remarks:
 */
public class CallBack implements ICallBack {
	private String s;
	public CallBack(String s) {
		super();
		this.s = s;
	}
	@Override
	public void Call() {
		System.out.println("回调方法Call()被调用::"+s);
	}
	@Override
	public void setVlaue(String s) {
		System.out.println("回调方法setVlaue被调用::");
		this.s += s;
	}

	public String getValue() {
		return this.s;
	}
}
