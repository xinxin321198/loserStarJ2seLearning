/**
 * author: loserStar
 * date: 2018年3月13日上午10:41:07
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: loserStar
 * date: 2018年3月13日上午10:41:07
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
public class LoserStarFile {
	public static void main(String[] args) {
		try {
			System.out.println(File.pathSeparator);//多路径分隔符
			System.out.println(File.separator);//目录分隔符
			File file = new File("test.txt");
			System.out.println(file.getName());//名称
			System.out.println(file.getPath());//返回内存中文件的，如果是绝对路径就返回绝对路径，否则返回相对路径
			System.out.println(file.getAbsolutePath());//返回绝对路径
			System.out.println(file.getParent());//返回内存中文件的上一级目录，如果没有上级返回null
			
			System.out.println(file.exists());//文件是否存在
			System.out.println(file.canRead());//是否克读
			System.out.println(file.canWrite());//是否可写
			System.out.println(file.isFile());//是否是文件
			System.out.println(file.isDirectory());//是否是目录
			System.out.println(file.length());//文件字节数
			
			file.createNewFile();//创建文件
//			file.delete();//删除文件
			File temp = file.createTempFile("temp", ".temp",new File("E:\\loserStarWorkSpace\\loserStarJ2seLeaning"));//创建临时文件，程序退出自动删除
//			Thread.sleep(5000);
			temp.deleteOnExit();//退出时删除文件
			System.out.println("程序退出");
			
			File dir = new File("dirTest");
			dir.mkdir();//创建目录，必须保证父目录存在
			dir.mkdirs();//创建所有层级的目录
			dir.isDirectory();//目录是否存在
			
			File dir1 = new File("dirTest/a");
			File dir2 = new File("dirTest/b");
			File dir3 = new File("dirTest/c");
			dir1.mkdirs();
			dir2.mkdirs();
			dir3.mkdirs();
			System.out.println(Arrays.asList(dir.list()).toString());//返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
			System.out.println(Arrays.asList(dir.listFiles()).toString());//  返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
			System.out.println(Arrays.asList(File.listRoots()).toString());//所有盘符
			System.out.println("递归遍历一个目录");
			StringBuffer outDirStr = new StringBuffer();
			LoopPringFile("E:\\Docker Toolbox",outDirStr);
			Writer writer = new FileWriter(new File("c:\\outDirStr.txt"));
			writer.write(outDirStr.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 遍历一个路径（深度优先）
	 *
	 * @param path
	 */
	public static void LoopPringFile(String path,StringBuffer outStr){
		File file = new File(path);
		if (!file.isDirectory()||!file.exists()) {
			return;
		}
		File[] files = file.listFiles();
		for (File file2 : files) {
			outStr.append("\r\n");
			outStr.append(file2.getPath());
			System.out.println(file2.getPath());
			LoopPringFile(file2.getAbsolutePath(),outStr);
		}
	}
}

