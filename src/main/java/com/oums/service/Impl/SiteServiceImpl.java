package com.oums.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.SitePo;
import com.oums.dao.IBaseDao;
import com.oums.dao.ISiteDao;
import com.oums.service.ISiteService;

@Service("siteService")
public class SiteServiceImpl implements ISiteService {	
	
	@Autowired
	IBaseDao baseDao;
	
	@Autowired
	ISiteDao siteDao;

	@Override
	public ReturnMessage findSiteByName(String siteName) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			SitePo po = siteDao.findSitePoBySiteName(siteName);
			
			if(po != null) {
				returnMessage.setFlat(true);
				returnMessage.setContent("查找成功");
				returnMessage.setObject(po);
			} else {
				returnMessage.setFlat(false);
				returnMessage.setContent("查找失敗 沒有此ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("查找失败" + e);
		}
		
		return returnMessage;
	}

	@Override
	public ReturnMessage updataSiteUsingByName(String siteName) {
				
		return null;
	}

	@Override
	public ReturnMessage findSiteByType(int siteType) {
		ReturnMessage returnMessage = new ReturnMessage();
		
		try{
			List<SitePo> pos = siteDao.findSitePoBySiteType(siteType);
			
			returnMessage.setFlat(true);
			returnMessage.setContent("查找成功");
			returnMessage.setObject(pos);
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage.setFlat(false);
			returnMessage.setContent("查找失败");
		}
		
		return returnMessage;
	}

}
