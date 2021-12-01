package com.loserstar.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 * author: loserStar
 * date: 2018年2月2日下午12:50:09
 * email:362527240@qq.com
 * remarks:
 */
public class ReflectTest {
	    public String pub="公共字段";
		private String id;
		private String userName;
		private String passWord;
		
		
		
		public ReflectTest() {
			super();
			System.out.println("ReflectTest()构造方法-调用");
		}
		public ReflectTest(String id, String userName, String passWord) {
			super();
			System.out.println(" ReflectTest(String id, String userName, String passWord)构造方法-调用");
			this.id = id;
			this.userName = userName;
			this.passWord = passWord;
		}
		
		
		private ReflectTest(String id) {
			super();
			System.out.println(" ReflectTest(String id)私有构造方法-调用");
			this.id = id;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassWord() {
			return passWord;
		}
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
	
		public void hello() {
			System.out.println("这是ReflectTest的Hello()公共方法-调用");
		}
		private void helloPrivate() {
			System.out.println("这是ReflectTest的helloPrivate()私有方法-调用");
		}
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		//1.反射获取Class对象
		
		//第一种方式获取Class对象   
		ReflectTest user = new ReflectTest();
		Class class1 = user.getClass();
		System.out.println(class1.getName());
		
		//第二种方式获取Class对象  
        Class stuClass2 = ReflectTest.class;  
        System.out.println(class1 == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个  
          
        //第三种方式获取Class对象  
        Class stuClass3 = Class.forName("com.loserstar.reflect.ReflectTest");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名  
        System.out.println(stuClass3 == stuClass2);//判断三种方式是否获取的是同一个Class对象  
        
        
        
        //2.获取所有公有构造方法  
        System.out.println("**********************所有公有构造方法*********************************");  
        Constructor[] conArray = stuClass3.getConstructors();
        for(Constructor c : conArray){  
            System.out.println(c);  
        }  
        
        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");  
        conArray = stuClass3.getDeclaredConstructors();  
        for(Constructor c : conArray){  
            System.out.println(c);  
        }  
        
        
        System.out.println("*****************获取公有、无参的构造方法*******************************");  
        Constructor con = stuClass3.getConstructor(null);  
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型  
        //2>、返回的是描述这个无参构造函数的类对象。  
      
        System.out.println("con = " + con);  
        
        
      //调用构造方法  
        System.out.println("******************调用构造方法*******************************");  
        Object obj = con.newInstance();  
    //  System.out.println("obj = " + obj);  
    //  Student stu = (Student)obj;  
        
        System.out.println("******************获取私有构造方法，并调用*******************************");  
        con = stuClass3.getDeclaredConstructor(String.class);  
        System.out.println(con);  
        //调用构造方法  
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)	  
        obj = con.newInstance("男");  
        
        
        
        //----------------------------------------获取属性
        
        //2.获取字段  
        System.out.println("************获取所有公有的字段********************");  
        Field[] fieldArray = stuClass3.getFields();  
        for(Field f : fieldArray){  
            System.out.println(f);  
        }  
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");  
        fieldArray = stuClass3.getDeclaredFields();  
        for(Field f : fieldArray){  
            System.out.println(f);  
        }  
        
        
        System.out.println("*************获取公有字段**并调用***********************************");  
        Field f = stuClass3.getField("pub");  
        System.out.println(f);  
        //获取一个对象  
//        //为字段设置值  
        f.set(obj, "刘德华");//为pub属性赋值--》stu.name = "刘德华"  
//        //验证  
        ReflectTest stu = (ReflectTest)obj;  
        System.out.println("验证pub：" + stu.pub);  
//          
//          
        System.out.println("**************获取私有字段****并调用********************************");  
        f = stuClass3.getDeclaredField("id");  
        System.out.println(f);  
        f.setAccessible(true);//暴力反射，解除私有限定  
        f.set(obj, "18888889999");  
        System.out.println("验证id：" + stu.id);  
        
        ReflectTest instanceReflectTest = (ReflectTest) stuClass3.newInstance();
        System.out.println("**************获取共有方法****并调用********************************");  
        Method hello = stuClass3.getDeclaredMethod("hello");
        hello.setAccessible(true);
        hello.invoke(instanceReflectTest, args);
        
        System.out.println("**************获取私有方法****并调用********************************");  
        Method helloPrivate = stuClass3.getDeclaredMethod("helloPrivate");
        helloPrivate.setAccessible(true);
        helloPrivate.invoke(instanceReflectTest, args);
	}
}
