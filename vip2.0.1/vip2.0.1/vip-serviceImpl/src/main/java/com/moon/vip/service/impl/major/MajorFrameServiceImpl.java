package com.moon.vip.service.impl.major;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.moon.vip.application.major.MajorFrameMapper;
import com.moon.vip.application.sys.RoleMapper;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.sys.MajorFrameVO;
import com.moon.vip.service.impl.sys.orgManage.ClearAllOrganizationData;
import com.moon.vip.service.major.IMajorFrameService;
import com.moon.vip.service.sys.IClearCacheService;

/**
 * 专业框架service层
 * @author wesley
 *
 */
@Service("majorFrameService")
public class MajorFrameServiceImpl implements IMajorFrameService {
	
	@Autowired
	MajorFrameMapper majorFrameMapper;
	
	@Autowired
	IClearCacheService clearCacheService;
	@Autowired
	ClearAllOrganizationData clearAllOrganizationData;
	@Autowired
	RoleMapper roleMapper;
	
	private static Logger log=Logger.getLogger(MajorFrameServiceImpl.class);
	
	/**   
	 * @方法名: selectInfoById   
	 * @描述: 初始化树 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:51:33   
	 */  
	public List<MajorFrameVO> selectInfoById(String idStr) {
		List<String> idList=new ArrayList<String>();
		String[] strList=idStr.split(",");
		for(String id:strList){
			idList.add(id);
		}
		
		return majorFrameMapper.selectInfoById(idList);
	}

	/**   
	 * @方法名: deleteById   
	 * @描述: 删除职能实现方法
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:51:40   
	 */  
	public int deleteById(Integer id) {
		int i = checkPidIsNotExistChildId(id);
		if (i == 0) {
			int totals=majorFrameMapper.deleteById(id);// return 1代表删除成功 return
			clearAllOrganizationData.cleanAllOrganizationData(); 
			return totals;
		} else {
			return -1;
		}
	}

	/**   
	 * @方法名: deleteMajorById   
	 * @描述: 根据专业Id删除专业 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:51:57   
	 */  
	public int deleteMajorById(Integer id) {
		int totals=majorFrameMapper.deleteById(id);// return 1代表删除成功 return
		majorFrameMapper.deleteMajorTeacherAndAdviser(id);
		clearAllOrganizationData.cleanAllOrganizationData(); 
		return totals;
	}

	/**   
	 * @方法名: rename   
	 * @描述: 重命名 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:52:05   
	 */  
	public int rename(MajorFrameVO majorFrame) {
		int i = majorFrameMapper.checkNameIsNotExist(majorFrame.getName());
		if (i == 0) {
			int totals=majorFrameMapper.rename(majorFrame);
			clearAllOrganizationData.cleanAllOrganizationData(); 
			return totals;
		} else {
			return -1;
		}
	}

	/**   
	 * @方法名: updateMajor   
	 * @描述: 修改专业信息 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:52:12   
	 */  
	public int updateMajor(MajorFrameVO majorFrameVo,List<MajorFrameVO> adviserList,List<MajorFrameVO> teacherList) {
		int i =0;
		i = checkNewMajorNameIsNotExist(majorFrameVo);
		if(null!=majorFrameVo.getMajorName()&&!("".equals(majorFrameVo.getMajorName()))&&majorFrameVo.getMajorName().equals(majorFrameVo.getName())){//如果没有修改名字 那就可以修改
			i=0;
		}
		int j=0;
		j=majorFrameMapper.selectMajorCodeValueIsNotExist(majorFrameVo);
		if(j>0){
			return -2;
		}
		if (i == 0&&j == 0) {
			majorFrameMapper.deleteMajorTeacherAndAdviser(majorFrameVo.getId());
			majorFrameMapper.addTeacherOrAdviser(adviserList);
			majorFrameMapper.addTeacherOrAdviser(teacherList);
			int totals=majorFrameMapper.updateMajor(majorFrameVo);
			clearAllOrganizationData.cleanAllOrganizationData(); 
			return totals;
		} else {
			return -1;
		}
	}

	/**   
	 * @方法名: checkPidIsNotExistChildId   
	 * @描述: 查询选中节点下是否有子节点 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:52:21   
	 */  
	public int checkPidIsNotExistChildId(Integer id) {
		return majorFrameMapper.checkPidIsNotExistChildId(id);
	}

