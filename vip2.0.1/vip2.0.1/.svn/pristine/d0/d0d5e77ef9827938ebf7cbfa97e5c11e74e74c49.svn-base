package com.moon.vip.application.major;

import java.util.List;

import com.moon.vip.infra.vo.sys.MajorFrameVO;

public interface MajorFrameMapper {
	/**   
	 * @方法名: addBranch   
	 * @描述: 增加节点 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:44:11   
	 */  
	int addBranch(MajorFrameVO majorFrame);
	
	/**   
	 * @方法名: selectInfoById   
	 * @描述: 初始化树的数据
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:44:17   
	 */  
	List<MajorFrameVO> selectInfoById(List<String> idList);


	/**   
	 * @方法名: deleteById   
	 * @描述: 删除职能 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:44:35   
	 */  
	int deleteById(Integer id);

	/**   
	 * @方法名: checkNameIsNotExist   
	 * @描述: 校验名字是否存在
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:45:20   
	 */  
	int checkNameIsNotExist(String name);

	/**   
	 * @方法名: checkPidIsNotExistChildId   
	 * @描述: 校验父节点下是否有子节点 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:45:27   
	 */  
	int checkPidIsNotExistChildId(Integer id);

	/**   
	 * @方法名: rename   
	 * @描述: 重命名 
	 * @作者: wesley         
	 * @日期:2016年4月26日下午3:28:37   
	 */  
	int rename(MajorFrameVO name);

	/**   
	 * @方法名: updateMajor   
	 * @描述: 修改专业信息 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:45:35   
	 */  
	int updateMajor(MajorFrameVO name);
	/**   
	 * @方法名: selectMajorById   
	 * @描述: 查询部门下的专业 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:45:42   
	 */  
	List<MajorFrameVO> selectMajorById(MajorFrameVO majorFrameVo);
	/**   
	 * @方法名: addMajor   
	 * @描述: 增加专业 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:45:51   
	 */  
	int addMajor(MajorFrameVO majorFrame);
	
	/**   
	 * @方法名: addMajorCode   
	 * @描述: 增加专业代码
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:45:59   
	 */  
	int addMajorCode(MajorFrameVO majorFrameVo);
	/**   
	 * @方法名: checkNewMajorNameIsNotExist   
	 * @描述: 校验新输入的专业名称是否存在 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:46:07   
	 */  
	int checkNewMajorNameIsNotExist(MajorFrameVO majorFrameVo);
	/**   
	 * @方法名: updateMajorCode   
	 * @描述: 修改专业代码 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:46:15   
	 */  
	int updateMajorCode(MajorFrameVO majorFrameVo);
	
	/**   
	 * @方法名: selectMajorCodeIsNotExist   
	 * @描述: 查看专业代码是否存在 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:46:24   
	 */  
	int selectMajorCodeIsNotExist(MajorFrameVO majorFrameVo);
	
	/**   
	 * @方法名: searchContent   
	 * @描述: 模糊查询 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:46:32   
	 */  
	List<MajorFrameVO> searchContent(MajorFrameVO majorFrameVo);
	
	/**   
	 * @方法名: getSearchCount   
	 * @描述: 模糊查询总条数 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:46:39   
	 */  
	int getSearchCount(MajorFrameVO majorFrameVo);
	
	/**   
	 * @方法名: selectMajorCodeValueIsNotExist   
	 * @描述: 查看专业代码value是否存在 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:46:47   
	 */  
	int selectMajorCodeValueIsNotExist (MajorFrameVO colonyAndBranch);

	/**   
	 * @方法名: selectBranchAndColony   
	 * @描述: 根据部门ID查询部门和集群 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:46:53   
	 */  
	MajorFrameVO selectBranchAndColony(MajorFrameVO majorFrameVo);
	
	/**   
	 * @方法名: selectTeacherOrAdviser   
	 * @描述: 查询所有老师或者班主任 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:46:59   
	 */  
	List<MajorFrameVO> selectTeacherOrAdviser(MajorFrameVO majorFrameVo);
	
	/**   
	 * @方法名: selectTeacherOrAdviserByCode   
	 * @描述: 查询复选框中employee对应的老师或班主任名字 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:47:05   
	 */  
	MajorFrameVO selectTeacherOrAdviserByCode(List<String> list);
	
