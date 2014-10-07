package com.business.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/main")
public class MainController {
	private final Log logger = LogFactory.getLog(LoginController.class);
	private static String PROJECT_MODEL = "system/blue1_accordion";
    /**
     * 初始化首页
     * @param modelMap
     * @return
     */
	@RequestMapping(value = "/do")
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
		logger.info("=========初始化首页=========");
		String outpath = "/" + PROJECT_MODEL + "/main";
		return new ModelAndView(outpath, modelMap);
	}
	/**
	 * 初始化左边菜单栏
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/left")
	public ModelAndView left(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
		logger.info("=========左边菜单栏=========");
		String outpath = "/" + PROJECT_MODEL + "/left";
		return new ModelAndView(outpath, modelMap);
	}
	/**
	 * 初始页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/open")
	public ModelAndView open(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
		logger.info("=========初始页面=========");
		String outpath = "/" + PROJECT_MODEL + "/open";
		return new ModelAndView(outpath, modelMap);
	}
}