	/**   
	 * @方法名: addBranch   
	 * @描述: 增加职能 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:52:27   
	 */  
	public int addBranch(MajorFrameVO majorFrame) {
		int i = majorFrameMapper.checkNameIsNotExist(majorFrame.getName());// 判断职能名字是否存在 1为存在
		if (i == 1) {
			return -1; // 存在 直接返回-1 表示插入失败
		}
		int totals=majorFrameMapper.addBranch(majorFrame);
		clearAllOrganizationData.cleanAllOrganizationData(); 
		return totals;
	}


	/**   
	 * @方法名: addMajor   
	 * @描述: 增加专业 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:52:35   
	 */  
	public int addMajor(MajorFrameVO majorFrame) {
		MajorFrameVO majorFrameVo=new MajorFrameVO();
		int i = majorFrameMapper.checkNameIsNotExist(majorFrame.getName());//校验专业名称是否存在
		log.info(String.format("校验专业名称是否存在,返回结果:[%s] 参数:[%s]",i,majorFrame.getName()));
		if (i >= 1) {
			return -1;
		}
		majorFrameVo.setMajorCodeValue(majorFrame.getMajorCodeValue());
		int j=majorFrameMapper.selectMajorCodeValueIsNotExist(majorFrameVo);
		if(j>0){
			return -2;
		}
		majorFrameMapper.addMajor(majorFrame);
		clearAllOrganizationData.cleanAllOrganizationData(); 
		return majorFrame.getId();
	}

	/**   
	 * @方法名: addMajorCode   
	 * @描述: 增加专业代码 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:52:43   
	 */  
	public int addMajorCode(MajorFrameVO majorFrameVo) {
		int count=majorFrameMapper.selectMajorCodeValueIsNotExist(majorFrameVo);
		if(count>0){
			return -1;
		}
		int totals=majorFrameMapper.addMajorCode(majorFrameVo);
		clearAllOrganizationData.cleanAllOrganizationData(); 
		return totals;
	}
	
	/**   
	 * @方法名: updateMajorCode   
	 * @描述: 修改专业代码 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:52:50   
	 */  
	public int updateMajorCode(MajorFrameVO majorFrameVo) {
		int i=majorFrameMapper.selectMajorCodeIsNotExist(majorFrameVo); //判断是否为老数据 如果没有专业代码就进行新增
		int index;
		if(i==1){
			int count=majorFrameMapper.selectMajorCodeValueIsNotExist(majorFrameVo);
			if (majorFrameVo.getOldCode().equals(majorFrameVo.getMajorCodeValue())){
				return 1;
			}
			if (count>0){
				index=-1;
				return index;
			}
			int totals=majorFrameMapper.updateMajorCode(majorFrameVo);
			clearAllOrganizationData.cleanAllOrganizationData(); 
			return totals;
		}else{
			int count=majorFrameMapper.selectMajorCodeValueIsNotExist(majorFrameVo);
			if (majorFrameVo.getOldCode().equals(majorFrameVo.getMajorCodeValue())){
				return 1;
			}
			if (count>0){
				index=-1;
				return index;
			}
			int totals=majorFrameMapper.addMajorCode(majorFrameVo);
			clearAllOrganizationData.cleanAllOrganizationData(); 
			return totals;
		}
		
	}

	/**   
	 * @方法名: checkNewMajorNameIsNotExist   
	 * @描述: 校验新的专业名称是否存在
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:53:02   
	 */  
	public int checkNewMajorNameIsNotExist(MajorFrameVO majorFrameVo) {
		return majorFrameMapper.checkNewMajorNameIsNotExist(majorFrameVo);
	}

	/**   
	 * @方法名: searchContent   
	 * @描述: 搜索 查询
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:53:29   
	 */  
	public List<MajorFrameVO> searchContent(MajorFrameVO majorFrameVo) {
		log.info(String.format("专业框架进行搜索,参数:[%s]", majorFrameVo.toString()));
		return majorFrameMapper.searchContent(majorFrameVo);
	}
	
	/**   
	 * @方法名: getSearchCount   
	 * @描述:搜索查询总条数 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:53:36   
	 */  
	public int getSearchCount(MajorFrameVO majorFrameVo){
		return majorFrameMapper.getSearchCount(majorFrameVo);
	}
	
	/**   
	 * @方法名: selectBranchAndColony   
	 * @描述: 根据部门ID查询部门和集群 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:53:51   
	 */  
	public	MajorFrameVO selectBranchAndColony(MajorFrameVO majorFrameVo){
		return majorFrameMapper.selectBranchAndColony(majorFrameVo);
	}

