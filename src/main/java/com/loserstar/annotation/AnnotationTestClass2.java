/**
 * author: loserStar
 * date: 2018年6月26日下午5:35:05
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.annotation;

/**
 * author: loserStar
 * date: 2018年6月26日下午5:35:05
 * remarks:
 */
@LoserStarTable(value = "tb_class2")
public class AnnotationTestClass2 {
	@LoserStarField(value="f_id2",type="int",length=30)
	public String id2;
	
	@LoserStarField(value="f_name2",type="varchar",length=100)
	public String Name2;
	
	
	public void testFunc1() {
		
	}
}
