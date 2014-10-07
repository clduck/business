package com.business.control;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.business.mgr.adminMgr.MemGroupDao;
import com.business.model.CommonObject;
import com.business.model.DownloadInfo;
import com.business.model.DownloadType;
import com.business.model.MemGroup;
import com.business.model.common.RetMsg;
import com.business.model.param.DownloadParam;
import com.business.service.DownloadInfoService;
import com.business.service.DownloadTypeService;
import com.business.util.DateUtils;
import com.business.util.common.ConstConfig;
import com.business.util.file.FileHelper;
import com.business.util.file.MultipartFileValidator;
import com.business.util.tree.EasyUITreeBean;

@Controller
public class DownloadController {
	private static Log logger = LogFactory.getLog(DownloadController.class);
	@Autowired
	private DownloadInfoService downloadInfoService;
	@Autowired
	private DownloadTypeService downloadTypeService;
	@Autowired
	private MemGroupDao memGroupDao;
	
	public void setMemGroupDao(MemGroupDao memGroupDao) {
		this.memGroupDao = memGroupDao;
	}
	private final float MIN_SIZE = (float) 1024.00;
	private final float MAX_SIZE = (float) (1048576.00);

	@RequestMapping(value = "/admin/download.do", params = "method=getDownloadInfos")
	@ResponseBody
	public CommonObject getDownloadfos(HttpServletRequest request,DownloadParam downloadParam) {

		logger.info("=========获取下载列表信息=========");
		logger.info("=========当前页码 page   :" + request.getParameter("page"));
		logger.info("=========当前页记录数rows   :" + request.getParameter("rows"));
		String page = request.getParameter("page");
		String num = request.getParameter("rows");
		
		downloadParam.setEndTime("".equals(downloadParam.getEndTime())?null:downloadParam.getEndTime());
		downloadParam.setStartTime("".equals(downloadParam.getStartTime())?null:downloadParam.getStartTime());
		
		CommonObject downloads = null;
		try {
			downloads = downloadInfoService.getDownloadInfos(downloadParam,
					(Integer.parseInt(page) - 1) * Integer.parseInt(num),
					Integer.parseInt(num));
		} catch (Exception e) {
			logger.error("获取下载信息异常：" + e.getMessage());
			e.printStackTrace();
		}
		return downloads;
	}
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description :删除下载信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/download.do", params = "method=deleteDownloads")
	public void deleteDownloads(HttpServletRequest request,
			HttpServletResponse response) {
		
		logger.info("=============删除下载信息=============");
		RetMsg ret = new RetMsg();
		String json = request.getParameter("downloadParams");
		logger.info("========参数downloadParams :" + json);
		JSONArray jsonArray = JSONArray.fromObject(json);
		List<DownloadInfo> downloadParams = (List<DownloadInfo>) JSONArray.toCollection(jsonArray, DownloadInfo.class);
		List<Integer> Ids = new ArrayList<Integer>();
		for (int i = 0; i < downloadParams.size(); i++) {
			Ids.add(downloadParams.get(i).getDownloadID());
		}
		try {
			downloadInfoService.deleteDownloadInfo(Ids);
			ret.setCode(0);
			ret.setMsg("删除下载信息成功");
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("删除下载信息失败：" + e.getMessage());
			ret.setCode(-1);
			ret.setMsg("删除下载信息失败,请联系管理员");
		}
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(JSONObject.fromObject(ret));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @time : 2012-04-30
	 * @author :cl
	 * @description : 获取下载类型树型数据
	 * @return : String
	 * 
	 */
	@RequestMapping(value = "/admin/downloadType.do", params = "method=getDownloadTypes")
	@ResponseBody
	public List<EasyUITreeBean> getDownloadTypes(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("==============获取下载类型列表数据===========");
		String treeData = "";
		List<EasyUITreeBean> beans = null;
		try {
			beans = downloadTypeService.getDownloadTypeTreeData();
			// treeData = JSONArray.fromObject(beans).toString();
			logger.info("===========下载类型树 treeData ：  "
					+ JSONArray.fromObject(beans).toString());
		} catch (Exception e) {
			logger.error("==========获取下载类型列表数据失败  ： " + e.getLocalizedMessage());
		}
		return beans;
	}
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description : 初始化下载类型信息
	 * @return : ModelAndView
	 * 
	 */
	@RequestMapping(value = "/admin/downloadType.do", params = "method=initDownloadType")
	public ModelAndView initdownloadType(HttpServletRequest request,HttpServletResponse response,
			ModelMap modelMap) {
		logger.info("===========初始化下载类型详细信息===========");
		DownloadType downloadType =  new DownloadType();
		modelMap.put("downloadType", downloadType);
		return new ModelAndView("download/downloadType");
	}
	/**
	 *  
	 *  @time : 2012-2-25 
	 *  @author :cl
	 *  @description : 获取下载类型信息
	 *  @return : void
	 *
	 */
	@RequestMapping(value="/admin/downloadType.do",params = "method=getDownloadType")
	public void getDownloadType(HttpServletRequest request, HttpServletResponse response){
		logger.info("======= 获取下载类型信息=========");
		String downloadTypeId = request.getParameter("downloadTypeId");
		logger.info("======= 传入参数   downloadTypeId  ：  "  + downloadTypeId);
		DownloadType downloadType = new DownloadType();
		DownloadType param = new DownloadType();
		RetMsg ret = new RetMsg();
		param.setDownloadTypeID(Integer.parseInt(downloadTypeId));
		try {
			downloadType = downloadTypeService.getDownloadType(param);
			ret.setRetobj(downloadType);
			ret.setCode(0);
		} catch (Exception e) {
			logger.error("获取下载类型信息失败 : " + e.getMessage());
			e.printStackTrace();
			ret.setCode(-1);
		}
        try {
        	response.setContentType("text/html;charset=UTF-8");
 			response.getWriter().print(JSONObject.fromObject(ret));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description : 添加下载类型信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/downloadType.do", params = "method=saveDownloadType")
	public void saveDownloadType(HttpServletRequest request,
			HttpServletResponse response, DownloadType downloadTypeParam) {
		
		logger.info("=============添加下载类型信息=============");
		logger.info("下载信息参数 =========downloadTypeParam : " + downloadTypeParam);
		RetMsg ret = new RetMsg();
		try {
			downloadTypeParam.setClickNumber(0);
			downloadTypeParam.setLeaf(1);
			downloadTypeParam.setStatus(0);
			downloadTypeParam.setViewFlag(downloadTypeParam.getViewFlag() == null? 1:downloadTypeParam.getViewFlag());
			downloadTypeParam.setParentID(downloadTypeParam.getParentID()==null?0:downloadTypeParam.getParentID());
			downloadTypeService.insertDownloadType(downloadTypeParam);
			ret.setCode(0);
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("保存下载类型信息失败：" + e.getMessage());
			ret.setCode(-1);
			ret.setMsg("保存下载类型信息失败");
		}
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(JSONObject.fromObject(ret));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description : 修改下载类型信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/downloadType.do", params = "method=modifyDownloadType")
	public void modifyDownloadType(HttpServletRequest request,
			HttpServletResponse response, DownloadType downloadTypeParam) {
		
		logger.info("=============修改下载类型信息=============");
		logger.info("下载信息参数 =========downloadTypeParam : " + downloadTypeParam);
		RetMsg ret = new RetMsg();
		try {
			downloadTypeParam.setViewFlag(downloadTypeParam.getViewFlag() == null? 1:downloadTypeParam.getViewFlag());
			downloadTypeService.modifyDownloadType(downloadTypeParam);
			ret.setCode(0);
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("修改下载类型信息失败：" + e.getMessage());
			e.printStackTrace();
			ret.setCode(-1);
			ret.setMsg("修改下载类型信息失败");
		}
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(JSONObject.fromObject(ret));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description :删除下载类型信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/downloadType.do", params = "method=deleteDownloadType")
	public void deleteDownloadType(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Integer id) {
		
		logger.info("=============删除下载类型信息=============");
		RetMsg ret = new RetMsg();
		try {
			downloadTypeService.deleteDownloadType(id);
			ret.setCode(0);
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("删除下载类型信息失败：" + e.getMessage());
			ret.setCode(-1);
			ret.setMsg("删除下载类型信息失败");
		}
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(JSONObject.fromObject(ret));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @time : 2012-2-3
	 * @author :cl
	 * @description :
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/download.do", params = "method=uploadFile", method = RequestMethod.POST)
	public void uploadImageFile(@RequestParam("imageFile") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("===========上传下载附件==========");
		logger.info("===============" + file.getOriginalFilename());
		RetMsg ret = new RetMsg();
		try {
			
			MultipartFileValidator fileValidator = new MultipartFileValidator();
			fileValidator.setAllowedContentTypes(ConstConfig.FILE_TYPE);
			fileValidator.validate(file);
			String filePath = request.getRealPath("/") + ConstConfig.FILE_PATH + "//";
			logger.info("===========附件路径===========" + filePath);
			String newFileName =  file.getOriginalFilename();
			String  size = "";
			DecimalFormat   df =new DecimalFormat("#.##");   
			if (file.getSize() < MIN_SIZE ) {
				size = file.getSize()+ "bit";
			}else if (file.getSize() >= MIN_SIZE && file.getSize() < MAX_SIZE){
				size = df.format(file.getSize()/MIN_SIZE) +"KB";
			}else if(file.getSize() >= MAX_SIZE){
				size = df.format(file.getSize()/MAX_SIZE) + "MB";
			}
			if (!new File(filePath).isDirectory()) {
				new File(filePath).mkdirs();
			}
			FileHelper.creatFile(filePath + newFileName, file);
			List list = new ArrayList();
			list.add(size);
			ret.setRetlist(list);
			ret.setCode(0);
			ret.setRetobj("/"+ConstConfig.FILE_PATH+"/"+newFileName);
			ret.setMsg("上传成功!");
		} catch (Exception e) {
			ret.setCode(-1);
			ret.setMsg("上传失败 ：" + e.getMessage());
		}
        try {
           response.setContentType("text/html;charset=UTF-8");
		   response.getWriter().print(JSONObject.fromObject(ret));
		} catch (IOException e) {
		}
	}
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description : 初始化下载信息
	 * @return : ModelAndView
	 * 
	 */
	@RequestMapping(value = "/admin/download.do", params = "method=initDownloadInfo")
	public ModelAndView initdownloadInfo(HttpServletRequest request,
			ModelMap modelMap) {
		logger.info("===========初始化下载详细信息===========");
		logger.info("===========信息ID ： " + request.getParameter("downloadID"));
		String downloadID = request.getParameter("downloadID");
		DownloadInfo downloadInfo = null;
		List<MemGroup> memGroups = null;
		String saveType = "";
		try {
			memGroups = memGroupDao.queryMemGroup(new MemGroup());
		} catch (Exception e) {
			logger.info("初始化下载详细信息--获取群组信息失败:" + e.getMessage());
			e.printStackTrace();
		}
		if (downloadID != null && !"".equals(downloadID)) {
			saveType = "modifyDownloadInfo";
			DownloadInfo downloadInfoParam = new DownloadInfo();
			try {
				downloadInfoParam.setDownloadID(Integer.parseInt(downloadID));
				downloadInfo = downloadInfoService.getDownloadInfo(downloadInfoParam);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("初始化下载详细信息失败：" + e.getMessage());
			}
		} else {
			saveType = "saveDownloadInfo";
			downloadInfo = new DownloadInfo();
			downloadInfo.setViewFlag(1);
		}
		modelMap.put("downloadInfo", downloadInfo);
		modelMap.put("memGroups", memGroups);
		modelMap.put("submitMethod", saveType);
		return new ModelAndView("download/downloadInfo");
	}	
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description : 添加下载信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/download.do", params = "method=saveDownloadInfo")
	public void saveInfo(HttpServletRequest request,
			HttpServletResponse response, DownloadInfo downloadInfoParam) {
		logger.info("=============添加下载信息=============");
		logger.info("下载信息参数 =========downloadInfoParam : " + downloadInfoParam);
		boolean flag = false;
		try {
			downloadInfoParam.setAddTime(DateUtils.strFormateDate(DateUtils
					.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),
					ConstConfig.DATE_FULL_FORMAT));
			downloadInfoParam.setUpdateTime(DateUtils.strFormateDate(DateUtils
					.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),
					ConstConfig.DATE_FULL_FORMAT));
			
			downloadInfoParam.setClickNumber(0);
			downloadInfoParam.setCommendFlag(downloadInfoParam.getCommendFlag()==null?1:0);
			downloadInfoParam.setViewFlag(downloadInfoParam.getViewFlag()==null?1:0);
			
			downloadInfoService.insertDownloadInfo(downloadInfoParam);
			flag = true;
		} catch (Exception e) {
			logger.error("保存下载信息失败：" + e.getMessage());
			e.printStackTrace();
			flag = false;
		}
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description : 修改下载信息
	 * @return : ModelAndView
	 * 
	 */
	@RequestMapping(value = "/admin/download.do", params = "method=modifyDownloadInfo")
	public void modifydownloadInfo(HttpServletRequest request,
			HttpServletResponse response, DownloadInfo downloadInfoParam) {
		logger.info("=============修改下载信息=============");
		logger.info("下载信息参数 =========downloadInfoParam : " + downloadInfoParam);
		boolean flag = false;
		try {
			downloadInfoParam.setCommendFlag(downloadInfoParam.getCommendFlag()==null?1:0);
			downloadInfoParam.setViewFlag(downloadInfoParam.getViewFlag()==null?1:0);
			downloadInfoParam.setUpdateTime(DateUtils.strFormateDate(DateUtils
					.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),
					ConstConfig.DATE_FULL_FORMAT));
			downloadInfoService.modifyDownloadInfo(downloadInfoParam);
			flag = true;

		} catch (Exception e) {
			logger.error("修改下载信息失败: " + e.getMessage());
			e.printStackTrace();
		}
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		float a = (float) (12345435/1048576.00);
		DecimalFormat   df=new DecimalFormat("#.##");   
		System.out.println(df.format(a));
	
		  double   d=3.14159;   
		  System.out.println(df.format(d)); 


	}
}
