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
import com.business.model.ProductInfo;
import com.business.model.ProductType;
import com.business.model.common.RetMsg;
import com.business.model.param.ProductParam;
import com.business.service.ProductInfoService;
import com.business.service.ProductTypeService;
import com.business.util.DateUtils;
import com.business.util.common.ConstConfig;
import com.business.util.file.FileHelper;
import com.business.util.file.MultipartFileValidator;
import com.business.util.tree.EasyUITreeBean;

@Controller
public class ProductController {
	private static Log logger = LogFactory.getLog(ProductController.class);
	@Autowired
	private ProductInfoService productInfoService;
	@Autowired
	private ProductTypeService productTypeService;
	@Autowired
	private MemGroupDao memGroupDao;

	public void setMemGroupDao(MemGroupDao memGroupDao) {
		this.memGroupDao = memGroupDao;
	}
	@RequestMapping(value = "/admin/product.do", params = "method=getProductInfos")
	@ResponseBody
	public CommonObject getProductfos(HttpServletRequest request,ProductParam productParam) {

		logger.info("=========获取产品列表信息=========");
		logger.info("=========当前页码 page   :" + request.getParameter("page"));
		logger.info("=========当前页记录数rows   :" + request.getParameter("rows"));
		String page = request.getParameter("page");
		String num = request.getParameter("rows");
		
		productParam.setEndTime("".equals(productParam.getEndTime())?null:productParam.getEndTime());
		productParam.setStartTime("".equals(productParam.getStartTime())?null:productParam.getStartTime());
		
		CommonObject products = null;
		try {
			products = productInfoService.getProductInfos(productParam,
					(Integer.parseInt(page) - 1) * Integer.parseInt(num),
					Integer.parseInt(num));
		} catch (Exception e) {
			logger.error("获取产品信息异常：" + e.getMessage());
			e.printStackTrace();
		}
		return products;
	}
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description :删除产品信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/product.do", params = "method=deleteProducts")
	public void deleteProducts(HttpServletRequest request,
			HttpServletResponse response) {
		
		logger.info("=============删除产品信息=============");
		RetMsg ret = new RetMsg();
		String json = request.getParameter("productParams");
		logger.info("========参数productParams :" + json);
		JSONArray jsonArray = JSONArray.fromObject(json);
		List<ProductInfo> productParams = (List<ProductInfo>) JSONArray.toCollection(jsonArray, ProductInfo.class);
		List<Integer> Ids = new ArrayList<Integer>();
		for (int i = 0; i < productParams.size(); i++) {
			Ids.add(productParams.get(i).getProductID());
		}
		try {
			productInfoService.deleteProductInfo(Ids);
			ret.setCode(0);
			ret.setMsg("删除产品信息成功");
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("删除产品信息失败：" + e.getMessage());
			ret.setCode(-1);
			ret.setMsg("删除产品信息失败,请联系管理员");
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
	 * @description : 获取产品类型树型数据
	 * @return : String
	 * 
	 */
	@RequestMapping(value = "/admin/productType.do", params = "method=getProductTypes")
	@ResponseBody
	public List<EasyUITreeBean> getProductTypes(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("==============获取产品类型列表数据===========");
		String treeData = "";
		List<EasyUITreeBean> beans = null;
		try {
			beans = productTypeService.getProductTypeTreeData();
			// treeData = JSONArray.fromObject(beans).toString();
			logger.info("===========产品类型树 treeData ：  "
					+ JSONArray.fromObject(beans).toString());
		} catch (Exception e) {
			logger.error("==========获取产品类型列表数据失败  ： " + e.getLocalizedMessage());
		}
		return beans;
	}
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description : 初始化产品类型信息
	 * @return : ModelAndView
	 * 
	 */
	@RequestMapping(value = "/admin/productType.do", params = "method=initProductType")
	public ModelAndView initproductType(HttpServletRequest request,HttpServletResponse response,
			ModelMap modelMap) {
		logger.info("===========初始化产品类型详细信息===========");
		ProductType productType =  new ProductType();
		modelMap.put("productType", productType);
		return new ModelAndView("productType");
	}
	/**
	 *  
	 *  @time : 2012-2-25 
	 *  @author :cl
	 *  @description : 获取产品类型信息
	 *  @return : void
	 *
	 */
	@RequestMapping(value="/admin/productType.do",params = "method=getProductType")
	public void getProductType(HttpServletRequest request, HttpServletResponse response){
		logger.info("======= 获取产品类型信息=========");
		String productTypeId = request.getParameter("productTypeId");
		logger.info("======= 传入参数   productTypeId  ：  "  + productTypeId);
		ProductType productType = new ProductType();
		ProductType param = new ProductType();
		RetMsg ret = new RetMsg();
		param.setProductTypeID(Integer.parseInt(productTypeId));
		try {
			productType = productTypeService.getProductType(param);
			ret.setRetobj(productType);
			ret.setCode(0);
		} catch (Exception e) {
			logger.error("获取产品类型信息失败 : " + e.getMessage());
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
	 * @description : 添加产品类型信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/productType.do", params = "method=saveProductType")
	public void saveProductType(HttpServletRequest request,
			HttpServletResponse response, ProductType productTypeParam) {
		
		logger.info("=============添加产品类型信息=============");
		logger.info("产品信息参数 =========productTypeParam : " + productTypeParam);
		RetMsg ret = new RetMsg();
		try {
			productTypeParam.setClickNumber(0);
			productTypeParam.setLeaf(1);
			productTypeParam.setStatus(0);
			productTypeParam.setViewFlag(productTypeParam.getViewFlag() == null? 1:productTypeParam.getViewFlag());
			productTypeParam.setParentID(productTypeParam.getParentID()==null?0:productTypeParam.getParentID());
			productTypeParam.setSequence(0);
			productTypeService.insertProductType(productTypeParam);
			ret.setCode(0);
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("保存产品类型信息失败：" + e.getMessage());
			ret.setCode(-1);
			ret.setMsg("保存产品类型信息失败");
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
	 * @description : 修改产品类型信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/productType.do", params = "method=modifyProductType")
	public void modifyProductType(HttpServletRequest request,
			HttpServletResponse response, ProductType productTypeParam) {
		
		logger.info("=============修改产品类型信息=============");
		logger.info("产品信息参数 =========productTypeParam : " + productTypeParam);
		RetMsg ret = new RetMsg();
		try {
			productTypeParam.setViewFlag(productTypeParam.getViewFlag() == null? 1:productTypeParam.getViewFlag());
			productTypeService.modifyProductType(productTypeParam);
			ret.setCode(0);
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("修改产品类型信息失败：" + e.getMessage());
			e.printStackTrace();
			ret.setCode(-1);
			ret.setMsg("修改产品类型信息失败");
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
	 * @description :删除产品类型信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/productType.do", params = "method=deleteProductType")
	public void deleteProductType(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Integer id) {
		
		logger.info("=============删除产品类型信息=============");
		RetMsg ret = new RetMsg();
		try {
			productTypeService.deleteProductType(id);
			ret.setCode(0);
			ret.setRetobj("");
		} catch (Exception e) {
			logger.error("删除产品类型信息失败：" + e.getMessage());
			ret.setCode(-1);
			ret.setMsg("删除产品类型信息失败");
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
	@RequestMapping(value = "/admin/product.do", params = "method=uploadImageFile", method = RequestMethod.POST)
	public void uploadImageFile(@RequestParam("imageFile") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("===========上传产品图片==========");
		logger.info("===============" + file.getOriginalFilename());
		logger.info("==============图片类型："+request.getParameter("imgTypeParam"));
		String imgTypeParam = request.getParameter("imgTypeParam");
		RetMsg ret = new RetMsg();
		try {
			String imgPrefix="";
			if(imgTypeParam == null){
				throw new Exception("上传图片类型出错");
			}
		    if ("small".equals(imgTypeParam)) {
		    	imgPrefix = "S_image_";
			}else{
				imgPrefix = "P_image_";
			}
			
			MultipartFileValidator fileValidator = new MultipartFileValidator();
			fileValidator.setAllowedContentTypes(ConstConfig.IMAGE_FILE_TYPE);
			String filePath = request.getRealPath("/") + ConstConfig.IMAGE_FILE_PATH + "//" + ConstConfig.PRODUCT_FOLDER+"//";
			logger.info("===========图片路径===========" + filePath);
			String newFileName =  imgPrefix+ DateUtils.dateFormatStr(new Date(), "yyyyMMddHHmmss")+".jpg";
			
			fileValidator.validate(file);
			if (!new File(filePath).isDirectory()) {
				new File(filePath).mkdirs();
			}
			FileHelper.creatFile(filePath + newFileName, file);
			ret.setCode(0);
			List list = new ArrayList();
			list.add(imgTypeParam);
			ret.setRetlist(list);
			ret.setRetobj(ConstConfig.IMAGE_FILE_PATH+"/"+ConstConfig.PRODUCT_FOLDER+"/"+newFileName);
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
	 * @description : 初始化产品信息
	 * @return : ModelAndView
	 * 
	 */
	@RequestMapping(value = "/admin/product.do", params = "method=initProductInfo")
	public ModelAndView initproductInfo(HttpServletRequest request,
			ModelMap modelMap) {
		logger.info("===========初始化产品详细信息===========");
		logger.info("===========信息ID ： " + request.getParameter("productID"));
		String productID = request.getParameter("productID");
		ProductInfo productInfo = null;
		List<MemGroup> memGroups = null;
		String saveType = "";
		try {
			memGroups = memGroupDao.queryMemGroup(new MemGroup());
		} catch (Exception e) {
			logger.info("初始化产品详细信息--获取群组信息失败:" + e.getMessage());
			e.printStackTrace();
		}
		if (productID != null && !"".equals(productID)) {
			saveType = "modifyProductInfo";
			ProductInfo productInfoParam = new ProductInfo();
			try {
				productInfoParam.setProductID(Integer.parseInt(productID));
				productInfo = productInfoService.getProductInfo(productInfoParam);
			} catch (Exception e) {
				logger.error("初始化产品详细信息失败：" + e.getMessage());
			}
		} else {
			saveType = "saveProductInfo";
			productInfo = new ProductInfo();
			productInfo.setViewFlag(1);
		}
		modelMap.put("productInfo", productInfo);
		modelMap.put("memGroups", memGroups);
		modelMap.put("submitMethod", saveType);
		return new ModelAndView("productInfo");
	}	
	/**
	 * 
	 * @time : 2012-1-28
	 * @author :cl
	 * @description : 添加产品信息
	 * @return : void
	 * 
	 */
	@RequestMapping(value = "/admin/product.do", params = "method=saveProductInfo")
	public void saveInfo(HttpServletRequest request,
			HttpServletResponse response, ProductInfo productInfoParam) {
		logger.info("=============添加产品信息=============");
		logger.info("产品信息参数 =========productInfoParam : " + productInfoParam);
		boolean flag = false;
		try {
			productInfoParam.setAddTime(DateUtils.strFormateDate(DateUtils
					.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),
					ConstConfig.DATE_FULL_FORMAT));
			productInfoParam.setUpdateTime(DateUtils.strFormateDate(DateUtils
					.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),
					ConstConfig.DATE_FULL_FORMAT));
			
			productInfoParam.setClickNumber(0);
			productInfoParam.setStatus(0);
			productInfoParam.setCommendFlag(productInfoParam.getCommendFlag()==null?1:0);
			productInfoParam.setNewFlag(productInfoParam.getNewFlag()==null?1:0);
			productInfoParam.setViewFlag(productInfoParam.getViewFlag()==null?1:0);
			
			productInfoService.insertProductInfo(productInfoParam);
			flag = true;
		} catch (Exception e) {
			logger.error("保存产品信息失败：" + e.getMessage());
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
	 * @description : 修改产品信息
	 * @return : ModelAndView
	 * 
	 */
	@RequestMapping(value = "/admin/product.do", params = "method=modifyProductInfo")
	public void modifyproductInfo(HttpServletRequest request,
			HttpServletResponse response, ProductInfo productInfoParam) {
		logger.info("=============修改产品信息=============");
		logger.info("产品信息参数 =========productInfoParam : " + productInfoParam);
		boolean flag = false;
		try {
			productInfoParam.setCommendFlag(productInfoParam.getCommendFlag()==null?1:0);
			productInfoParam.setNewFlag(productInfoParam.getNewFlag()==null?1:0);
			productInfoParam.setViewFlag(productInfoParam.getViewFlag()==null?1:0);
			productInfoParam.setUpdateTime(DateUtils.strFormateDate(DateUtils
					.dateFormatStr(new Date(), ConstConfig.DATE_FULL_FORMAT),
					ConstConfig.DATE_FULL_FORMAT));
			productInfoService.modifyProductInfo(productInfoParam);
			flag = true;

		} catch (Exception e) {
			logger.error("修改产品信息失败: " + e.getMessage());
			e.printStackTrace();
		}
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
