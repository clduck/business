package com.business.control;

import java.io.File;
import java.io.IOException;
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
import com.business.model.MemGroup;
import com.business.model.NewsInfo;
import com.business.model.NewsType;
import com.business.model.common.RetMsg;
import com.business.service.NewsInfoService;
import com.business.service.NewsTypeService;
import com.business.util.DateUtils;
import com.business.util.common.ConstConfig;
import com.business.util.file.FileHelper;
import com.business.util.file.MultipartFileValidator;
import com.business.util.tree.EasyUITreeBean;

@Controller
public class NewsController {
	private static Log logger = LogFactory.getLog(NewsController.class);
	@Autowired
	private NewsInfoService newsInfoService;
	@Autowired
	private NewsTypeService newsTypeService;
	@Autowired
	// private MemGroupService memGroupService;
	private MemGroupDao memGroupDao;

	public void setMemGroupDao(MemGroupDao memGroupDao) {
		this.memGroupDao = memGroupDao;
	}

	@RequestMapping(value = "/admin/news.do", params = "method=getNewsInfos")
	@ResponseBody
	public CommonObject getnewsInfos(HttpServletRequest request,
			ModelMap modelMap) {

		logger.info("=========获取新闻信息=========");
		logger.info("=========当前页码 page   :" + request.getParameter("page"));
		logger.info("=========当前页记录数rows   :" + request.getParameter("rows"));
		String page = request.getParameter("page");
		String num = request.getParameter("rows");

		CommonObject news = null;
		try {
			news = newsInfoService.getNewsInfos(new NewsInfo(),
					(Integer.parseInt(page) - 1) * Integer.parseInt(num),
					Integer.parseInt(num));
		} catch (Exception e) {
			logger.error("获取新闻信息异常：" + e.getMessage());
		}
		return news;
	}

	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description : 初始化新闻信息
	 * @return : ModelAndView
	 * 
	 */
	@RequestMapping(value = "/admin/newsInfo.do", params = "method=initNewsInfo")
	public ModelAndView initnewsInfo(HttpServletRequest request,
			ModelMap modelMap) {
		logger.info("===========初始化新闻详细信息===========");
		logger.info("===========信息ID ： " + request.getParameter("newsID"));
		String newsID = request.getParameter("newsID");
		NewsInfo newsInfo = null;
		List<MemGroup> memGroups = null;
		String saveType = "";
		try {
			memGroups = memGroupDao.queryMemGroup(new MemGroup());
		} catch (Exception e) {
			logger.info("初始化新闻详细信息--获取群组信息失败:" + e.getMessage());
			e.printStackTrace();
		}
		if (newsID != null && !"".equals(newsID)) {
			saveType = "modifyNewsInfo";
			NewsInfo newsInfoParam = new NewsInfo();
			try {
				newsInfoParam.setNewsID(Integer.parseInt(newsID));
				newsInfo = newsInfoService.getNewsInfo(newsInfoParam);
			} catch (Exception e) {
				logger.error("初始化新闻详细信息失败：" + e.getMessage());
			}
		} else {
			saveType = "saveNewsInfo";
			newsInfo = new NewsInfo();
			newsInfo.setViewFlag(1);
		}
		modelMap.put("newsInfo", newsInfo);
		modelMap.put("memGroups", memGroups);
		modelMap.put("submitMethod", saveType);
		return new ModelAndView("newsInfo");
	}

	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description : 添加新闻信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/newsInfo.do", params = "method=saveNewsInfo")
	public void saveNewsInfo(HttpServletRequest request,
			HttpServletResponse response, NewsInfo newsInfoParam) {
		logger.info("=============添加新闻信息=============");
		logger.info("新闻信息参数 =========newsInfoParam : " + newsInfoParam);
		boolean flag = false;
		try {
			newsInfoParam.setAddTime(DateUtils.strFormateDate(DateUtils
					.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),
					ConstConfig.DATE_FULL_FORMAT));
			newsInfoParam.setClickNumber(0);
			newsInfoParam.setStatus(0);
			newsInfoParam.setNoticeFlag(newsInfoParam.getNoticeFlag()==null?1:0);
			newsInfoParam.setPictureFlag(newsInfoParam.getPictureFlag()==null?1:0);
			newsInfoParam.setViewFlag(newsInfoParam.getViewFlag()==null?1:0);
			
			newsInfoService.insertNewsInfo(newsInfoParam);
			flag = true;
		} catch (Exception e) {
			logger.error("保存新闻信息失败：" + e.getMessage());
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
	 * @description : 修改新闻信息
	 * @return : ModelAndView
	 * 
	 */
	@RequestMapping(value = "/admin/newsInfo.do", params = "method=modifyNewsInfo")
	public void modifynewsInfo(HttpServletRequest request,
			HttpServletResponse response, NewsInfo newsInfoParam) {
		logger.info("=============修改新闻信息=============");
		logger.info("新闻信息参数 =========newsInfoParam : " + newsInfoParam);
		boolean flag = false;
		try {
			newsInfoParam.setNoticeFlag(newsInfoParam.getNoticeFlag()==null?1:0);
			newsInfoParam.setPictureFlag(newsInfoParam.getPictureFlag()==null?1:0);
			newsInfoParam.setViewFlag(newsInfoParam.getViewFlag()==null?1:0);
			
			newsInfoService.modifyNewsInfo(newsInfoParam);
			flag = true;

		} catch (Exception e) {
			logger.error("修改新闻信息失败: " + e.getMessage());
		}
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @time : 2012-1-30
	 * @author :cl
	 * @description : 删除新闻信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/newsInfo.do", params = "method=deleteNewsInfo")
	public void deletenewsInfo(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("=============删除新闻信息=============");
		boolean flag = false;
		String json = request.getParameter("newsInfoParams");
		logger.info("========参数newsInfoParams :" + json);
		JSONArray jsonArray = JSONArray.fromObject(json);
		List<NewsInfo> newsInfoParams = (List<NewsInfo>) JSONArray
				.toCollection(jsonArray, NewsInfo.class);
		List<Integer> Ids = new ArrayList<Integer>();
		for (int i = 0; i < newsInfoParams.size(); i++) {
			Ids.add(newsInfoParams.get(i).getNewsID());
		}
		try {
			newsInfoService.deleteNewsInfo(Ids);
			flag = true;
		} catch (Exception e) {
			logger.error("========删除新闻信息失败=========" + e.getMessage());
		}
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @time : 2012-2-2
	 * @author :cl
	 * @description : 获取新闻类型树型数据
	 * @return : String
	 * 
	 */
	@RequestMapping(value = "/admin/newsType.do", params = "method=getNewsTypes")
	@ResponseBody
	public List<EasyUITreeBean> getNewsTypes(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("==============获取新闻类型列表数据===========");
		String treeData = "";
		List<EasyUITreeBean> beans = null;
		try {
			beans = newsTypeService.getNewsTypeTreeData();
			// treeData = JSONArray.fromObject(beans).toString();
			logger.info("===========新闻类型树 treeData ：  "
					+ JSONArray.fromObject(beans).toString());
		} catch (Exception e) {
			logger.error("==========获取新闻类型列表数据失败  ： " + e.getLocalizedMessage());
		}
		return beans;
	}

	/**
	 * 
	 * @time : 2012-2-3
	 * @author :cl
	 * @description :
	 * @return : void
	 * 
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/admin/newsInfo.do", params = "method=uploadImageFile", method = RequestMethod.POST)
	public void uploadImageFile(@RequestParam("imageFile") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("===========上传新闻图片==========");
		logger.info("===============" + file.getOriginalFilename());
        
		RetMsg ret = new RetMsg();
		MultipartFileValidator fileValidator = new MultipartFileValidator();
		fileValidator.setAllowedContentTypes(ConstConfig.IMAGE_FILE_TYPE);
		String filePath = request.getRealPath("/") + ConstConfig.IMAGE_FILE_PATH + "//" + ConstConfig.NEWS_FOLDER+"//";
		logger.info("===========图片路径===========" + filePath);
		String newFileName = "N_image_" + DateUtils.dateFormatStr(new Date(), "yyyyMMddHHmmss")+".jpg";
		try {
			fileValidator.validate(file);
			if (!new File(filePath).isDirectory()) {
				new File(filePath).mkdirs();
			}
			FileHelper.creatFile(filePath + newFileName, file);
			ret.setCode(0);
			ret.setRetobj(ConstConfig.IMAGE_FILE_PATH+"/"+ConstConfig.NEWS_FOLDER+"/"+newFileName);
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
	 * @description : 初始化新闻类型信息
	 * @return : ModelAndView
	 * 
	 */
	@RequestMapping(value = "/admin/newsType.do", params = "method=initNewsType")
	public ModelAndView initnewsType(HttpServletRequest request,HttpServletResponse response,
			ModelMap modelMap) {
		logger.info("===========初始化新闻类型详细信息===========");
		NewsType newsType =  new NewsType();
		modelMap.put("newsType", newsType);
		return new ModelAndView("newsType");
	}
	/**
	 *  
	 *  @time : 2012-2-25 
	 *  @author :cl
	 *  @description : 获取新闻类型信息
	 *  @return : void
	 *
	 */
	@RequestMapping(value="/admin/newsType.do",params = "method=getNewsType")
	public void getNewsType(HttpServletRequest request, HttpServletResponse response){
		logger.info("======= 获取新闻类型信息=========");
		String newsTypeId = request.getParameter("newsTypeId");
		logger.info("======= 传入参数   newsTypeId  ：  "  + newsTypeId);
		NewsType newsType = new NewsType();
		NewsType param = new NewsType();
		RetMsg ret = new RetMsg();
		param.setNewsTypeID(Integer.parseInt(newsTypeId));
		try {
			newsType = newsTypeService.getNewsType(param);
			ret.setRetobj(newsType);
			ret.setCode(0);
		} catch (Exception e) {
			logger.error("获取新闻类型信息失败 : " + e.getMessage());
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
	 * @description : 添加新闻类型信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/newsType.do", params = "method=saveNewsType")
	public void saveNewsType(HttpServletRequest request,
			HttpServletResponse response, NewsType newsTypeParam) {
		
		logger.info("=============添加新闻类型信息=============");
		logger.info("新闻信息参数 =========newsTypeParam : " + newsTypeParam);
		RetMsg ret = new RetMsg();
		try {
			newsTypeParam.setClickNumber(0);
			newsTypeParam.setLeaf(1);
			newsTypeParam.setStatus(0);
			newsTypeParam.setViewFlag(newsTypeParam.getViewFlag() == null? 1:newsTypeParam.getViewFlag());
			newsTypeService.insertNewsType(newsTypeParam);
			ret.setCode(0);
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("保存新闻类型信息失败：" + e.getMessage());
			ret.setCode(-1);
			ret.setMsg("保存新闻类型信息失败");
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
	 * @description : 修改新闻类型信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/newsType.do", params = "method=modifyNewsType")
	public void modifyNewsType(HttpServletRequest request,
			HttpServletResponse response, NewsType newsTypeParam) {
		
		logger.info("=============修改新闻类型信息=============");
		logger.info("新闻信息参数 =========newsTypeParam : " + newsTypeParam);
		RetMsg ret = new RetMsg();
		try {
			newsTypeParam.setViewFlag(newsTypeParam.getViewFlag() == null? 1:newsTypeParam.getViewFlag());
			newsTypeService.modifyNewsType(newsTypeParam);
			ret.setCode(0);
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("修改新闻类型信息失败：" + e.getMessage());
			e.printStackTrace();
			ret.setCode(-1);
			ret.setMsg("修改新闻类型信息失败");
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
	 * @description :删除新闻类型信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/newsType.do", params = "method=deleteNewsType")
	public void deleteNewsType(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Integer id) {
		
		logger.info("=============删除新闻类型信息=============");
		RetMsg ret = new RetMsg();
		try {
			newsTypeService.deleteNewsType(id);
			ret.setCode(0);
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("删除新闻类型信息失败：" + e.getMessage());
			ret.setCode(-1);
			ret.setMsg("删除新闻类型信息失败");
		}
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(JSONObject.fromObject(ret));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
