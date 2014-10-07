package com.business.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.business.model.common.RetMsg;
import com.business.service.LoginService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	private final Log logger = LogFactory.getLog(LoginController.class);
	@Autowired
	private LoginService loginService;
	private static String PROJECT_MODEL = "login";
	public LoginController() {

	}
    /**
     * 登陆跳转页
     * @param request
     * @param response
     * @param modelMap
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "do", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
        
		String outpath = "/"+PROJECT_MODEL+"/login";
		return new ModelAndView(outpath, modelMap);
	}
	/**
	 * 登陆操作
	 * @param request
	 * @param response
	 * @param para
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
    @RequestMapping(value = "/loginAction" , method = RequestMethod.POST )
    public ResponseEntity<RetMsg> loginAction(HttpServletRequest request,HttpServletResponse response, @RequestBody String para) throws Exception {
     
		RetMsg ret = new RetMsg();
		
		ret.setCode(0);
		ret.setMsg("登陆成功！");
		String url = "/main/do.xhtml";
		ret.setRetobj(url);
		
		return new ResponseEntity<RetMsg>( ret ,HttpStatus.OK);
    }
	
}
