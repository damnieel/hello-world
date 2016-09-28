package com.moon.vip.infra.util;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.sys.DynameicMenuVO;
import com.moon.vip.infra.vo.sys.OrgProfessionalInfoVO;

/**
 * 类名称：JSONUtil.java<br/>
 * 日期：2016年1月21日 上午10:08:48<br/>
 * 类描述：TODO<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年1月21日 Roy TODO<br/>
 * @author <a href="mailto:luofangyi19@126.com">Roy</a><br/>
 * @version 1.0.0
 */
public class JSONUtil {

	private static Logger logger = Logger.getLogger(JSONUtil.class);
	 /**
	 * 日期：2016年1月21日 上午10:00:41<br/>
	 * 描述：将传入的组织结构Map转换成JSON<br/>
	 * 修改说明（时间、人）：<br/>
	 * 上午10:00:41 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param orgMap 组织结构-专业Map，结构-专业ID作为主键
	 * @param topNodeId 顶级节点ID
	 * @return<br/>
	 * String
	 */
	public static String convertOrgProfessional(Map<String, OrgProfessionalInfoVO> orgMap, Integer topNodeId) {
		
		List<DynameicMenuVO> dynList = Lists.newArrayList();
		Map<String, OrgProfessionalInfoVO> levelTop = findTopParent(orgMap, topNodeId);
		Map<String, DynameicMenuVO> dynMap = Maps.newConcurrentMap();
		for(String topKey : levelTop.keySet()) {
			DynameicMenuVO menuVo = convertOrgProfessional(levelTop.get(topKey));
			diffenceOrgProfMap(menuVo, levelTop, orgMap, 1);
			dynMap.put(topKey, menuVo);
		}
		
		for(String key : dynMap.keySet()) {
			dynList.add(dynMap.get(key));
		}
		logger.info(String.format("处理之后的JSON串: %s", JSON.toJSONString(dynList)));
		return JSON.toJSONString(dynList);
	}
	
	
	private static void diffenceOrgProfMap(DynameicMenuVO dyn, Map<String, OrgProfessionalInfoVO> higherMap, Map<String, OrgProfessionalInfoVO> lowMap, int i) {
		MapDifference<String, OrgProfessionalInfoVO> diffenceMap = Maps.difference(higherMap, lowMap);
		Map<String, OrgProfessionalInfoVO> stayMap = diffenceMap.entriesOnlyOnRight();
		if(!stayMap.isEmpty()) {
			Map<String, OrgProfessionalInfoVO> childHigherMap = Maps.newConcurrentMap();
			for(String parentKey : stayMap.keySet()) {
				if(dyn.v.equals(stayMap.get(parentKey).getpId())) {
					childHigherMap.put(parentKey, stayMap.get(parentKey));
					dyn.s.add(convertOrgProfessional(stayMap.get(parentKey)));
				}
			}
			for(DynameicMenuVO child : dyn.s) {
				diffenceOrgProfMap(child, childHigherMap, stayMap, i+1);
			}
		}
	}
	
	private static Map<String, OrgProfessionalInfoVO> findTopParent(Map<String, OrgProfessionalInfoVO> orgMap, Integer topNodeId) {
		Map<String, OrgProfessionalInfoVO> retMap = Maps.newConcurrentMap();
		Integer topId = topNodeId;
		if(topId == null) {
			throw new BusinessException(EnumCodeException.E0014);
		}
		for(String key : orgMap.keySet()) {
			if(orgMap.get(key) == null) {
				continue;
			}
			OrgProfessionalInfoVO prof = orgMap.get(key);
			if(topId.toString().equals(prof.getpId())) {
				retMap.put(prof.getId(), prof);
			}
		}
		return retMap;
	}
	
	private static DynameicMenuVO convertOrgProfessional(OrgProfessionalInfoVO professional) {
		return new DynameicMenuVO(professional.getId(), professional.getName(), professional.getpId());
	}
}
