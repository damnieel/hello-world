package com.moon.vip.service.impl.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.moon.vip.application.sys.OrganizationalProfessionalSqlMapper;
import com.moon.vip.service.sys.IGetChildListService;
import com.moon.vip.service.sys.orgManage.IOrgInfoService;

@Service("iGetChildListService")
public class GetChildListServiceImpl implements IGetChildListService{

    @Autowired
    private OrganizationalProfessionalSqlMapper orgProfessionalSqlMapper;
    @Autowired
    private IOrgInfoService iOrgInfoService;

	@Cacheable("GetChildList")
	public String getChildList(int organizationId) {
		List<Integer> childList = iOrgInfoService.getChildIdList(organizationId);
		String childStr = childList.toString();
		childStr = childStr.substring(1, childStr.length()-1);
		return childStr.replace(" ", "");
	}

}
