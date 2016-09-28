package com.moon.reader;

import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class test {
	public static void main(String[] args) throws IOException{
		ExcelUtil e =	new ExcelUtil("C:/Users/Administrator/Desktop/vip数据模板/电商11月合并.xls");
		Map<Integer, Integer> map = e.getLastRowNum();
		System.out.println(map.get(0));
		List<Map<Integer,String>>	list = e.getSheetOfExcel(0,false);
		for(Map<Integer,String> row:list){
			for(java.util.Map.Entry<Integer, String> cell:row.entrySet()){
			   System.out.print(cell.getValue()+" ");
			  }
			System.out.println("");
		}
	}

}
