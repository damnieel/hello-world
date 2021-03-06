package com.moon.vip.service.impl.student;


import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.moon.vip.application.student.StudentClassMapper;
import com.moon.vip.application.student.StudentFilesMapper;
import com.moon.vip.application.student.StudentProfessionalAttachMapper;
import com.moon.vip.application.student.StudentProfessionalMapper;
import com.moon.vip.infra.util.UpFileUtil;
import com.moon.vip.infra.vo.Message;
import com.moon.vip.infra.vo.student.StudentClassVO;
import com.moon.vip.infra.vo.student.StudentFilesVO;
import com.moon.vip.infra.vo.student.StudentLearnStateVO;
import com.moon.vip.infra.vo.sys.SearchVO;
import com.moon.vip.model.student.StudentClass;
import com.moon.vip.model.student.StudentProfessional;
import com.moon.vip.model.student.StudentProfessionalAttach;
import com.moon.vip.service.student.IStudentFilesService;
@Service("iStudentFilesService")
public class StudentFilesServiceImpl implements IStudentFilesService {
	private static Logger logger = Logger.getLogger(StudentFilesServiceImpl.class);
	@Autowired 
	private StudentFilesMapper studentFilesMapper;
	@Autowired 
	private StudentProfessionalMapper studentProfessionalMapper;
	@Autowired 
	private StudentClassMapper studentClassMapper;
	@Autowired
	private StudentProfessionalAttachMapper attachMapper;
	@Autowired	
	private UpFileUtil upload;
	
	private final static String SUCCESS="success";
	private final static String FAIL="fail";
	/**
	 * 查询档案分页数据
	 */
	public List<StudentFilesVO> getAllFileInfo(SearchVO param) {
		if(null==param){
			return studentFilesMapper.selectFileList(null);
		}
		if(!StringUtils.isEmpty(param.getKeyWord())){
			String keyWord = "%"+param.getKeyWord()+"%";
			param.setKeyWord(keyWord);
		}else{
			param.setKeyWord(null);
		}
		return studentFilesMapper.selectFileList(param);
	}
	/**
	 * 查询档案分页总数
	 */
	public int selectTotalRecord(SearchVO param) {
		if(null==param){
			return studentFilesMapper.selectTotalRecord(null);
		}
		if(!StringUtils.isEmpty(param.getKeyWord())){
			String keyWord = "%"+param.getKeyWord()+"%";
			param.setKeyWord(keyWord);
		}else{
			param.setKeyWord(null);
		}
		return studentFilesMapper.selectTotalRecord(param);
	}	
	/**
	 * 第一页
	 */
	public StudentFilesVO getStudentFilesInfo(Integer id) {
		return studentFilesMapper.selectFilesInfoById(id);
	}
    
	public int updateStudyBasis(Integer id,String stuBasis) {
		return studentFilesMapper.updateStudyBasisById(id, stuBasis);
	}
	/**
	 * 第二页
	 */
	public StudentLearnStateVO  getLearningStateInfo(Integer id) {
		
		return studentFilesMapper.selectLearningInfoById(id);
	}

	public List<StudentClassVO> getStudentClassInfo(Integer studentId) {
		return studentFilesMapper.selectClassInfoById(studentId);
	}
	
	public Message updateLearningStateInfo(StudentProfessional record,List<Integer> idList,List<Double> scList) {
		Message msg=new Message();
		int result=0;
		StudentClass clsBean=new StudentClass();
		for(int i=0;i<idList.size();i++){
			clsBean.setScore(scList.get(i));
			clsBean.setId(idList.get(i));
			result+=studentClassMapper.updateByPrimaryKeySelective(clsBean);
		}
		if(result<0){
			msg.setResult(FAIL);
			msg.setMsg("更新失败");
			return msg;
		}
		result=studentProfessionalMapper.updateByPrimaryKeySelective(record);
		if(result<0){
			msg.setResult(FAIL);
			msg.setMsg("更新失败");
			return msg;
		}
		msg.setResult(SUCCESS);
		msg.setMsg("更新成功");
		return msg;
	}
	
	public Message updateLearningStateInfo(StudentProfessional record) {
		Message msg=new Message();
		int result=studentProfessionalMapper.updateByPrimaryKeySelective(record);
		if(result<0){
			msg.setResult(FAIL);
			msg.setMsg("更新失败");
			return msg;
		}
		msg.setResult(SUCCESS);
		msg.setMsg("更新成功");
		return msg;
	}
	
	
	public int updateStudentClassInfo(StudentClass record) {
		
		return studentClassMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 第三页
	 */
	public StudentFilesVO getIdCardPic(Integer id) {
		return studentFilesMapper.selectIdCardPicById(id);
	}
	/**
	 * 第四页第五页
	 */

	public int insertProfessionalAttach(StudentProfessionalAttach attach) {
		return attachMapper.insertSelective(attach);
	}
	public int deleteProfessionalAttach(Integer id) {
		
		StudentProfessionalAttach spa=	studentFilesMapper.selectProfessionalAttachById(id);
		String url=spa.getUrlAddress();
		try {
			upload.deleteFile(url, new HashMap<String, String>());
		} catch (Exception e) {
			logger.error("物理删除文件失败"+"错误地址"+url+e.getMessage());
			e.printStackTrace();
		}
		return attachMapper.deleteByPrimaryKey(id);
	}
	public List<StudentProfessionalAttach> queryProfessionalAttach(Integer spId,String type) {
		return studentFilesMapper.selectProfessionalAttach(spId,type);
	}
	
	
}
