package com.business.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.mgr.adminMgr.DownloadInfoDao;
import com.business.model.CommonObject;
import com.business.model.DownloadInfo;
import com.business.model.param.DownloadParam;
import com.business.service.DownloadInfoService;

@Service
public class DownloadInfoServiceImpl implements DownloadInfoService {
	private Log logger = LogFactory.getLog(DownloadInfoServiceImpl.class);
	@Autowired
	private DownloadInfoDao downloadInfoDao;

	public CommonObject getDownloadInfos(DownloadParam downloadInfoParam,
			int start, int num) throws Exception {
		CommonObject object = new CommonObject();
		int total = downloadInfoDao.queryDownloadInfoCount(downloadInfoParam);
		List<DownloadInfo> list = downloadInfoDao.queryDownloadInfo(downloadInfoParam, start, num);
		object.setRows(list);
		object.setTotal(total);
		return object;
	}

	public DownloadInfo getDownloadInfo(DownloadInfo downloadInfoParam) throws Exception {
		return downloadInfoDao.queryDownloadInfos(downloadInfoParam).get(0);
	}

	public void insertDownloadInfo(DownloadInfo downloadInfoParam) throws Exception {
		downloadInfoDao.insertDownloadInfo(downloadInfoParam);

	}

	public void modifyDownloadInfo(DownloadInfo downloadInfoParam) throws Exception {
		downloadInfoDao.modifyDownloadInfo(downloadInfoParam);

	}

	public void deleteDownloadInfo(List<Integer> downloadInfoIds) throws Exception {
		downloadInfoDao.deleteDownloadInfos(downloadInfoIds);
	}

}
