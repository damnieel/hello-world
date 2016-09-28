package com.moon.vip.infra.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.log4j.Logger;

import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.excel.UploadStudentVO;

public class ClassUtil {
	
	private static Logger logger = Logger.getLogger(ClassUtil.class);
	@SuppressWarnings("unchecked")
	public static Object getDataFromMap(Map<Integer, String> m, 
												Class vo) 
				throws IllegalAccessException, IllegalArgumentException, 
				InvocationTargetException, ParseException, NoSuchMethodException, SecurityException, InstantiationException {
		Object object = null;
		boolean begin = false;
		int index = 0;
				
		object = vo.getConstructor(new Class[] {}).newInstance(new Object[] {});  
		
		Field[] fields = vo.getDeclaredFields();
		SimpleDateFormat sdf = null;
		for(int i=0; i<fields.length; i++) {
			String fieldName = fields[i].getName();  
			if(fieldName.equalsIgnoreCase(SysConstantsVal.UPLOADFIRSTFIELD)) {//直到name域才开始存储
				begin = true;
				index = i;
			} 
			if(!begin) {
				continue;
			}
			juggNecessaryEm(fieldName, m.get(i-index));
			String firstLetter = fieldName.substring(0,1).toUpperCase();  
			String setMethodName = "set" + firstLetter + fieldName.substring(1);
			Method setMethod = vo.getDeclaredMethod(setMethodName, new Class[]{fields[i].getType()});
			
			if(m.get(i-index) != null) {
				//替换掉字符串中的空格
				String temp = StringUtil.getNormalLine(m.get(i-index));
				temp = temp.replace(" ", "");
				temp = temp.replaceAll("[\\t\\n\\r]", "");
				m.put(i-index, temp);
			}
			
			if(fields[i].getType().getSimpleName().equalsIgnoreCase("String")) {
				setMethod.invoke(object, m.get(i-index));//调用set方法
			} else if(fields[i].getType().getSimpleName().equalsIgnoreCase("double")) {
				if(StringUtil.isNull(m.get(i-index))) {
					throw new BusinessException(EnumCodeException.E0015,
							fieldName + "Double类型， 发现空元素，文档不符合上传文档模板 ——最后一行数据" 
										+ object.toString());
				}
				setMethod.invoke(object, Double.valueOf(m.get(i-index)));
			} else if(fields[i].getType().getSimpleName().equalsIgnoreCase("Date")) {
	
				if(StringUtil.isNull(m.get(i-index))) {
					throw new BusinessException(EnumCodeException.E0015,
							fieldName + "Date类型，发现空元素，文档不符合上传文档模板 ——最后一行数据" 
									+ object.toString());
				}
				String getDate = m.get(i-index);
				sdf = backSdfFormat(getDate);
				if(sdf == null) {
					throw new BusinessException(EnumCodeException.E0015,
							fieldName + "报名时间不符合规范， 请使用‘2015/3/25’形式");
				}
				setMethod.invoke(object, sdf.parse(getDate));
			} else {
				System.out.println("请添加：" 
						+ fields[i].getType().getSimpleName() + "类型");
			}
			logger.info(String.format("调用:%s--", setMethod.getName()) + m.get(i-index));
		}
		logger.info("存储数据： " + object);
		return object;
	}
	
	private static void juggNecessaryEm(String fieldName, String emVal) {
		String necessaryEm = "professionCode, name,"
				+ "telephone, QQ, professionalName, amountPayable, payment, enterDate";
		if(necessaryEm.contains(fieldName)) {
			if(StringUtil.isNull(emVal)) {
				throw new BusinessException(EnumCodeException.E0015,
						fieldName + "为空，请检查Excel文档："
								+ "必填元素；是否数据是否从A列开始；excel数据下面的表格是否有样式改变");
			}
		}
	}

	private static SimpleDateFormat backSdfFormat(String getDate) {
		SimpleDateFormat sdf = null;
		if(getDate.contains("/")) {
			sdf=new SimpleDateFormat("yyyy/MM/dd");
		}
		if(getDate.contains("-")) {
			sdf=new SimpleDateFormat("yyyy-MM-dd");
		} else {
			System.out.println("请添加时间解析方法： " + getDate);
		}
		return sdf;
	}
	
	
	
	
	
	public static void main(String[] args) {
		String str = "吴德月";
		str = str.replaceAll("[\\t\\n\\r]", "");//
		System.out.print(str);
//		Class cl = UploadStudentVO.class;
//		Map<Integer, String> m = new HashMap<Integer, String>();
//		m.put(0, "0");
//		m.put(1, "1");
//		m.put(2, "2");
//		m.put(3, "3");
//		m.put(4, "4");
//		m.put(5, "5");
//		m.put(6, "6");
//		m.put(7, "7");
//		m.put(8, "8");
//		m.put(9, "9");
//		m.put(10, "10");
//		m.put(11, "11");
//		m.put(12, "12");
//		m.put(13, "13");
//		m.put(14, "14");
//		m.put(15, "15");
	}
	
	private static void invokeMethods(Class cl) {
		UploadStudentVO vo = new UploadStudentVO();
		Field fields[] = cl.getDeclaredFields();  
		Method methods[] = cl.getDeclaredMethods();
		String s ="33";
		try {
			for(Method m : methods) {
				if(m.getName().contains("set")) {
					Class[] parameterTypes = m.getParameterTypes();//获得方法所有的参数类型
					String paramName = parameterTypes[0].getSimpleName();
					System.out.println(paramName);
//					System.out.println(m.getName());
				}				
			}	
			System.out.println(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printFields(Class cl) {
		Field[] fields = cl.getDeclaredFields();				//获取该方法的域
		for(Field f: fields) {
			Class type = f.getType();							//该域的类型
			String name = f.getName();						//该域的名称
			
			System.out.print("    ");
			//print modifiers, return type and method anme
			String modifiers = Modifier.toString(f.getModifiers()); 
			if(modifiers.length() > 0) System.out.print(modifiers + " "); //该域的public 修饰符	
			System.out.print(type.getName() + " " + name + ";\n");		  //该域的类型 + 名称
		}
	}
	

	public static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();				//获取该类所有的方法	public void setHeight(java.lang.String);
		for(Method m: methods) {
			Class retType = m.getReturnType();					//获取该方法的返回类型	void
			String name = m.getName();							//方法的名称
			
			System.out.print("    ");
			//print modifiers, return type and method anme
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers + " ");//方法 public static等等
			System.out.print(retType.getName() + " " + name + "(");		//返回类型 + 方法名称
			//print parameter types
			Class[] paramTypes = m.getParameterTypes();					//获取参数类型，该方法可能有多个参数，所以是数组
			for(int j=0; j< paramTypes.length; j++) {
				if(j>0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());				//该参数的类型名称	java.lang.String
			}
			System.out.println(");");
		}
	}
}