	/**   
	 * @方法名: addTeacherOrAdviser   
	 * @描述: 增加讲师或者班主任 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:47:12   
	 */  
	int addTeacherOrAdviser(List<MajorFrameVO> colonyAndBranchList);
	
	/**   
	 * @方法名: selectAppointPerson   
	 * @描述: 查询出所有的机构负责人 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:47:22   
	 */  
	List<MajorFrameVO> selectAppointPerson(Integer id);
	
	/**   
	 * @方法名: selectAppointPersonById   
	 * @描述: 查询出所有的机构负责人 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:47:28   
	 */  
	List<MajorFrameVO> selectAppointPersonById(MajorFrameVO majorFrameVo);
	
	/**   
	 * @方法名: addSuperior   
	 * @描述: 批量插入机构负责人 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:47:56   
	 */  
	int addSuperior(List<MajorFrameVO> colonyAndBranchList);
	
	/**   
	 * @方法名: deleteSuperior   
	 * @描述: 删除职能下的机构负责人 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:48:04   
	 */  
	int deleteSuperior(MajorFrameVO majorFrameVo);

	/**   
	 * @方法名: searchTeacherOrAdviser   
	 * @描述: 搜索讲师或者班主任 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:48:11   
	 */  
	List<MajorFrameVO> searchTeacherOrAdviser(MajorFrameVO majorFrameVo);
	
	/**   
	 * @方法名: getTeacherAndAdviser   
	 * @描述: 获得讲师跟班主任(修改展示) 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:48:25   
	 */  
	MajorFrameVO getTeacherAndAdviser(MajorFrameVO majorFrameVo);
	
	/**   
	 * @方法名: deleteMajorTeacherAndAdviser   
	 * @描述: 删除专业的讲师和班主任 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:48:34   
	 */  
	int deleteMajorTeacherAndAdviser(Integer id);
	
	
	/**   
	 * @方法名: getUpdateTeacherListOrAdviserList   
	 * @描述: 获得修改专业时未被选中的讲师和班主任
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:48:48   
	 */  
	List<MajorFrameVO> getUpdateTeacherListOrAdviserList(MajorFrameVO majorFrameVo);
	
	
	/**   
	 * @方法名: getChooseTeacherListOrAdviserList   
	 * @描述: 获得修改专业时被选中的讲师和班主任 
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午4:49:03   
	 */  
	List<MajorFrameVO> getChooseTeacherListOrAdviserList(MajorFrameVO majorFrameVo);
	
	/**   
	 * @方法名: updateOrganizationPid   
	 * @描述: 拖拽节点
	 * @作者: wesley   
	 * @日期:2016年4月21日下午7:55:13   
	 */  
	int updateOrganizationPid(MajorFrameVO majorFrame);
	
	
	/**   
	 * @方法名: getClassInfo   
	 * @描述: 获得班级信息  
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午9:01:01   
	 */  
	List<MajorFrameVO> getClassInfo(MajorFrameVO majorFrame);
	
	/**   
	 * @方法名: getClassCount   
	 * @描述: 获得班级总数
	 * @作者:  wesley        
	 * @日期:2016年4月26日下午9:27:39   
	 */  
	Integer getClassCount(MajorFrameVO majorFrame);
	
	/**   
	 * @方法名: addClass   
	 * @描述: 新增班级
	 * @作者:  wesley        
	 * @日期:2016年4月27日下午5:34:17   
	 */  
	Integer addClass(MajorFrameVO majorFrame);
	
	/**   
	 * @方法名: addClassTeacherOrAdviser   
	 * @描述: 增加班级的讲师或者班主任
	 * @作者:  wesley        
	 * @日期:2016年4月27日下午7:27:02   
	 */  
	Integer addClassTeacherOrAdviser(MajorFrameVO majorFrame);
	
	/**   
	 * @方法名: deleteTeacherAndAdviser   
	 * @描述: 根据op_ID删除班主任和讲师
	 * @作者:  wesley        
	 * @日期:2016年4月27日下午7:42:36   
	 */  
	Integer deleteTeacherAndAdviser(Integer id);
}
