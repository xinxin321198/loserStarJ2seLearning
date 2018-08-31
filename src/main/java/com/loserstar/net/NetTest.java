/**
 * author: loserStar
 * date: 2018年8月30日下午4:34:49
 * email:362527240@qq.com
 * github:https://github.com/xinxin321198
 * remarks:
 */
package com.loserstar.net;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

import com.loserstar.io.LoserStarIo;
import com.loserstar.utils.LoserStarFileUtil;

/**
 * author: loserStar
 * date: 2018年8月30日下午4:34:49
 * remarks:
 */
public class NetTest {
	
	public static void main(String[] args) {
		try {
			System.out.println("------返回本机的地址和ip---------");
			InetAddress inetAddress = InetAddress.getLocalHost();//返回本机地址对象
			System.out.println(inetAddress.getHostName());//返回机器名称
			System.out.println(inetAddress.getHostAddress());//返回机器ip地址
			
//			InetAddress inetAddres2 = InetAddress.getByName("10.96.66.23");//返回一个域名或ip的地址对象
//			System.out.println(inetAddres2.getHostName());//返回ip
//			System.out.println(inetAddres2.getHostAddress());//返回机器ip地址，如果dns解析，返回域名，不解析返回ip
			
			
			System.out.println("------返回百度的地址和ip---------");
			InetAddress inetAddres3= InetAddress.getByName("www.baidu.com");//返回一个域名或ip的地址对象
			System.out.println(inetAddres3.getHostName());//返回百度的域名
			System.out.println(inetAddres3.getHostAddress());//返回机器ip地址
			
			System.out.println("-----创建一个socket地址---------");
//			InetSocketAddress inetSocketAddress = InetSocketAddress.createUnresolved("127.0.0.1", 8456);
			InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, 8456);
			System.out.println(inetSocketAddress.getPort());
			
			
			System.out.println("-----URL统一资源定位符对象---------");
//			URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=loserstar");
			URL url = new URL("http://www.baidu.com:80/index.html?uname=loserstar");
			System.out.println("协议："+url.getProtocol());
			System.out.println("主机名："+url.getHost());
			System.out.println("端口："+url.getPort());
			System.out.println("资源："+url.getFile());
			System.out.println("相对路径："+url.getPath());
			System.out.println("锚点："+url.getRef());
			System.out.println("参数："+url.getQuery());//存在锚点返回null，不存在才返回参数
			
			System.out.println("-----------获取网络流，并转换为字符串-------------");
			InputStream inputStream = url.openStream();
			String string = new String(LoserStarFileUtil.ReadByteByInputStream(inputStream),Charset.forName("gb2312"));
			System.out.println(string);
			System.out.println("-----------run end------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
