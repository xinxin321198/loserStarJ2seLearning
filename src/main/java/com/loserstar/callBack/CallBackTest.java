/**
 * author: loserStar
 * date: 2018年5月21日上午10:30:17
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.callBack;

/**
 * author: loserStar
 * date: 2018年5月21日上午10:30:17
 * remarks: 回调的用法
 */
public class CallBackTest {
	/**
	 * 支持回调函数的方法
	 * @param callBack
	 */
	public void Test(ICallBack callBack) {
		callBack.Call();
		callBack.setVlaue("B");
	}
}
