package com.moon.vip.service.impl.sys.orgManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.service.sys.IClearCacheService;

@Service("clearAllOrganizationData")
public class ClearAllOrganizationDataImpl implements ClearAllOrganizationData {
	@Autowired
	IClearCacheService clearCacheService;
	
	public void cleanAllOrganizationData() {
		clearCacheService.clearAuthForOrgProfessional();
		clearCacheService.clearConvertAuthToJSONArray();
		clearCacheService.clearGetChildList();
		clearCacheService.clearGetParentOrgList();
		clearCacheService.clearGetChildOrgList();
		clearCacheService.clearGetAllOrganization();
		clearCacheService.clearSelectDataActByEmpId();
	}

}
