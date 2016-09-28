package com.moon.vip.service.major;

import java.util.HashSet;
import java.util.List;

import com.moon.vip.infra.vo.sys.MajorFrameVO;

public interface IMajorFrameService {
		/**   
		 * @方法名: addBranch   
		 * @描述: 增加节点
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:05:21   
		 */  
		int addBranch(MajorFrameVO majorFrame);
		/**   
		 * @方法名: selectInfoById   
		 * @描述: 根据节点id 查询出对应的信息 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:05:29   
		 */  
		List<MajorFrameVO> selectInfoById(String idStr);
		
		
		/**   
		 * @方法名: addTeacherOrAdviser   
		 * @描述: 增加讲师或者班主任
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:05:50   
		 */  
		int addTeacherOrAdviser(List<MajorFrameVO> MajorFrameVOList);
		
		 
		/**   
		 * @方法名: deleteById   
		 * @描述: 根据节点ID进行删除 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:05:56   
		 */  
		int deleteById(Integer id);
		
		
		/**   
		 * @方法名: deleteMajorById   
		 * @描述:  根据专业ID删除专业 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:06:15   
		 */  
		int deleteMajorById(Integer id);

		/**   
		 * @方法名: checkPidIsNotExistChildId   
		 * @描述: 校验父节点下是否有子节点
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:06:20   
		 */  
		int checkPidIsNotExistChildId(Integer id);

		/**   
		 * @方法名: rename   
		 * @描述: 重命名 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:06:29   
		 */  
		int rename(MajorFrameVO name);

		/**   
		 * @方法名: updateMajor   
		 * @描述: 修改专业信息 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:06:37   
		 */  
		int updateMajor(MajorFrameVO majorFrameVo,List<MajorFrameVO> adviserList,List<MajorFrameVO> teacherList);
		
		/**   
		 * @方法名: addMajor   
		 * @描述:增加专业
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:06:44   
		 */  
		int addMajor(MajorFrameVO majorFrameVo);
		
		/**   
		 * @方法名: addMajorCode   
		 * @描述: 增加专业代码
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:06:53   
		 */  
		int addMajorCode(MajorFrameVO MajorFrameVO);
		
		/**   
		 * @方法名: updateMajorCode   
		 * @描述: 修改专业代码 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:07:02   
		 */  
		int updateMajorCode(MajorFrameVO majorFrameVo);
		
		/**   
		 * @方法名: checkNewMajorNameIsNotExist   
		 * @描述: 校验新专业名称是否存在 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:07:10   
		 */  
		int checkNewMajorNameIsNotExist(MajorFrameVO majorFrameVo);
		
		/**   
		 * @方法名: searchContent   
		 * @描述: 模糊查询
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:07:20   
		 */  
		List<MajorFrameVO> searchContent(MajorFrameVO majorFrameVo);
		
		/**   
		 * @方法名: getSearchCount   
		 * @描述: 得到模糊查询数据总条数 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:07:39   
		 */  
		int getSearchCount(MajorFrameVO majorFrameVo);
		
		
		/**   
		 * @方法名: selectBranchAndColony   
		 * @描述: 根据部门ID查询部门和集群 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:07:48   
		 */  
		MajorFrameVO selectBranchAndColony(MajorFrameVO majorFrameVo);
		
		/**   
		 * @方法名: selectTeacherOrAdviser   
		 * @描述: 查询所有老师或者班主任 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:07:57   
		 */  
		List<MajorFrameVO> selectTeacherOrAdviser(MajorFrameVO majorFrameVo);
		
		/**   
		 * @方法名: selectTeacherOrAdviserByCode   
		 * @描述: 查询复选框中employee对应的老师或班主任名字
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:08:08   
		 */  
		MajorFrameVO selectTeacherOrAdviserByCode(List<String> list);
		
		/**   
		 * @方法名: selectAppointPerson   
		 * @描述: 查询出所有的机构负责人 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:08:31   
		 */  
		List<MajorFrameVO> selectAppointPerson();
		
		/**   
		 * @方法名: selectAppointPersonById   
		 * @描述: 查询职能对应的负责人 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:08:42   
		 */  
		List<MajorFrameVO> selectAppointPersonById(MajorFrameVO majorFrameVo);
		
		/**   
		 * @方法名: addSuperior   
		 * @描述: 批量插入机构负责人 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:08:57   
		 */  
		int addSuperior(List<MajorFrameVO> MajorFrameVOList);
		
		/**   
		 * @方法名: deleteSuperior   
		 * @描述: 删除职能下的机构负责人 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:09:05   
		 */  
		int deleteSuperior(MajorFrameVO majorFrameVo);
		
		/**   
		 * @方法名: searchTeacherOrAdviser   
		 * @描述: 搜索讲师或者班主任 
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:09:15   
		 */  
		List<MajorFrameVO> searchTeacherOrAdviser(MajorFrameVO majorFrameVo);
		
		/**   
		 * @方法名: getTeacherAndAdviser   
		 * @描述: 获得讲师跟班主任(修改展示)
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:09:22   
		 */  
		MajorFrameVO getTeacherAndAdviser(MajorFrameVO majorFrameVo);
		
		/**   
		 * @方法名: getUpdateTeacherListOrAdviserList   
		 * @描述:获得修改时的未被选中的讲师
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:09:36   
		 */  
		List<MajorFrameVO> getUpdateTeacherListOrAdviserList(MajorFrameVO majorFrameVo);
		
		/**   
		 * @方法名: getChooseTeacherListOrAdviserList   
		 * @描述: 获得修改时的被选中的讲师
		 * @作者:  wesley        
		 * @日期:2016年4月26日下午4:10:05   
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
		 * @日期:2016年4月26日下午9:27:39   
		 */  
		Integer addClass(MajorFrameVO majorFrame);
		
		 /**
		 * 日期：2016年4月26日 上午11:22:59<br/>
		 * 描述：根据数据权限过滤MajorFrame对象<br/>
		 * 修改说明（时间、人）：<br/>
		 * 上午11:22:59 Roy <br/>
		 * 修改备注：TODO<br/>
		 * @param sourceList
		 * @param powerOrgList
		 * @return<br/>
		 * List<MajorFrame>
		 */
		public List<MajorFrameVO> filterMajorFrame(List<MajorFrameVO> sourceList, HashSet<Integer> powerOrgList);
}
