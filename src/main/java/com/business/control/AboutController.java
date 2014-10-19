package com.business.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		String id = request.getParameter("id");
		AboutInfo aboutInfo = null;
		try {
			aboutInfo = aboutInfoService.getObject(Long.parseLong(id));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String ,Object> requestMap = request.getParameterMap();
		for (String key : requestMap.keySet()) {
			modelMap.put(key,  ((String[])requestMap.get(key))[0]);
		}
		modelMap.put("aboutInfo",aboutInfo);
		return new ModelAndView(outpath, modelMap);
	}
	@ResponseBody
	@RequestMapping(value = "/getPages")
	public Map<String, Object> getPages(HttpServletRequest request,HttpServletResponse response,AboutInfo param) {
		
		logger.info("=========获取=========");
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
			logger.error("获取异常："+e.getMessage());
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
	 *  @description : 添加
	 *  @return : void
	 *
	 */
	@RequestMapping(value="saveAboutInfo", method = RequestMethod.POST)
	public ResponseEntity<RetMsg> saveAboutInfo(HttpServletRequest request,HttpServletResponse response,AboutInfo param){
		logger.info("=============添加=============");
		logger.info("参数 =========aboutInfoParam : "  + param);
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
	 *  @description : 修改
	 *  @return : ModelAndView
	 *
	 */
	@RequestMapping(value="modifyAboutInfo",method = RequestMethod.POST)
	public ResponseEntity<RetMsg> modifyAboutInfo(HttpServletRequest request,HttpServletResponse response,AboutInfo aboutInfoParam){
		logger.info("=============修改=============");
		logger.info("参数 =========aboutInfoParam : "  + aboutInfoParam);
		RetMsg ret = new RetMsg();
		try {
//			aboutInfoParam.setUpdateTime(DateUtils.strFormateDate(DateUtils.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),ConstConfig.DATE_FULL_FORMAT));
		    aboutInfoService.modifyObject(aboutInfoParam);
            ret.setCode(0);
            ret.setMsg("修改成功！");
		} catch (Exception e) {
			logger.error("修改失败: " + e.getMessage());
			e.printStackTrace();
			ret.setCode(-1);
			ret.setMsg("修改失败：" + e.getMessage());
		}
		return new ResponseEntity<RetMsg>( ret ,HttpStatus.OK);
	}
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除
	 *  @return : void
	 *
	 */
	@RequestMapping(value="deleteAboutInfoBacth",method = RequestMethod.POST)
	public ResponseEntity<RetMsg> deleteAboutInfoBacth(HttpServletRequest request, HttpServletResponse response,AboutInfo aboutInfoParams){
		logger.info("=============批量删除=============");
		RetMsg ret = new RetMsg();
		List<Long> ids = aboutInfoParams.getConditions().getIds();
		try {
			aboutInfoService.deleteBatch(ids);
			ret.setCode(0);
			ret.setMsg("删除成功！");
		} catch (Exception e) {
			ret.setCode(-1);
			ret.setMsg("批量删除失败:" + e.getMessage());
			logger.error("========批量删除失败=========" + e.getMessage());
		}
		return new ResponseEntity<RetMsg>(ret,HttpStatus.OK);
	}
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除
	 *  @return : void
	 *
	 */
	@RequestMapping(value="deleteAboutInfo",method = RequestMethod.POST)
	public ResponseEntity<RetMsg> deleteAboutInfo(HttpServletRequest request, HttpServletResponse response,AboutInfo param){
		logger.info("=============删除=============");
		RetMsg ret = new RetMsg();
		try {
			aboutInfoService.deleteObject(param);
			ret.setCode(0);
			ret.setMsg("删除成功！");
		} catch (Exception e) {
			ret.setCode(-1);
			ret.setMsg("删除失败:" + e.getMessage());
			logger.error("========删除失败=========" + e.getMessage());
		}
		return new ResponseEntity<RetMsg>(ret,HttpStatus.OK);
	}
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, new MyDateEditor());
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy"), true));
	}
}
