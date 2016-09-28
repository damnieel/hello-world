package com.moon.vip.service.impl.sys.orgManage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.moon.vip.application.sys.OrganizationalProfessionalSqlMapper;
import com.moon.vip.infra.vo.sys.orgManage.OrgBaseVO;
import com.moon.vip.service.sys.orgManage.IOrgInfoService;

@Service("orgInfoService")
public class OrgInfoServiceImpl implements IOrgInfoService {

	@Autowired
	private OrganizationalProfessionalSqlMapper orgSqlMapper;
	
	
	@Cacheable("GetAllOrganization")
	public List<OrgBaseVO> getAllOrganization() {
		return orgSqlMapper.getAllOrgInfo();
	}

	@Cacheable("GetChildOrgList")
	@SuppressWarnings("rawtypes")
	public List<OrgBaseVO> getChildOrgList(int id) {
		List<OrgBaseVO>  orgList = getAllOrganization();
		Map<Integer,List> orgPidMap = getPidMapListFromOrgList(orgList);
		List<Integer> pidList = new ArrayList<Integer>();
		pidList.add(id);
		return getChildrenFromOrgPidMap(pidList,orgPidMap);
	}

	@SuppressWarnings("unchecked")
	private List<OrgBaseVO> getChildrenFromOrgPidMap(List<Integer> pidList, @SuppressWarnings("rawtypes") Map<Integer,List> orgPidMap){
		List<OrgBaseVO> children = new ArrayList<OrgBaseVO>();
		List<Integer> subPidList = new ArrayList<Integer>();
		List<OrgBaseVO> tmpList = null;
		for(Integer pid : pidList){
			tmpList = orgPidMap.get(pid);
			if(tmpList != null && tmpList.size() > 0){
				for(int i=0; i < tmpList.size(); i++){
					if(tmpList.get(i) != null && tmpList.get(i).getId() != null){
						subPidList.add(tmpList.get(i).getId());
						children.add(tmpList.get(i));
					}
				}
			}
		}
		if(subPidList.size() > 0){
			List<OrgBaseVO> subChildren = getChildrenFromOrgPidMap(subPidList,orgPidMap);
			if(subChildren != null && subChildren.size() > 0){
				children.addAll(subChildren);
			}
		}
		
		return children;
	}
	
	@Cacheable("GetParentOrgList")
	public List<OrgBaseVO> getParentOrgList(int id) {
		List<OrgBaseVO>  orgList = getAllOrganization();
		Map<Integer,OrgBaseVO> orgPidMap = getIdMapListFromOrgList(orgList);
		return getParentFromOrgPidMap(id, orgPidMap);
	}
	
	private  List<OrgBaseVO> getParentFromOrgPidMap(int id, Map<Integer,OrgBaseVO> orgPidMap){
		OrgBaseVO org = orgPidMap.get(id);
		List<OrgBaseVO>  orgList = new ArrayList<OrgBaseVO>();
		if(org != null ){
		   if(org.getpId() != null){
			   orgList.addAll(getParentFromOrgPidMap(org.getpId(),orgPidMap));
		   }
		   orgList.add(org);
		}
		return orgList;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map<Integer, List> getPidMapListFromOrgList(List<OrgBaseVO>  orgList){
		Map<Integer,List> orgPidMap = new HashMap<Integer,List>();
		List<OrgBaseVO> subOrglist = null;
		if(orgList != null && orgList.size() > 0){
			for(OrgBaseVO org : orgList){
				subOrglist = orgPidMap.get(org.getpId());
				if(subOrglist == null){
					subOrglist = new ArrayList<OrgBaseVO>();
					subOrglist.add(org);
					orgPidMap.put(org.getpId(),subOrglist);
				}else{
					subOrglist.add(org);
				}
			}
		}
		return orgPidMap;
	}
	
	private Map<Integer, OrgBaseVO> getIdMapListFromOrgList(List<OrgBaseVO>  orgList){
		Map<Integer,OrgBaseVO> orgIdMap = new HashMap<Integer,OrgBaseVO>();
		for(OrgBaseVO org : orgList){
			if(org.getId() != null){
				orgIdMap.put(org.getId(), org);
			}
		}
		return orgIdMap;
	}

	public List<OrgBaseVO> getParentAndChildList(int id) {
		List<OrgBaseVO> orglist = new ArrayList<OrgBaseVO>();
		orglist.addAll(getParentOrgList(id));
		orglist.addAll(getChildOrgList(id));
		return orglist;
	}

	public List<Integer> getParentIdList(int id) {
		List<OrgBaseVO> orgList = getParentOrgList(id);
		List<Integer> orgIdList = new ArrayList<Integer>();
		for(OrgBaseVO org : orgList){
			orgIdList.add(org.getId());
		}
		return orgIdList;
	}

	public List<Integer> getChildIdList(int id) {
		List<OrgBaseVO> orgList = getChildOrgList(id);
		List<Integer> orgIdList = new ArrayList<Integer>();
		for(OrgBaseVO org : orgList){
			orgIdList.add(org.getId());
		}
		orgIdList.add(id);
		return orgIdList;
	}
	
	
}
