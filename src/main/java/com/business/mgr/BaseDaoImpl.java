package com.business.mgr;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.business.util.page.PageEntity;
import com.business.util.page.PagingResult;
import com.business.util.reflect.ReflectGeneric;

/**
 * baseDAO的实现基类
 * 
 * @author hwt
 * 
 * @param <T>
 * @param <PK>
 */
public abstract class BaseDaoImpl<T, PK extends Serializable> extends SqlSessionDaoSupport implements IBaseDAO<T, PK> {
	// mapper.xml中的namespace
	private static final Log logger = LogFactory.getLog(BaseDaoImpl.class);
	private String namespace = getDefaultSqlNamespace();


	// sqlmap.xml定义文件中对应的sqlid
	public static final String SQLID_INSERT = "insert";
	public static final String SQLID_INSERT_BATCH = "insertBatch";
	public static final String SQLID_UPDATE = "update";
	public static final String SQLID_UPDATE_PARAM = "updateParam";
	public static final String SQLID_UPDATE_BATCH = "updateBatch";
	public static final String SQLID_DELETE = "deletePK";
	public static final String SQLID_DELETE_PARAM = "deleteParam";
	public static final String SQLID_DELETE_BATCH = "deleteBatch";
	public static final String SQLID_TRUNCATE = "truncate";
	public static final String SQLID_SELECT = "select";
	public static final String SQLID_SELECT_PK = "selectPk";
	public static final String SQLID_SELECT_PARAM = "selectParam";
	public static final String SQLID_SELECT_PAGE= "selectPage";
	public static final String SQLID_SELECT_FK = "selectFk";
	public static final String SQLID_COUNT = "count";
	public static final String SQLID_COUNT_PARAM = "countParam";

	public String getNamespace() {
		return namespace;
	}
	
	@Resource(name = "sqlSessionTemplate")
	public void setSuperSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@SuppressWarnings("unchecked") 
	protected String getDefaultSqlNamespace() { 
	Class<T> clazz = ReflectGeneric.getClassGenricType(this.getClass()); 
	String nameSpace = clazz.getName(); 
	return nameSpace; 
	} 


	@Override
	public int insert(T entity) {
		int rows = 0;
		String sqlId = namespace + "." + SQLID_INSERT;
		try {
			printLog(sqlId, entity);
			rows = getSqlSession().insert(namespace + "." + SQLID_INSERT,
					entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int update(T entity) {
		int rows = 0;
		String sqlId = namespace + "." + SQLID_UPDATE;
		try {
			printLog(sqlId, entity);
			rows = getSqlSession().update(namespace + "." + SQLID_UPDATE,
					entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

//	@Override
//	public int updateParam(Map param) {
//		int rows = 0;
//		String sqlId = namespace + "." + SQLID_UPDATE_PARAM;
//		try {
//			printLog(sqlId, param);
//			rows = getSqlSession().update(namespace + "." + SQLID_UPDATE_PARAM,
//					param);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return rows;
//	}

	@Override
	public int delete(PK primaryKey) {
		int rows = 0;
		String sqlId = namespace + "." + SQLID_DELETE;
		try {
			printLog(sqlId, primaryKey);
			rows = getSqlSession().delete(namespace + "." + SQLID_DELETE,
					primaryKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int deleteParam(T entity) {
		int rows = 0;
		String sqlId = namespace + "." + SQLID_DELETE_PARAM;
		try {
			printLog(sqlId, entity);
			rows = getSqlSession().delete(namespace + "." + SQLID_DELETE_PARAM,
					entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int truncate() {
		int rows = 0;
		try {
			rows = getSqlSession().delete(namespace + "." + SQLID_TRUNCATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int count() {
		String sqlId = namespace + "." + SQLID_COUNT;
		int result = 0;
		try {
			printLog(sqlId,null);
			result = (Integer) getSqlSession().selectOne(namespace + "." + SQLID_COUNT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int count(Object param) {
		int result = 0;
		try {
			result = (Integer) getSqlSession().selectOne(namespace + "." + SQLID_COUNT_PARAM,param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public T selectPk(PK primaryKey) {
		try {
			return (T) getSqlSession().selectOne(namespace + "." + SQLID_SELECT_PK,primaryKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> select() {
		try {
			return getSqlSession().selectList(namespace + "." + SQLID_SELECT);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<T> selectParam(T entry) {
		try {
			return getSqlSession().selectList(namespace + "." + SQLID_SELECT_PARAM,entry);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public PagingResult<T> selectPagination(PageEntity<T> pageEntity) {
		try {
			int page = pageEntity.getPageNo() == null || "".equals(pageEntity.getPageNo()) ? 1 : pageEntity.getPageNo(); //默认为第一页
			int size = pageEntity.getPageSize() == null || "".equals(pageEntity.getPageSize()) ? 10 : pageEntity.getPageSize();; //默认每页15个
			
			RowBounds rowBounds = new RowBounds((page-1)*size, size);
			
//			Map param = pageEntity.getT().getParams();
//			if (param != null) {
//				param.put("orderColumn", pageEntity.getOrderColumn());
//				param.put("orderTurn", pageEntity.getOrderTurn());
//			}else {
//				param = new HashMap();
//				param.put("orderColumn", pageEntity.getOrderColumn());
//				param.put("orderTurn", pageEntity.getOrderTurn());
//			}
			
			List<T> resultList = getSqlSession().selectList(namespace + "." + SQLID_SELECT_PAGE,pageEntity.getT(),rowBounds);
			int totalSize = count(pageEntity.getT());
			
			PagingResult<T> pagingResult = new PagingResult<T>();
			pagingResult.setCurrentPage(page);
			pagingResult.setTotalSize(totalSize);
			
			pageEntity = new PageEntity<T>();
			pageEntity.setTotalRows(totalSize);
			pageEntity.setPageNo(page);
			pageEntity.setPageSize(size);
			
			pagingResult.setPager(pageEntity);
			pagingResult.setRows(resultList);
			return pagingResult;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public int insertBatch(List<T> list) {
		try {
			return getSqlSession().insert(namespace + "." + SQLID_INSERT_BATCH,list);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
 
	@Override
	public int updateBatch(List<T> list) {
		int rows = 0;
		try {
			for (T t : list) {
				rows = rows + getSqlSession().update(namespace + "." + SQLID_UPDATE, t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;

	}

	@Override
	public int deleteBatch(List<PK> list) {
		try {
			return getSqlSession().delete(namespace + "." + SQLID_DELETE_BATCH,list);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 日志打印
	 * @param sqlId
	 * @param param
	 */
	public void printLog(String sqlId,Object param){
		Configuration configuration = getSqlSession().getConfiguration();
		//sqlId为配置文件中的sqlid
		MappedStatement mappedStatement = configuration.getMappedStatement(sqlId);
		//param为传入到sql语句中的参数
		BoundSql boundSql = mappedStatement.getBoundSql(param);
		//得到sql语句
		String sql = boundSql.getSql().trim();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("执行的sql语句为: "+sdf.format(new Date())+"  "+sql);
	}
}
