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
@LoserStarTable(value = "tb_class1")
public class AnnotationTestClass1 {
	@LoserStarField(value="f_id",type="int",length=3)
	public String id;
	
	@LoserStarField(value="f_name",type="varchar",length=10)
	public String Name;
	
	
	public void testFunc1() {
		
	}
}
