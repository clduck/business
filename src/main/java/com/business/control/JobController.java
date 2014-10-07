package com.business.control;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.business.mgr.adminMgr.MemGroupDao;
import com.business.model.CommonObject;
import com.business.model.JobInfo;
import com.business.model.common.RetMsg;
import com.business.model.param.JobInfoParam;
import com.business.service.JobInfoService;
import com.business.util.DateUtils;
import com.business.util.common.ConstConfig;

@Controller
public class JobController {
	private static Log logger = LogFactory.getLog(JobController.class);
	@Autowired
	private JobInfoService jobInfoService;
	@Autowired
	private MemGroupDao memGroupDao;

	public void setMemGroupDao(MemGroupDao memGroupDao) {
		this.memGroupDao = memGroupDao;
	}
	@RequestMapping(value = "/admin/job.do", params = "method=getJobInfos")
	@ResponseBody
	public CommonObject getJobfos(HttpServletRequest request,JobInfoParam jobParam) {

		logger.info("=========获取招聘列表信息=========");
		logger.info("=========当前页码 page   :" + request.getParameter("page"));
		logger.info("=========当前页记录数rows   :" + request.getParameter("rows"));
		String page = request.getParameter("page");
		String num = request.getParameter("rows");
		
		jobParam.setEndTime("".equals(jobParam.getEndTime())?null:jobParam.getEndTime());
		jobParam.setStartTime("".equals(jobParam.getStartTime())?null:jobParam.getStartTime());
		
		CommonObject jobs = null;
		try {
			jobs = jobInfoService.getJobInfos(jobParam,
					(Integer.parseInt(page) - 1) * Integer.parseInt(num),
					Integer.parseInt(num));
		} catch (Exception e) {
			logger.error("获取招聘信息异常：" + e.getMessage());
			e.printStackTrace();
		}
		return jobs;
	}
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description :删除招聘信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/job.do", params = "method=deleteJobs")
	public void deleteJobs(HttpServletRequest request,
			HttpServletResponse response) {
		
		logger.info("=============删除招聘信息=============");
		RetMsg ret = new RetMsg();
		String json = request.getParameter("jobParams");
		logger.info("========参数jobParams :" + json);
		JSONArray jsonArray = JSONArray.fromObject(json);
		List<JobInfo> jobParams = (List<JobInfo>) JSONArray.toCollection(jsonArray, JobInfo.class);
		List<Integer> Ids = new ArrayList<Integer>();
		for (int i = 0; i < jobParams.size(); i++) {
			Ids.add(jobParams.get(i).getJobID());
		}
		try {
			jobInfoService.deleteJobInfo(Ids);
			ret.setCode(0);
			ret.setMsg("删除招聘信息成功");
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("删除招聘信息失败：" + e.getMessage());
			ret.setCode(-1);
			ret.setMsg("删除招聘信息失败,请联系管理员");
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
	 * @description : 初始化招聘信息
	 * @return : ModelAndView
	 * 
	 */
	@RequestMapping(value = "/admin/job.do", params = "method=initJobInfo")
	public ModelAndView initjobInfo(HttpServletRequest request,
			ModelMap modelMap) {
		logger.info("===========初始化招聘详细信息===========");
		logger.info("===========信息ID ： " + request.getParameter("jobID"));
		String jobID = request.getParameter("jobID");
		JobInfo jobInfo = null;
		String saveType = "";
		if (jobID != null && !"".equals(jobID)) {
			saveType = "modifyJobInfo";
			JobInfo jobInfoParam = new JobInfo();
			try {
				jobInfoParam.setJobID(Integer.parseInt(jobID));
				jobInfo = jobInfoService.getJobInfo(jobInfoParam);
			} catch (Exception e) {
				logger.error("初始化招聘详细信息失败：" + e.getMessage());
			}
		} else {
			saveType = "saveJobInfo";
			jobInfo = new JobInfo();
			jobInfo.setViewFlag(1);
		}
		modelMap.put("jobInfo", jobInfo);
		modelMap.put("submitMethod", saveType);
		return new ModelAndView("job/jobInfo");
	}	
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description : 添加招聘信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/job.do", params = "method=saveJobInfo")
	public void saveInfo(HttpServletRequest request,
			HttpServletResponse response, JobInfo jobInfoParam) {
		logger.info("=============添加招聘信息=============");
		logger.info("招聘信息参数 =========jobInfoParam : " + jobInfoParam);
		String startDateStr = request.getParameter("startDateStr");
		String endDateStr = request.getParameter("endDateStr");
		boolean flag = false;
		try {
			jobInfoParam.setAddTime(DateUtils.strFormateDate(DateUtils.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),
					ConstConfig.DATE_FULL_FORMAT));
			jobInfoParam.setStartDate(DateUtils.strFormateDate(startDateStr,ConstConfig.DATE_SIMP_FORMAT));
			jobInfoParam.setEndDate(DateUtils.strFormateDate(endDateStr,ConstConfig.DATE_SIMP_FORMAT));
			
			jobInfoParam.setClickNumber(0);
			jobInfoParam.setStatus(0);
			jobInfoParam.setApply(0);
			jobInfoParam.setViewFlag(jobInfoParam.getViewFlag()==null?1:0);
			
			jobInfoService.insertJobInfo(jobInfoParam);
			flag = true;
		} catch (Exception e) {
			logger.error("保存招聘信息失败：" + e.getMessage());
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
	 * @description : 修改招聘信息
	 * @return : ModelAndView
	 * 
	 */
	@RequestMapping(value = "/admin/job.do", params = "method=modifyJobInfo")
	public void modifyjobInfo(HttpServletRequest request,
			HttpServletResponse response, JobInfo jobInfoParam) {
		logger.info("=============修改招聘信息=============");
		logger.info("招聘信息参数 =========jobInfoParam : " + jobInfoParam);
		boolean flag = false;
		try {
			jobInfoParam.setViewFlag(jobInfoParam.getViewFlag()==null?1:0);
			jobInfoParam.setUpdateTime(DateUtils.strFormateDate(DateUtils
					.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),
					ConstConfig.DATE_FULL_FORMAT));
			jobInfoService.modifyJobInfo(jobInfoParam);
			flag = true;

		} catch (Exception e) {
			logger.error("修改招聘信息失败: " + e.getMessage());
			e.printStackTrace();
		}
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