	/**   
	 * @方法名: selectTeacherOrAdviser   
	 * @描述: 查询讲师或者班主任
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:53:59   
	 */  
	public List<MajorFrameVO> selectTeacherOrAdviser(MajorFrameVO majorFrameVo) {
		return majorFrameMapper.selectTeacherOrAdviser(majorFrameVo);
	}
	
	/**   
	 * @方法名: selectAppointPerson   
	 * @描述: 查询出所有的机构负责人 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:08:31   
	 */  
	public List<MajorFrameVO> selectAppointPerson() {
		Integer id=roleMapper.selectRoleIdByCode("orgLeader"); //获得机构负责人对应的ID
		return majorFrameMapper.selectAppointPerson(id);
	}
	
	/**   
	 * @方法名: selectAppointPersonById   
	 * @描述: 查询职能对应的负责人 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:08:42   
	 */  
	public List<MajorFrameVO> selectAppointPersonById(MajorFrameVO majorFrameVo) {
		Integer id=roleMapper.selectRoleIdByCode("orgLeader"); //获得机构负责人对应的ID
		majorFrameVo.setRoleId(id);
		log.info(String.format("查询职能对应的负责人获取权限ID:[%s]", id));
		return majorFrameMapper.selectAppointPersonById(majorFrameVo);
	}
	
	/**   
	 * @方法名: addSuperior   
	 * @描述: 批量插入机构负责人 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:08:57   
	 */  
	public int addSuperior(List<MajorFrameVO> majorFrameVoList) {
		Integer roleId=roleMapper.selectRoleIdByCode("orgLeader"); //获得机构负责人对应的ID
		for (MajorFrameVO mfv:majorFrameVoList){
			mfv.setRoleId(roleId);
		}
		int i=majorFrameMapper.addSuperior(majorFrameVoList);
		clearAllOrganizationData.cleanAllOrganizationData();  
		return i;
	}
	/**   
	 * @方法名: deleteSuperior   
	 * @描述: 删除职能下的机构负责人 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:09:05   
	 */  
	public int deleteSuperior(MajorFrameVO majorFrameVo) {
		Integer roleId=roleMapper.selectRoleIdByCode("orgLeader"); //获得机构负责人对应的ID
		majorFrameVo.setRoleId(roleId);
		int i=majorFrameMapper.deleteSuperior(majorFrameVo);
		
		clearAllOrganizationData.cleanAllOrganizationData();  
		return i;
	}
	/**   
	 * @方法名: searchTeacherOrAdviser   
	 * @描述: 搜索讲师或者班主任 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:09:15   
	 */  
	public List<MajorFrameVO> searchTeacherOrAdviser(MajorFrameVO majorFrameVo) {
		return majorFrameMapper.searchTeacherOrAdviser(majorFrameVo);
	}
	/**   
	 * @方法名: getTeacherAndAdviser   
	 * @描述: 获得讲师跟班主任(修改展示)
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:09:22   
	 */  
	public MajorFrameVO getTeacherAndAdviser(MajorFrameVO majorFrameVo) {
		majorFrameVo.setType("teacher");
		MajorFrameVO cab=majorFrameMapper.getTeacherAndAdviser(majorFrameVo);
		if(null==cab.getName()){
			cab.setName("");
		}
		majorFrameVo.setTeacher(cab.getName());
		majorFrameVo.setType("adviser");
		MajorFrameVO ca=majorFrameMapper.getTeacherAndAdviser(majorFrameVo);
		if(null==ca.getName()){
			ca.setName("");
		}
		majorFrameVo.setAdviser(ca.getName());
		return majorFrameVo;
	}
	/**   
	 * @方法名: getUpdateTeacherListOrAdviserList   
	 * @描述:获得修改时的未被选中的讲师
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:09:36   
	 */  
	public List<MajorFrameVO> getUpdateTeacherListOrAdviserList(MajorFrameVO majorFrameVo) {
		return	majorFrameMapper.getUpdateTeacherListOrAdviserList(majorFrameVo);
	}
	/**   
	 * @方法名: getChooseTeacherListOrAdviserList   
	 * @描述: 获得修改时的被选中的讲师
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:10:05   
	 */  
	public List<MajorFrameVO> getChooseTeacherListOrAdviserList(MajorFrameVO majorFrameVo) {
		return majorFrameMapper.getChooseTeacherListOrAdviserList(majorFrameVo);
	}
	
