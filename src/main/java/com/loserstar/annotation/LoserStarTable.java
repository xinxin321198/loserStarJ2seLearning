/**
 * author: loserStar
 * date: 2018年6月26日下午5:30:52
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.annotation;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: loserStar
 * date: 2018年6月26日下午5:30:52
 * remarks:
 */
@Retention(RetentionPolicy.RUNTIME)//注解的作用范围
@Target({ ElementType.TYPE})//描述使用范围
public @interface LoserStarTable {
	String value() default "" ;//定义注解的值,不设的话给个默认值
}
