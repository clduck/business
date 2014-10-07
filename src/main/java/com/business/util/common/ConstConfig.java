package com.business.util.common;

/**
 * 
 * @author cl
 * @description:常量定义
 */
public class ConstConfig {
     //时间格式定义
    public static final String DATE_FORMAT = "yyyyMMddHHmmss";
    public static final String DATE_SIMP_FORMAT = "yyyyMMdd";
    public static final String DATE_FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_MONTH_FORMAT = "yyyyMM";
    
    //树型结构的根节点的值
    public static final Integer EASYUI_TREE_ROOT_VALUE = -1;
    
    //树型结构叶子节点判断
    public static final int EASYUI_TREE_TYPE_LEAF = 0;
    public static final int EASYUI_TREE_TYPE_NO_LEAF = 1;
    
    //树型结构菜单状态(open： 展开   closed: 关闭)
    public static final String EASYUI_TREE_STATE_OPEN = "open";
    public static final String EASYUI_TREE_STATE_CLOSED = "closed";
    
    //图片上传的类型
    public static final String[] IMAGE_FILE_TYPE = {"jpg","png","JPG","PNG","jpeg","JPEG"};
    //图片上传的路径
    public static String IMAGE_FILE_PATH = "imageFile";
    //新闻图片文件夹
    public static String NEWS_FOLDER ="news";
    //产品图片文件夹
    public static String PRODUCT_FOLDER="product";
    
    
   //附件上传的类型
    public static final String[] FILE_TYPE = {"doc","pdf","xls","rar","jar"};
    //附件上传的路径
    public static String FILE_PATH = "uploadFile";
 
    
}