	/**   
	 * @方法名: addTeacherOrAdviser   
	 * @描述: 增加讲师或者班主任 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:55:55   
	 */  
	public int addTeacherOrAdviser(List<MajorFrameVO> majorFrameVoList) {
		int i =majorFrameMapper.addTeacherOrAdviser(majorFrameVoList);
		clearAllOrganizationData.cleanAllOrganizationData();  
		return i;
	}

	/**   
	 * @方法名: selectTeacherOrAdviserByCode   
	 * @描述: 查询复选框中employee对应的老师或班主任名字 
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:56:07   
	 */  
	public MajorFrameVO selectTeacherOrAdviserByCode(List<String> list) {
		return majorFrameMapper.selectTeacherOrAdviserByCode(list);
	}

	/**   
	 * @方法名: updateOrganizationPid   
	 * @描述: 拖拽节点
	 * @作者: wesley        
	 * @日期:2016年4月26日下午4:56:36   
	 */  
	public int updateOrganizationPid(MajorFrameVO majorFrame) {
		return majorFrameMapper.updateOrganizationPid(majorFrame);
	}
	/**   
	 * @方法名: getClassInfo   
	 * @描述: 获得班级信息  
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午9:01:01   
	 */  
	public List<MajorFrameVO> getClassInfo(MajorFrameVO majorFrame){
		return majorFrameMapper.getClassInfo(majorFrame);
	}
	
	/**   
	 * @方法名: getClassCount   
	 * @描述: 获得班级总数
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午9:27:39   
	 */  
	public Integer getClassCount(MajorFrameVO majorFrame){
		return majorFrameMapper.getClassCount(majorFrame);
	}
	/**   
	 * @方法名: addClass   
	 * @描述: 新增班级
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午9:27:39   
	 */ 
	public Integer addClass(MajorFrameVO majorFrame) {
		int i = majorFrameMapper.checkNameIsNotExist(majorFrame.getClassName());//校验专业名称是否存在
		log.info(String.format("校验专业名称是否存在,返回结果:[%s] 参数:[%s]",i,majorFrame.getClass()));
		if(i>=1){
			throw new BusinessException("该名称已经存在");
		}
		log.info(String.format("新增班级参数[%s]", majorFrame.toString()));
		majorFrameMapper.addClass(majorFrame);
		log.info(String.format("新增得到的班级ID[%s]", majorFrame.getId()));
		if(majorFrame.getId()<=0){
			throw new BusinessException("新增班级失败");
		}
		//如果新增的班级存在班主任和讲师 删除
		deleteTeacherAndAdviser(majorFrame.getId());
		majorFrame.setType("teacher");
		majorFrame.setEmployeeCode(majorFrame.getTeacher());
		//插入讲师
		addClassTeacherOrAdviser(majorFrame); 
		majorFrame.setType("adviser");
		majorFrame.setEmployeeCode(majorFrame.getAdviser());
		//插入班主任
		addClassTeacherOrAdviser(majorFrame);
		clearAllOrganizationData.cleanAllOrganizationData();  
		return majorFrame.getId();
	}
	
	
	/**   
	 * @方法名: addClassTeacherOrAdviser   
	 * @描述: 增加班级的班主任或者讲师 
	 * @作者:  wesley        
	 * @日期:2016年4月27日下午7:30:31   
	 */  
	public Integer addClassTeacherOrAdviser(MajorFrameVO majorFrame){
		return majorFrameMapper.addClassTeacherOrAdviser(majorFrame);
	}
	
	
	/**   
	 * @方法名: deleteTeacherAndAdviser   
	 * @描述: 根据Id删除班主任和讲师
	 * @作者:  wesley        
	 * @日期:2016年4月27日下午7:44:48   
	 */  
	public Integer deleteTeacherAndAdviser(Integer id){
		return majorFrameMapper.deleteTeacherAndAdviser(id);
	}
	public List<MajorFrameVO> filterMajorFrame(List<MajorFrameVO> sourceList, HashSet<Integer> powerOrgList) {
		List<MajorFrameVO> retList = Lists.newArrayList();
		for(MajorFrameVO major : sourceList) {
			if(powerOrgList.contains(major.getId())) {
				retList.add(major);
			}
		}
		return retList;
	}

}
