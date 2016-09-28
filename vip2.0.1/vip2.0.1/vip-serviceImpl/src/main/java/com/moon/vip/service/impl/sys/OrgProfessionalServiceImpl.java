package com.moon.vip.service.impl.sys;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.moon.vip.application.sys.OrganizationalProfessionalSqlMapper;
import com.moon.vip.infra.util.JSONUtil;
import com.moon.vip.infra.vo.sys.OrgProfessionalInfoVO;
import com.moon.vip.infra.vo.sys.orgManage.OrgBaseVO;
import com.moon.vip.service.sys.IOrgProfessionalService;
import com.moon.vip.service.sys.IGetChildListService;
import com.moon.vip.service.sys.orgManage.IOrgInfoService;

@Service("iOrgProfessionalService")
public class OrgProfessionalServiceImpl implements IOrgProfessionalService {
    @Autowired
    OrganizationalProfessionalSqlMapper orgProfessionalSqlMapper;
    @Autowired
    IOrgInfoService iOrgInfoService;
    @Autowired
    private IGetChildListService iGetChildListService;
    
	
	@Cacheable("ConvertAuthToJSONArray")
	public String convertAuthToJSONArray(HashSet<Integer> authSet) throws Exception {
		Map<String, OrgProfessionalInfoVO> orgMap =new HashMap<String, OrgProfessionalInfoVO>();
		for(Integer id:authSet){
			List<OrgBaseVO>  obList= iOrgInfoService.getParentAndChildList(id);
			OrgProfessionalInfoVO op=null;
			for(OrgBaseVO ob:obList){
				op=new OrgProfessionalInfoVO();
			    op.setId(String.valueOf(ob.getId()));
			    op.setName(ob.getName());
			    op.setpId(String.valueOf(ob.getpId()));
				orgMap.put(op.getId(), op);
			}
		}
		return JSONUtil.convertOrgProfessional(orgMap, 1);
	}
	
	public HashSet<Integer> convertSecurity(HashSet<Integer> authList) {
		HashSet<Integer> opClaIdStr = new HashSet<Integer>();
		if(authList.contains(1)) {
			authList.clear();
			authList.add(1);
		}
		for(Integer i : authList) {
			String securityStr = iGetChildListService.getChildList(i);
			HashSet<Integer> iSet = convertStringToSet(securityStr);
			opClaIdStr.addAll(iSet);
		}
		return opClaIdStr;
	}

	public HashSet<Integer> covertOrgSearch(int organizationId) {
		String orgSearchStr = iGetChildListService.getChildList(organizationId);
		return convertStringToSet(orgSearchStr);
	}
	/**
	 * 将String 转化为 HashSet<br/> 
	 * @Title: convertStringToSet <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月21日 下午4:35:42  <br/> 
	 * @param str
	 * @return
	 * HashSet<Integer>
	 * @throws  <br/>
	 */
	private HashSet<Integer> convertStringToSet(String str) {
		HashSet<Integer> orgSearchSet = new HashSet<Integer>();
		String[] strList = str.split(",");
		for(String s :strList) {
			orgSearchSet.add(Integer.valueOf(s));
		}
		return orgSearchSet;		
	}

	@Cacheable("FindTopNodeId")
	public Integer findTopNodeId() {
		return orgProfessionalSqlMapper.selectTopNodeId();
	}

}
