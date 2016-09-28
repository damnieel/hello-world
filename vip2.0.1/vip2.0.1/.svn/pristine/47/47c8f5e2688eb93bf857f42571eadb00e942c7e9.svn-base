package com.moon.vip.infra.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.moon.vip.infra.vo.sys.OrgProfessionalInfoVO;



public class Search {


	public static final String ID = "id";
	
	public static final String NAME = "name";
	
	public static final String PID = "pId";
	
	public static Map<String,List<JSONObject>> convertMapData(List<OrgProfessionalInfoVO> list) throws Exception{
		Map<String,List<JSONObject>> listMap = new HashMap<String, List<JSONObject>>();
		List<JSONObject> listJSON = new ArrayList<JSONObject>();
		for(OrgProfessionalInfoVO category : list){
			JSONObject json = new JSONObject();
			String pid = String.valueOf(category.getpId());
			json.put(PID, category.getpId());
			json.put("n", category.getName());
			json.put("v", category.getId());
			if ("0".equals(pid)) {
				continue;
			}
			if(listMap.containsKey(pid)){
				listJSON = listMap.get(pid);
				listJSON.add(json);
			}else{
				listJSON = new ArrayList<JSONObject>();
				listJSON.add(json);
				listMap.put(pid, listJSON);
			}
		}
		return listMap;
	}
	
	
	public static JSONObject data(String id,Map<String,List<JSONObject>> listMap,JSONObject json,Set<String> usedIds) throws Exception{
		List<JSONObject> listJSON = listMap.get(id);
		if(null != listJSON && listJSON.size() > 0){
			for(JSONObject obj : listJSON){
				String propId = obj.getString("v");
				usedIds.add(propId);
				data(propId,listMap, obj,usedIds);
			}
			json.put("s", listJSON);
		}
		return json;
	}
	
	public static JSONArray convertData(Map<String,List<JSONObject>> listMap,List<OrgProfessionalInfoVO> listCategory) throws Exception{
		JSONArray array = new JSONArray();
		Set<String> usedIds = new HashSet<String>();
		for(OrgProfessionalInfoVO category : listCategory){
			String id = String.valueOf(category.getId());
			if(usedIds.contains(id)){
				continue;
			}
			String name = category.getName();
			JSONObject json = new JSONObject();
			json.put("v", id);
			json.put("n", name);
			data(id,listMap,json,usedIds);
			if(!array.contains(json)) {
				array.add(json);
			}
		}
		return array;
	}
	
	
}	


