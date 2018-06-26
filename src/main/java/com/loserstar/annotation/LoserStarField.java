/**
 * author: loserStar
 * date: 2018年6月26日下午5:50:54
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * author: loserStar
 * date: 2018年6月26日下午5:50:54
 * remarks:定义数据库字段
 */
@Retention(RUNTIME)
@Target(ElementType.FIELD)
public @interface LoserStarField {
	String value() default "" ;
	String type() default "varchar";
	int length() default 10;
}
