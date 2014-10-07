package com.business.util.file;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description 文件工具类
 * @author cl
 * 
 */
public class FileHelper {

	private static Log logger = LogFactory.getLog(FileHelper.class);
	/**
	 * 
	 * @time : 2012-2-7
	 * @author :cl
	 * @description : 创建文件
	 * @return : void
	 * 
	 */
	public static void creatFile(String filePath, MultipartFile file) {
		try {
			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (file.getSize() > 0) {
				inputStream = file.getInputStream();
				if (file.getSize() > 10000) {
					logger.info("File Size:::" + file.getSize());
				}
				logger.info("size::" + file.getSize());
				outputStream = new FileOutputStream(filePath);

				int readBytes = 0;
				byte[] buffer = new byte[10000];
				while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
