package com.moon.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;

import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;

public class ExcelReader {
	 private Integer numberOfSheets;
	 private Map<Integer,Integer> lastRowNum;
	 private Map<Integer, List<Map<Integer, String>>> excelMap;
	 private static String DATE_FORMAT="yyyy-MM-dd";
	 private static Logger logger = Logger.getLogger(ExcelReader.class);
	 public ExcelReader(String path) throws IOException{
		try{
		  readXls(path);
		}catch(OfficeXmlFileException e){
			logger.error("POI版本不支持高版本excel文件");
			throw e;
		}catch(FileNotFoundException e){
			logger.error("文件未找到,请检查路径");
			throw e;
		}catch(IOException e){
			logger.error("文件读取失败");
			throw e;
		}
	 }
	 private void readXls(String path) throws IOException  {
		    Map<Integer, List<Map<Integer,String>>> map =  new HashMap<Integer, List<Map<Integer,String>>>();
		    Map<Integer,Integer> lastRow = new HashMap<Integer, Integer>();
	        InputStream is = new FileInputStream(path);
	        System.out.println(is);
	        
	        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
	        // 读取sheet
	        setNumberOfSheets( hssfWorkbook.getNumberOfSheets()); 
	        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
	            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
	            if (hssfSheet == null) {
	                lastRow.put(numSheet, 0);
	            	continue;
	            }
	            lastRow.put(numSheet, hssfSheet.getLastRowNum());
	            // 读取每一行
	            ArrayList<Map<Integer,String>> list = new ArrayList<Map<Integer,String>>();
	            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
	            	boolean flag = true;
	                HSSFRow hssfRow = hssfSheet.getRow(rowNum);  //获取一行数据
	                if (hssfRow != null) {
	                	flag = isRowNull(hssfRow, list.size() + 1);
	                	if(flag) {
	                		continue;
	                	}
	                	Map<Integer,String> rowMap = getRow(hssfRow);
	                	list.add(rowMap);
	                }
	            }
	            map.put(numSheet, list);
	        }
	        is.close();
	       setLastRowNum(lastRow);
	       setExcelMap(map);
	    }
	 private Map<Integer, String> getRow(HSSFRow hssfRow) {
		 Map<Integer, String> map = new HashMap<Integer, String>();
		 for (int i = 0; i < hssfRow.getLastCellNum(); i++) {
			 if(hssfRow.getCell(i) == null){
				  map.put(i, null); 
			 }
			 else{
				try {
					if(hssfRow.getCell(i).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){ //数字格式：时间格式和纯数字格式
					   getNumeric(hssfRow.getCell(i), map, i);
					}
					else{
					   if(hssfRow.getCell(i).getStringCellValue().equals("")){
						   map.put(i, null);  
					   }
					   else{
					   map.put(i, hssfRow.getCell(i).getStringCellValue()); 
					   }
					}
				} catch (IllegalStateException e) {
					throw new BusinessException(EnumCodeException.E0006, 
							  String.format("Excel格式问题：格式为： %s, 系统不识别(正常为1)。错误数据为：%s", 
									  hssfRow.getCell(i).getCellType(), map));
				}
			}
			 
		 }
		return map;
	}
	 
	 
	 
	 private void getNumeric(HSSFCell cell, Map<Integer, String> map,Integer key){
		 if (!HSSFDateUtil.isCellDateFormatted(cell)) {
		     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		     map.put(key, String.valueOf(cell.getStringCellValue()));
		 } 
	    else {
	    	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		    map.put(key,sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())));
	    } 
	 }
	 
	private boolean isRowNull(HSSFRow hssfRow, int line){
		boolean flag = true;
		
		for (int i = 0; i < hssfRow.getLastCellNum(); i++) {
			/**
			 * 20160120 韩枫添加，避免转化时报异常
			 */
			if(hssfRow.getCell(i) == null) {
				continue;
			}
			
			if(hssfRow.getCell(i).getCellType()!= HSSFCell.CELL_TYPE_NUMERIC ){
			   hssfRow.getCell(i).setCellType(	HSSFCell.CELL_TYPE_STRING);
			} //将单元格格式转换成文本型
			if(hssfRow.getCell(i).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				throw new BusinessException(EnumCodeException.E0015, 
						String.format("第%d行第%d列数据有误", line, i+1));
			}
			if (    hssfRow.getCell(i) != null
					&& hssfRow.getCell(i).getCellType() != HSSFCell.CELL_TYPE_BLANK
					&& hssfRow.getCell(i).getCellType() != HSSFCell.CELL_TYPE_ERROR
					&& !hssfRow.getCell(i).getStringCellValue().equals("") ) {
				    flag = false;
				    break;
			}
  	}
		  return flag; //判断行是否为空，如果不为空，返回false
	  }
	
	
	public Map<Integer,Integer> getLastRowNum() {
		return lastRowNum;
	}
    private void setLastRowNum(Map<Integer,Integer> lastRowNum) {
		this.lastRowNum = lastRowNum;
	}
	public Integer getNumberOfSheets() {
		return numberOfSheets;
	}
	private void setNumberOfSheets(Integer numberOfSheets) {
		this.numberOfSheets = numberOfSheets;
	}
	public Map<Integer, List<Map<Integer, String>>> getExcelMap() {
		return excelMap;
	}
	private void setExcelMap(Map<Integer, List<Map<Integer, String>>> excelMap) {
		this.excelMap = excelMap;
	}
	  
	  
	  

}
