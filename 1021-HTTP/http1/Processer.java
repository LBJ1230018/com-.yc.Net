package http1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Processer {
	public void process(Socket socket){
		InputStream in;
		OutputStream out;
		try{
			in=socket.getInputStream();
			out=socket.getOutputStream();
			//读取请求报文内容
			byte[] buffer=new byte[1024];
			int count;
			count=in.read(buffer);
			String content=new String(buffer,0,count);
			System.out.println(content);
			//解析请求报文（暂未实现）
			HttpServletRequest request =parseRequest(content);
			String suffix=request.getRequestURL().substring(request.getRequestURL().lastIndexOf(".")+1);
			String contentType;
			switch(suffix){
			case "js":
				contentType ="application/x-javascript";
				break;
			case "css":
				contentType ="text/css";
				break;
			case "jpg":
				contentType ="image/jpeg";
				break;
			case "bmp":
				contentType ="image/bmp";
				break;
			case "gif":
				contentType ="image/gif";
				break;
			case "png":
				contentType ="image/png";
				break;
				default:
					contentType ="text/html";
			}
			//定义响应报文内容
			String responseStr="HTTP/1.1 200 OK\r\n";
			responseStr += "Content-Type: "+contentType+"\r\n";
			responseStr += "\r\n";//CRLE 空行			
			out.write(responseStr.getBytes());
			
			
			//根据请求的路劲返回对应文件
			String rootPath="E:/photo";
			String filePath=request.getRequestURL();
			//判断访问文件是否存在
			String diskPath=rootPath + filePath;
			if(new File(diskPath).exists()== false){
				diskPath=rootPath + "/404.html";
			}
			FileInputStream fis=new FileInputStream(diskPath);
			//向浏览器发送报文
			while((count= fis.read(buffer))>0){
			out.write(buffer,0,count);
			
	     }
			fis.close();
			//如果访问的文件不存在，则返回404.html
			
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			socket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//解析请求报文
	public HttpServletRequest parseRequest(String content){
		HttpServletRequest request=new HttpServletRequest(content);
		return request;
	}
}
