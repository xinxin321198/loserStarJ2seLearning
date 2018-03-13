/**
 * author: loserStar
 * date: 2018年3月12日上午9:16:43
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;

/**
 * author: loserStar
 * date: 2018年3月12日上午9:16:43
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
public class LoserStarIo {

	
	public static void main(String[] args) {
		//inputStream和outputStream
		
		/***
		 *  String以byte形式写入文件中
		 */
		String stringByteForFile = "c://loserStarstringForFile.txt";
		String stringByteForFileString = "loserStar String以byte形式写入文件中！！aaaaaaaaaaaaaa";
		writeBytesForFile(stringByteForFile, stringByteForFileString.getBytes(),false);
		System.out.println(" String以byte形式写入文件中完成！");
		String stringByteForFileString2 = readByteForFile(stringByteForFile);
		System.out.println("结果：");
		System.out.println(stringByteForFileString2);
		System.out.println(" String以byte形式读取 完成！");
		
		/**
		 * 包装字节流printStream
		 */
		String printStreamFilePath="c://loserStarPrintStream.txt";
		String printStr = "包装字节流printStream写入字符串到文件bbbbbbbbbbbbbbbbbbbbbbb";
		printStreamForFile(printStreamFilePath, printStr,false);
		System.out.println("包装字节流输出 完成！");
		
		/**
		 * ObjectInput,ObjectOutput,把一个对象以二进制持久化到文件中，使用任意的文件名后缀都行，然后再重新读取出来
		 */
		String objectFilePath = "c://LoserStarObject.ls";
		TestUser testUser = new TestUser();
		testUser.setName("loserStar!!!");
		testUser.setAge(27);
		writeObject(objectFilePath,testUser);
		System.out.println("ObjectOutput输出对象 完成！");
		TestUser result = LoserStarIo.readObject(objectFilePath,TestUser.class);
		System.out.println(result.getName()+""+result.getAge());
		System.out.println("ObjectInput读取对象 完成！");
		
		
		


		//reader和writer
		/**
		 * 使用字符流Wirter写字符串到文件
		 */
		String stringWriterFilePath = "c://LoserStarStringWriterFile.txt";
		String writerReaderStr = "以字符流writer形式写字符串到文件中ccccccccccccccccccccccccccccc";
		WriterForFile(stringWriterFilePath, writerReaderStr);
		System.out.println("以字符流writer形式写字符串到文件中 完成！");
		String writerReaderStr2 = ReaderForFile(stringWriterFilePath);//读取大文件
		System.out.println(writerReaderStr2);
		System.out.println("以字符流reader形式读取文件 完成！");
		/**
		 * 使用包装字符流printWriter写字符串到某个输出流中
		 */
		String printWriterFilePath="c://loserStarStringPrintWriter.txt";
		String printWriterString = "使用包装字符流printWriter写字符串到某个输出流中ddddddddddddddddddddddddddddddddd";
		printWriterForFile(printWriterFilePath, printWriterString);
		System.out.println("包装字符流printWriter输出到文件 完成");
	}
	
	/**
	 * 从某个文件中读取字符串
	 *
	 * @param filePath
	 * @return
	 */
	public static String ReaderForFile(String filePath){
		StringBuffer stringBuffer = new StringBuffer();
		try {
			FileReader fileReader = new FileReader(new File(filePath));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine())!=null) {
				stringBuffer.append(line);
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}
	
	
	/**
	 * 基于字符流Writer类，写入字符串到某个文件中
	 *
	 * @param filePath
	 * @param string
	 */
	public static void WriterForFile(String filePath,String string){
		try {
			Writer writer = new FileWriter(new File(filePath));
			writer.write(string);
			writer.flush();
			writer.close();
			System.out.println("WriterForFile end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  利用包装流PrintWriter包装Writer,输出字符串到文本文件中
	 *
	 * @param filePath
	 * @param printStr
	 */
	public static void printWriterForFile(String filePath,String printStr){
		try {
			FileWriter fileWriter = new FileWriter(new File(filePath));
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(printStr);
			printWriter.flush();
			printWriter.close();
			System.out.println("printWriterForFile end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 利用包装流printStream包装outPutStream输出字符串到文本文件中
	 *
	 * @param data
	 */
	public static void printStreamForFile(String printStreamFilePath,String printStr,boolean isAppend){
		try {
			OutputStream outputStream = new FileOutputStream(new File(printStreamFilePath),isAppend);
			PrintStream printStream = new PrintStream(outputStream);
			printStream.print(printStr);
			printStream.flush();
			printStream.close();
			System.out.println("printStreamForFile end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 以字节的方式读取文件中的内容，一次读取文件所有(如果不是UT-8不能读中文)
	 *
	 * @param filePath
	 */
	public static String readByteForFile(String filePath){
		try {
			String encoding = "UTF-8";
			//拿到文件的大小
			File file = new File(filePath);
			long length = file.length();
			//在内存中开辟一个和文件大小一样的byte数组
			byte[] buf = new byte[(int)length];
			//利用字节流读取文件
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(buf);
			fileInputStream.close();
			return new String(buf, encoding);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 写byte数组到某个文件中
	 *
	 * @param filePath
	 * @param data
	 */
	public static void writeBytesForFile(String filePath,byte[] bytes,boolean isAppend){
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath),isAppend);
			fileOutputStream.write(bytes);
			fileOutputStream.flush();
			fileOutputStream.close();
			System.out.println("writeBytesForFile end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 写对象到文件中
	 */
	public static void writeObject(String objectFilePath,Object object){
		try {
			
			OutputStream outputStream = new FileOutputStream(new File(objectFilePath));
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(object);
			objectOutputStream.flush();
			objectOutputStream.close();
			System.out.println("write end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从某个文件中读取对象到内存中(泛型)
	 * @return 
	 */
	public static <T> T readObject(String objectFilePath,Class<T> class1){
		try {
			InputStream inputStream = new FileInputStream(new File(objectFilePath));
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			T resultObject = (T)objectInputStream.readObject();
			System.out.println("read end");
			return resultObject;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static class TestUser implements Serializable{
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
		private String name;
		private int age;
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}
		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}
		
	}
	
}
