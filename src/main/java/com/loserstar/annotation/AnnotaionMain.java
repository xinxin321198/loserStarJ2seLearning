/**
 * author: loserStar
 * date: 2018年6月26日下午5:56:12
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * author: loserStar
 * date: 2018年6月26日下午5:56:12
 * remarks:
 */
public class AnnotaionMain {

	public static void main(String[] args) throws ClassNotFoundException {
		Class class1 = Class.forName("com.loserstar.annotation.AnnotationTestClass1");
		//获得所有有效注解
		Annotation[] annotations = class1.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
		//获得类注解		
		LoserStarTable loserStarTable = (LoserStarTable) class1.getAnnotation(LoserStarTable.class);
		System.out.println(loserStarTable.toString());
		System.out.println(loserStarTable.value());
		
		//获得字段上的注解
		Field[] fields = class1.getFields();//获取所有字段
		for (Field field : fields) {
			System.out.println("字段名："+field.getName());
			//获取字段上的注解
			LoserStarField annotaionField  = field.getAnnotation(LoserStarField.class);
			System.out.println("注解信息："+annotaionField.value()+" "+annotaionField.type()+" "+annotaionField.length());
		}
		
		
	}
}
