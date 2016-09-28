package com.moon.reader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil extends ExcelReader {
	public ExcelUtil(String path) throws IOException {
		super(path);
	}
	
	/**
	 * 
	 * @param sheetNumber  //(excel表格 sheet)
	 * @param hasHead(是否读取表头)
	 * @return List<Map<Integer, String>>
	 */
    public  List<Map<Integer, String>>  getSheetOfExcel(Integer sheetNumber,boolean hasHead){
    	if(sheetNumber == null){
    		sheetNumber = 0;
    	}
    	Map<Integer, List<Map<Integer, String>>> map =super.getExcelMap();
    	if(hasHead){
    	   return map.get(sheetNumber);
    	}
    	else{
    		List<Map<Integer, String>> list = map.get(sheetNumber);
    		list.remove(0);
    		return list;
    	}
    }
    
    public List<Map<Integer, String>>  getUnrepeatSheet(Integer sheetNumber , Integer ... args){
    	Map<Integer,Map<Integer,String>> container =  new HashMap<Integer, Map<Integer,String>>();
    	List<Map<Integer,String>> list =  getSheetOfExcel(sheetNumber,false);
    	StringBuffer sb= new StringBuffer();
    	for ( Map<Integer,String> row :list ){
    		for(int i=0 ;i<args.length;i++){
    			sb.append(row.get(args[i]));
    		}
    		container.put(sb.toString().hashCode(), row);
    		    sb.delete(0, sb.length());
    	}
    	list.clear();
    	for(java.util.Map.Entry<Integer, Map<Integer, String>> unit :container.entrySet()){
    		list.add(unit.getValue());
    	}
    	return list;
    	
    }
    
    
}
