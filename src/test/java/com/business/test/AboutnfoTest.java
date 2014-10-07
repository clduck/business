package com.business.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.business.mgr.adminMgr.IAboutInfoDao;
import com.business.model.AboutInfo;
import com.business.model.param.AboutInfoParam;
import com.business.util.page.PageEntity;
import com.business.util.page.PagingResult;

@ContextConfiguration(locations = { "classpath:/config/applicationContext.xml" })
public class AboutnfoTest extends AbstractSampleTest {
	private final static Log logger = LogFactory.getLog(AboutnfoTest.class);

	@Autowired
	private IAboutInfoDao aboutInfoDao;
	public void setAboutInfoDao(IAboutInfoDao aboutInfoDao) {
		this.aboutInfoDao = aboutInfoDao;
	}
	
	@Test
	public final void testCount() {
		int count = aboutInfoDao.count();
		logger.info("查处总数：" + count);
	}
	@Test
    public final void testInsert(){
    	AboutInfo aboutInfo = new AboutInfo();
    	aboutInfo.setAboutName("测试1");
    	aboutInfo.setAddTime(new Date());
    	aboutInfo.setChildFlag(1);
    	logger.info("插入条数：" + aboutInfoDao.insert(aboutInfo));
    }
	@Test
    public final void testUpdate(){
    	AboutInfo aboutInfo = new AboutInfo();
    	aboutInfo.setAboutName("测试2222");
    	aboutInfo.setAddTime(new Date());
    	aboutInfo.setChildFlag(1);
    	AboutInfoParam conditioins = aboutInfo.getConditions();
    	conditioins.setAboutID(18);
    	
    	logger.info("更新条数：" + aboutInfoDao.update(aboutInfo));
    }
	@Test
    public final void testDelete(){
            	
    	logger.info("删除条数：" + aboutInfoDao.delete(15L));
    }
	@Test
    public final void testDeleteParam(){
    	AboutInfo aboutInfo = new AboutInfo();
    	AboutInfoParam conditions = aboutInfo.getConditions();
    	conditions.setAboutID(18);
    	
    	logger.info("删除条数：" + aboutInfoDao.deleteParam(aboutInfo));
    }
	@Test
    public final void testDeleteBatch() throws SQLException{
    
        List<Long> list = new ArrayList<Long>();
        list.add(24L);
        list.add(25L);
        list.add(26L);
        list.add(27L);
        list.add(28L);
    	logger.info("删除条数：" + aboutInfoDao.deleteBatch(list));
    }
	@Test 
	public final void testSelectPk() {
		AboutInfo aboutInfo = aboutInfoDao.selectPk(5L);
		logger.info(aboutInfo.toString());
		
	}
	@Test 
	public final void testSelectParam() {
		AboutInfo aboutInfo = new AboutInfo();
		AboutInfoParam conditions = aboutInfo.getConditions();
    	conditions.setAboutName("测试1");
	    List<AboutInfo> aboutInfos = aboutInfoDao.selectParam(aboutInfo);
	    for (AboutInfo aboutInfoParam : aboutInfos) {
		   logger.info(aboutInfoParam);
	    }
	}
	@Test 
	public final void testselectPagination() {
		AboutInfo aboutInfo = new AboutInfo();
		AboutInfoParam conditions = aboutInfo.getConditions();
    	conditions.setAboutName("测试1");
		PageEntity<AboutInfo> pageEntity = new PageEntity<AboutInfo>();
		pageEntity.setT(aboutInfo);
		pageEntity.setPageSize(10);
		pageEntity.setPageNo(1);
		PagingResult<AboutInfo> aboutInfos = aboutInfoDao.selectPagination(pageEntity);
		logger.info("=======总数======== :   " + aboutInfos.getTotalSize());
		logger.info("=======当前页======== : " + aboutInfos.getCurrentPage());
	    for (AboutInfo aboutInfoParam : aboutInfos.getRows()) {
		   logger.info(aboutInfoParam);
	    }
	}
}
