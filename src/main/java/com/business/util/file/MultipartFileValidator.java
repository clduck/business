package com.business.util.file;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户文件上传验证类
 * 
 * @author Jacky Lau created at 2008-8-27
 * @since 1.0
 * @version 1.0
 */
public class MultipartFileValidator {

	private final static long MAX_SIZE = 1024 * 1024;
	private static Log logger = LogFactory.getLog(MultipartFileValidator.class);

	/**
	 * 文件大小上限
	 */
	private long maxSize = MAX_SIZE;

	/**
	 * 可接受的文件content-type
	 */
	private String[] allowedContentTypes;

	/**
	 * 验证上传文件是否合法，如果不合法那么会抛出异常
	 * 
	 * @param file
	 *            用户上传的文件封装类
	 * @throws Exception
	 */
	public  void validate(MultipartFile file) throws Exception {
		try {
			if (file.getSize() > this.maxSize) {
				logger.debug("======上传的文件超过了最大值====");
				throw new Exception("上传的文件超过了最大值 1M");
			}
			String fileName = file.getOriginalFilename();
			String fileType = fileName.substring(fileName.indexOf(".")+1,fileName.length());

			if (!ArrayUtils.contains(allowedContentTypes, fileType)) {
	             logger.debug("===不是所允许的类型=====");
	             throw new Exception("不是所允许的类型");
			};
		} catch (Exception e) {
			logger.debug("====校验文件失败： " + e.getMessage());
			throw e;
		}
	}

	/**
	 * 设置文件上传大小上限
	 * 
	 * @param maxSize
	 *            文件上传大小上限
	 */
	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * 设置可接受的文件content-type数组
	 * 
	 * @param allowedContentTypes
	 *            可接受的文件content-type数组
	 */
	public void setAllowedContentTypes(String[] allowedContentTypes) {
		this.allowedContentTypes = allowedContentTypes;
	}

}