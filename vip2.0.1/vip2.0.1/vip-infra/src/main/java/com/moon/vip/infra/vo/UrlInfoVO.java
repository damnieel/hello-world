package com.moon.vip.infra.vo;

import com.moon.vip.infra.constants.EnumAuthAction;

public class UrlInfoVO {
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param type 增删查改类型
	* @param parameter 需要拦截的参数名称 如果为路径参数，传：roadPath
	* @param parameterType  部门组织机构Id : org  专业表ID: pro  班级表Id :cla  学生 Id :stu
	 */
	public UrlInfoVO (EnumAuthAction type,String parameter,String parameterType){
		/*setUrl(url);*/
		setType(type);
		setParameter(parameter);
		setParameterType(parameterType);
	}
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param type 增删查改类型
	* @param parameter 需要拦截的参数名称 如果为路径参数，传：roadPath
	* @param parameterType  部门组织机构Id : org  专业表ID: pro  班级表Id :cla  学生 Id :stu
	* @param position 如果存在多个路径参数，指定其中一个，倒数第一个传1；倒数第二个传2，类推
	 */
	public UrlInfoVO (EnumAuthAction type,String parameter,String parameterType,Integer position){
		/*setUrl(url);*/
		setType(type);
		setParameter(parameter);
		setParameterType(parameterType);
		setPosition(position);
	}
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param type 增删查改类型
	* @param parameter 需要拦截的参数名称 如果为路径参数，传：roadPath
	* @param parameterType  部门组织机构Id : org  专业表ID: pro  班级表Id :cla  学生 Id :stu
	* @param position 如果存在多个路径参数，指定其中一个，倒数第一个传1；倒数第二个传2，类推
	* @param isCollection 如果该String 类型是一个需要解析的集合，设置为true
	 */
	public UrlInfoVO (EnumAuthAction type,String parameter,String parameterType,boolean isCollection){
		/*setUrl(url);*/
		setType(type);
		setParameter(parameter);
		setParameterType(parameterType);
		setCollection(isCollection);
	}
	/**
	 *  标准的url参数
	 */
	private String url;
	
	/**
	 * 增删查改类型  
	 */
	private EnumAuthAction type;
	
	
	/**
	 * 需要判断的参数,路径参数传：roadPath
	 */
	private String parameter;
	
	/**
	 * 参数类型   部门组织机构Id : org  专业表ID: pro  班级表Id :cla  学生 Id :stu
	 */
	
	private String parameterType;
	
	/**
	 * 是否是集合
	 */
	private boolean isCollection = false;
	
	/**
	 * 路径参数如果有2个或以上，还需要传是哪一个,倒数第一个传1；倒数第二个传2，类推
	 */
	private int position = 1;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public EnumAuthAction getType() {
		return type;
	}

	public void setType(EnumAuthAction type) {
		this.type = type;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		if(position !=null){
		 this.position = position;
		}
	}
	public boolean isCollection() {
		return isCollection;
	}
	public void setCollection(boolean isCollection) {
		this.isCollection = isCollection;
	}
	
	
	

}
