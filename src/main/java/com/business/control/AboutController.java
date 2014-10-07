package com.business.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.business.mgr.adminMgr.MemGroupDao;
import com.business.model.AboutInfo;
import com.business.model.common.RetMsg;
import com.business.service.IAboutInfoService;
import com.business.util.DateUtils;
import com.business.util.common.ConstConfig;
import com.business.util.page.PageEntity;
import com.business.util.page.PagingResult;
import com.business.util.property.MyDateEditor;

@Controller
@RequestMapping(value = "/aboutInfo")
public class AboutController {
	private final Log logger  = LogFactory.getLog(AboutController.class);
	private static String PROJECT_MODEL = "aboutInfo";
	@Autowired
	private IAboutInfoService aboutInfoService;
	@Autowired
	//private MemGroupService  memGroupService;
	private MemGroupDao memGroupDao;
	
	public void setMemGroupDao(MemGroupDao memGroupDao) {
		this.memGroupDao = memGroupDao;
	}
	
    /**
     * 初始化首页
     * @param modelMap
     * @return
     */
	@RequestMapping(value = "/do")
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
		logger.info("=========初始化首页=========");
		String outpath = "/" + PROJECT_MODEL + "/aboutInfo_main";
		return new ModelAndView(outpath, modelMap);
	}
    /**
     * 初始化新增页面
     * @param modelMap
     * @return
     */
	@RequestMapping(value = "/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
		logger.info("=========初始化新增界面=========");
		String outpath = "/" + PROJECT_MODEL + "/aboutInfo_add";
		return new ModelAndView(outpath, modelMap);
	}
    /**
     * 初始化编辑页面
     * @param modelMap
     * @return
     */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
		logger.info("=========初始化编辑界面=========");
		String outpath = "/" + PROJECT_MODEL + "/aboutInfo_edit";
		Map<String ,Object> requestMap = request.getParameterMap();
		for (String key : requestMap.keySet()) {
			modelMap.put(key,  ((String[])requestMap.get(key))[0]);
		}
		return new ModelAndView(outpath, modelMap);
	}
	@ResponseBody
	@RequestMapping(value = "/getPages")
	public Map<String, Object> getPages(HttpServletRequest request,HttpServletResponse response,AboutInfo param) {
		
		logger.info("=========获取企业信息=========");
		String pageNo = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		
		logger.info("=========当前页码 pageNo   :" + pageNo);
		logger.info("=========当前页记录数pageSize   :" + pageSize);
		
		PageEntity<AboutInfo> pager = new PageEntity<AboutInfo>();
		pager.setPageNo(Integer.parseInt(pageNo));
		pager.setPageSize(Integer.parseInt(pageSize));
		
		PagingResult<AboutInfo> abouts = null;
		try {
			pager.setT(param);
			abouts = aboutInfoService.getPages(pager);
		} catch (Exception e) {
			logger.error("获取企业信息异常："+e.getMessage());
		}
		
		HashMap<String, Object>  results  = new HashMap<String, Object>();
		results.put("pager.pageNo", abouts.getPager().getPageNo());
		results.put("pager.totalRows", abouts.getPager().getTotalRows());
		results.put("rows", abouts.getRows());
		results.put("sort", abouts.getSort());
		results.put("direction", abouts.getDirection());
		
		return results;
	}
	/**
	 * 
	 *  @time : 2012-1-28 
	 *  @author :cl
	 *  @description : 添加企业信息
	 *  @return : void
	 *
	 */
	@RequestMapping(value="saveAboutInfo", method = RequestMethod.POST)
	public ResponseEntity<RetMsg> saveAboutInfo(HttpServletRequest request,HttpServletResponse response,AboutInfo param){
		logger.info("=============添加企业信息=============");
		logger.info("企业信息参数 =========aboutInfoParam : "  + param);
		RetMsg ret = new RetMsg();
		try {
//			 param.setAddTime(DateUtils.strFormateDate(DateUtils.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),ConstConfig.DATE_FULL_FORMAT));
//			 param.setUpdateTime(DateUtils.strFormateDate(DateUtils.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),ConstConfig.DATE_FULL_FORMAT));
//			 param.setClickNumber(0);
//		     param.setSequence(0);
//		     param.setChildFlag(0);
//		     param.setStatus(0);
//		     param.setParentID(0);
//		     param.setSortPath("0");
		     
			 aboutInfoService.insertObject(param);
 		     ret.setCode(0);
 		     ret.setMsg("保存成功！") ;
		} catch (Exception e) {
			logger.error("保存信息失败：" + e.getMessage());
			ret.setCode(-1);
			ret.setMsg("保存信息失败：" + e.getMessage());
		}
		return new ResponseEntity<RetMsg>( ret ,HttpStatus.OK);
	}
	/**
	 * 
	 *  @time : 2012-1-28 
	 *  @author :cl
	 *  @description : 修改企业信息
	 *  @return : ModelAndView
	 *
	 */
	@RequestMapping(value="/admin/aboutInfo.do",params="method=modifyAboutInfo")
	public void modifyAboutInfo(HttpServletRequest request,HttpServletResponse response,AboutInfo aboutInfoParam){
		logger.info("=============修改企业信息=============");
		logger.info("企业信息参数 =========aboutInfoParam : "  + aboutInfoParam);
		boolean flag = false;
		try {
			aboutInfoParam.setUpdateTime(DateUtils.strFormateDate(DateUtils.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),ConstConfig.DATE_FULL_FORMAT));
		    aboutInfoService.modifyObject(aboutInfoParam);
		    flag = true;
		    
		} catch (Exception e) {
			logger.error("修改企业信息失败: " + e.getMessage());
		}
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除企业信息
	 *  @return : void
	 *
	 */
	@RequestMapping(value="/admin/aboutInfo.do",params="method=deleteAboutInfo")
	public void deleteAboutInfo(HttpServletRequest request, HttpServletResponse response){
		logger.info("=============删除企业信息=============");
		boolean flag = false;
		String json = request.getParameter("aboutInfoParams");
		logger.info("========参数aboutInfoParams :" + json);
		JSONArray jsonArray = JSONArray.fromObject(json);
		List<AboutInfo> aboutInfoParams =  (List<AboutInfo>) JSONArray.toCollection(jsonArray, AboutInfo.class);
		List<Long> Ids = new ArrayList<Long>();
		for (int i = 0; i < aboutInfoParams.size(); i++) {
			Ids.add(Long.parseLong(aboutInfoParams.get(i).getAboutID().toString()));
		}
		try {
			aboutInfoService.deleteBatch(Ids);
			flag = true;
		} catch (Exception e) {
			logger.error("========删除企业信息失败=========" + e.getMessage());
		}
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, new MyDateEditor());
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy"), true));
	}
}
