package com.example.hotel.Util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UploadUtil {
	
	
	private static String fileSavePath;
	
	@Value ("${file-save-path}")
	public void setFileSavePath (String fileSavePath) {
		UploadUtil.fileSavePath = fileSavePath;
	}
	
	/**
	 * 时间格式化
	 */
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy/MM/dd/");
	
	/**
	 * 图片保存路径，自动从yml文件中获取数据
	 * 示例： E:/images/
	 */
	
	public static String uploadFile (MultipartFile file) {
//		String fileSavePath = "D:/img/";
		//1.后半段目录：  2020/03/15
		String directory = simpleDateFormat.format (new Date ());
		/**
		 *  2.文件保存目录  E:/images/2020/03/15/
		 *  如果目录不存在，则创建
		 */
		File dir = new File (fileSavePath + directory);
		if (! dir.exists ()) {
			dir.mkdirs ();
		}
		System.out.println ("图片上传，保存位置：" + fileSavePath + directory);
		//3.给文件重新设置一个名字
		//后缀
		String suffix = file.getOriginalFilename ().substring (file.getOriginalFilename ().lastIndexOf ("."));
		
		// 创建 SimpleDateFormat 对象，指定日期格式为时分秒毫秒
		SimpleDateFormat sdf = new SimpleDateFormat ("HHmmssSSS");
		
		String newFileName = sdf.format (new Date ()) + suffix;
		//4.创建这个新文件
		File newFile = new File (fileSavePath + directory + newFileName);
		//5.复制操作
		try {
			file.transferTo (newFile);
			//协议 :// ip地址 ：端口号 / 文件目录(/images/2020/03/15/xxx.jpg)
			String url = directory + newFileName;
			System.out.println ("图片上传，访问URL：" + url);
			return url;
		} catch (IOException e) {
			System.out.println (e);
			return null;
		}
	}
	
	public static boolean deleteFile (String file) {
		File delFile = new File (fileSavePath + file);
		if (delFile.isFile () && delFile.exists ()) {
			System.out.println (delFile);
			delFile.delete ();
			return true;
		}
		else {
			return false;
		}
	}
}