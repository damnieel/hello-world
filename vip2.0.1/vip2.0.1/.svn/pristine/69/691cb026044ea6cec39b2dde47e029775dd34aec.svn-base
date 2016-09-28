package com.moon.reader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 * 
* @ClassName: ExcelWriter 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author  陈海  - （怡宝 ）
* @date 2016年1月15日 上午10:24:05 
* @param <T>
 */
public class ExcelWriter<T> {
	private  HSSFCellStyle style ; //表格样式
	private  HSSFFont font;  //字体样式
	private int cellWidth = 15; //cell宽度
    private static Logger logger = Logger.getLogger(ExcelWriter.class);
    public void exportExcel(Collection<T> dataset, OutputStream out) {
        exportExcel("TZexcel", null, dataset, out, "yyyy-MM-dd");
    }
    public void exportExcel(String[] headers, Collection<T> dataset,
            OutputStream out) {
        exportExcel("TZexcel", headers, dataset, out, "yyyy-MM-dd");
    }

    public void exportExcel(String[] headers, Collection<T> dataset,
            OutputStream out, String pattern) {
        exportExcel("TZexcel", headers, dataset, out, pattern);
    }
    public void exportExcel(ExcelSetting setting ,String[] headers, Collection<T> dataset,
            OutputStream out, String pattern) {
    	setCellWidth(setting.getCellWidth());
    	if(setting.getStyle() != null){
    		setStyle(setting.getStyle());
    	}
    	if(setting.getFont() != null){
    	   if(getStyle() == null){
    		   setStyle(new HSSFWorkbook().createCellStyle());
    	   }
    			getStyle().setFont(setting.getFont());
    	}
        exportExcel("TZexcel", headers, dataset, out, pattern);
    }
    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     * 
     * @param title
     *            表格标题名
     * @param headers
     *            表格属性列名数组
     * @param dataset
     *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out
     *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern
     *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    @SuppressWarnings("unchecked")
    public void exportExcel(String title, String[] headers,
            Collection<T> dataset, OutputStream out, String pattern) {
        HSSFWorkbook workbook = new HSSFWorkbook(); // 声明一个工作薄
        HSSFSheet sheet = workbook.createSheet(title); // 生成一个表格
        sheet.setDefaultColumnWidth(cellWidth);  // 设置表格默认列宽度为15个字节
        HSSFRow row = sheet.createRow(0); // 产生表格标题行
        
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            if(style != null){
             cell.setCellStyle(style);
            }
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) it.next();
            if(t instanceof HashMap){
             setDateByMap(t, row, pattern);
            }else{
             setDateByList(t, row, pattern);
            }
        }
        try {
            workbook.write(out);
        } catch (IOException e) {
          logger.error("文件流读出失败",e);
        }

    }
    /**通过map设置数据**/
    @SuppressWarnings("unchecked")
	private void setDateByMap(T t, HSSFRow row, String pattern) {
    	try{
			Map<Integer,String> map = (Map<Integer, String>) t;
			for(int i=0;i<map.size();i++){
			   HSSFCell cell = row.createCell(i);
			   String a = map.get(i);
			   cell.setCellValue(a);
			}
		}catch(Exception e){
			logger.error("遍历map失败,请联系开发人员",e);
		}
	}
     /**通过List设置数据**/
	public void setDateByList(T t, HSSFRow row,String pattern ){
    	// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
        Field[] fields = t.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            HSSFCell cell = row.createCell(i);
            if(style != null){
            cell.setCellStyle(style);
            }
            Field field = fields[i];
            String fieldName = field.getName();
            String getMethodName = "get"
                    + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);
            try {
                Class tCls = t.getClass();
                Method getMethod = tCls.getMethod(getMethodName);
                Object value = getMethod.invoke(t);
                // 判断值的类型后进行强制类型转换
                String textValue = null;
                if(value instanceof Date) {
                    Date date = (Date) value;
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    textValue = sdf.format(date);
                } 	
                else {
                    textValue = value.toString(); // 其它数据类型都当作字符串简单处理
                }
                if(textValue != null){
                	String pat ="[1-9]//d*//.?//d*|0//.//d*[1-9]";
                    Pattern p = Pattern.compile(pat);
                    Matcher matcher = p.matcher(textValue);
                    if (matcher.matches()) {
                        cell.setCellValue(Double.parseDouble(textValue));
                    }
                    else{
                        cell.setCellValue(textValue);
                    }
                }
                cell.setCellValue(textValue);
            }  catch (NoSuchMethodException e) {
               logger.error("javaBean 方法不规范，找不到方法",e);
            } catch (IllegalArgumentException e) {
                logger.error("未能获取值",e);
            } catch (IllegalAccessException e) {
                logger.error("未能获取值",e);
            } catch (InvocationTargetException e) {
                 logger.error("未能获取值",e);
            }
        }

    }
	
	public void test( ExcelWriter<Student> ex){
        String[] headers = { "学号", "姓名", "年龄", "性别", "出生日期" };
        List<Student> dataset = new ArrayList<Student>();
        dataset.add(new Student(10000001, "张三", 20, true, new Date()));
        dataset.add(new Student(20000002, "李四", 24, false, new Date()));
        dataset.add(new Student(30000003, "王五", 22, true, new Date()));
         try{
            OutputStream out2 = new FileOutputStream("E://b.xls");
            ex.exportExcel(headers, dataset, out2);
            out2.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public void test2( ExcelWriter<Map<Integer,String>> ex){
      String[] headers = { "学号", "姓名", "年龄", "性别", "出生日期" };
      Map<Integer,String> map = new HashMap<Integer, String>();
      map.put(0, "10000001");
      map.put(1, "张三");
      map.put(2,"20");
      map.put(3,"true");
      map.put(4, "2015-12-30");
      List<Map<Integer,String>> dataset =new ArrayList<Map<Integer,String>>();
      dataset.add(map);
       try{
          OutputStream out2 = new FileOutputStream("E://b.xls");
          ex.exportExcel(headers, dataset, out2);
          out2.close();
      } catch (FileNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
	}

    public static void main(String[] args) {
    	 // ExcelWriter<Student> ex = new ExcelWriter<Student>();
    	  ExcelWriter<Map<Integer, String>> ex = new ExcelWriter<Map<Integer,String>>();
    	  ex.test2(ex);
    }

	public HSSFCellStyle getStyle() {
		return style;
	}

	public void setStyle(HSSFCellStyle style) {
		this.style = style;
	}

	public HSSFFont getFont() {
		return font;
	}

	public void setFont(HSSFFont font) {
		this.font = font;
	}

	public int getCellWidth() {
		return cellWidth;
	}

	public void setCellWidth(int cellWidth) {
		this.cellWidth = cellWidth;
	}
}