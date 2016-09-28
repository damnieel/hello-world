package com.moon.vip.infra.vo.sys;

import java.io.Serializable;

public class IVStatisticVO implements Serializable{
	/** 
	* @Fields serialVersionUID : TODO( ) 
	*/ 
	private static final long serialVersionUID = 2812825982963336434L;
	private ComponentVO componentVO;
	private LearningAimVO learningAimVO;
	public ComponentVO getComponentVO() {
		return componentVO;
	}
	public void setComponentVO(ComponentVO componentVO) {
		this.componentVO = componentVO;
	}
	public LearningAimVO getLearningAimVO() {
		return learningAimVO;
	}
	public void setLearningAimVO(LearningAimVO learningAimVO) {
		this.learningAimVO = learningAimVO;
	}
	@Override
	public String toString() {
		return "IVStatisticVO [componentVO=" + componentVO + ", learningAimVO=" + learningAimVO + "]";
	}
	
	
	
}
