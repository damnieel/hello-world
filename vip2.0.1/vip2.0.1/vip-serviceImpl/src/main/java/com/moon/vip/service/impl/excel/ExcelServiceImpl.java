package com.moon.vip.service.impl.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moon.platform.commons.util.BlankUtil;
import com.moon.vip.application.student.ArchivesProfOrgProfSqlMapper;
import com.moon.vip.application.student.StudentProfessionalMapper;
import com.moon.vip.application.sys.CodeTableSqlMapper;
import com.moon.vip.application.sys.OrganizationalProfessionalSqlMapper;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.util.ClassUtil;
import com.moon.vip.infra.util.StringUtil;
import com.moon.vip.infra.util.checkUploadData.CheckUploadUtil;
import com.moon.vip.infra.util.checkUploadData.DoCheckUtil;
import com.moon.vip.infra.vo.excel.UploadErrorVO;
import com.moon.vip.infra.vo.excel.UploadStudentVO;
import com.moon.vip.model.student.StudentArchives;
import com.moon.vip.model.student.StudentProfessional;
import com.moon.vip.service.excel.IExcelService;
import com.moon.vip.service.student.IStudentArchivesService;
import com.moon.vip.service.sys.IProfessionSquenceService;
import com.moon.vip.application.student.StudentClassMapper;

@Service("iExcelService")
public class ExcelServiceImpl implements IExcelService {

	private Logger logger = Logger.getLogger(ExcelServiceImpl.class);
	
	@Autowired
	private StudentProfessionalMapper studentProfessionalMapper;
	
	@Autowired
	private ArchivesProfOrgProfSqlMapper archivesProfOrgProfSqlMapper;
	
	@Autowired
	private CodeTableSqlMapper codeTableSqlMapper;
	
	@Autowired
	private OrganizationalProfessionalSqlMapper organizationalProfessionalSqlMapper;
	
	@Autowired
	private StudentClassMapper studentClassMapper;
	
	@Autowired
	private IStudentArchivesService iStudentArchivesService;

	@Autowired
	private IProfessionSquenceService iProfessionSquenceService;
	
	public List<UploadStudentVO> readFromMap(List<Map<Integer, String>> list, String creatorCode) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ParseException {
		Map<Integer , String> m;
		UploadStudentVO uploadStudentVO = new UploadStudentVO();
		List<UploadStudentVO> returnList = new ArrayList<UploadStudentVO>();
		for(int i=0; i<list.size(); i++) {
			m = list.get(i);//第一条记录， 去掉表头
			/**
			 * 直到指定域 才开始读取 SysConstantsVal。UPLOADFIRSTFIELD
			 */
			uploadStudentVO = (UploadStudentVO) ClassUtil.getDataFromMap(m, UploadStudentVO.class);
			uploadStudentVO.setCreator(creatorCode);
			returnList.add(uploadStudentVO);
			
		}
		return returnList;
	}
	public String getExcelFile(MultipartFile file, HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		/**
		 * 获取配置文件的路径
		 */
		Properties pro =new Properties();
		FileInputStream fs;
		try {
			fs = new FileInputStream(getClass().getResource("/").getPath() + SysConstantsVal.UPLOADCONFIGFILE);
				pro.load(fs);
		    fs.close();
		} catch (Exception e) {
	     	return null;
		}
	    String path = pro.getProperty("uploadPath");
//		String path = System.getProperty("catalina.home") + "/logs/upload";
	    /**
	     * 拼接完整的文件路径名
	     */
		try {
			File directory = new File(path); //创建文件路径
	        if(!directory.exists()){
	     	   directory.mkdirs();
	        }
			file.transferTo(new File(path + "/" + fileName));			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path + "/" + fileName;
	}
	public List<UploadErrorVO> checkUploadData(List<UploadStudentVO> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UploadErrorVO> errorList = new ArrayList<UploadErrorVO>();
		Map<String, Object> dupliMap = new HashMap<String, Object>();
		String keyParam = "";
//		int size = list.size();
		int dataId = 0;
				
		for(int i=0; i<list.size(); i++) {
						
			//正常测试
			map = DoCheckUtil.doCheck(list.get(i), CheckUploadUtil.class, 0);

			//去重， 防止重复QQ号码插入
			keyParam = list.get(i).getQQ() + list.get(i).getProfessionalName();
			
			UploadStudentVO oldTemp = (UploadStudentVO) dupliMap.get(keyParam);
			if(oldTemp != null) {
				if(!oldTemp.getName().equalsIgnoreCase(list.get(i).getName())) {
					map.put("result", false);
					map.put("QQ", "QQ一致，姓名不一致，Excel中有重复QQ数据");
				}
				if(!oldTemp.getTelephone().equalsIgnoreCase(list.get(i).getTelephone())) {
					map.put("result", false);
					map.put("telephone", "QQ一致，手机号不一致，请确认后插入数据");
				}	
				if(oldTemp.getProfessionalName().equalsIgnoreCase(list.get(i).getProfessionalName())) {
					if(!(Double.compare(oldTemp.getAmountPayable(), list.get(i).getAmountPayable())== 0)) {
						map.put("result", false);
						map.put("AmountPayable", "QQ一致，专业名称一致，专业价格不一致，请确认后插入数据");
					}	
				}	
				if(!oldTemp.getProfessionCode().equalsIgnoreCase(list.get(i).getProfessionCode())) {
					map.put("result", false);
					map.put("professionCode", "QQ一致，学员编号不一致，请确认后插入数据");
				}	
				if(!oldTemp.getEnterDate().equals(list.get(i).getEnterDate())) {
					map.put("result", false);
					map.put("EnterDate", "QQ一致，报名时间不一致，请确认后插入数据");
				}	
				
				//合并数据金额
				dataId = oldTemp.getDataId();
				list.get(dataId).setPayment(
						list.get(dataId).getPayment() + list.get(i).getPayment());
				double Arrays = list.get(dataId).getAmountPayable() 
										- list.get(dataId).getPayment();
				if(Double.compare(Arrays, 0) == -1) {
					map.put("result", false);
					map.put("payment", "Excel中该学员已付金额综合大于专业价格");
				}
			} else {
				list.get(i).setDataId(i);
				dupliMap.put(keyParam, list.get(i));
			}
			
			//判断结果，如果false 则将结果插入到errorList中
			if(!(Boolean) map.get("result")) {
				UploadErrorVO uploadErrorVO = new UploadErrorVO();
				BeanUtils.copyProperties(list.get(i), uploadErrorVO);
				uploadErrorVO.setErrorMap(map);
				errorList.add(uploadErrorVO);
			}
			
			if(oldTemp != null) {
				list.remove(i);//最后删除重复数据
				i = i - 1;
			}
		}
		return errorList;
	}
	
	public int updataOrInsertStudentData(List<UploadStudentVO> studentList) {
		String QQ = "";
		
		for(UploadStudentVO studentVO: studentList) {
			QQ = studentVO.getQQ();
			switch(studentVO.getState()){
				case 0: {//旧学员旧专业 默认状态 更新该专业的已付金额和欠款，如果欠款为0，则改变欠款标识
					UploadStudentVO dataVO = archivesProfOrgProfSqlMapper.selectExcelClumByQQ(QQ,  String.valueOf(studentVO.getOpProId()));
					updateStudentProf(dataVO, studentVO);
					break;
				}
				case 1: {//旧学员新专业 插入新专业状态，并与该专业关联
					List<UploadStudentVO> archVOList = archivesProfOrgProfSqlMapper.selectArchByQQ(QQ);
					UploadStudentVO archVO = archVOList.get(0);
					//生成新的编号
					studentVO.setId(archVO.getId());
					insertIntoStudentProf(studentVO);	
//					insertIntoStudentClass(studentVO);
					break;
				}
				case 2: {//新学员新专业 插入新学员数据， 插入新专业数据，并关联
					//生成新的学员编码和专业编号
					insertIntoStudentArch(studentVO);
					insertIntoStudentProf(studentVO);	
//					insertIntoStudentClass(studentVO);				
					break;
				} default: {
					logger.error("该学员数据没有数据状态");
					break;
				}			
			}
		}
		return 0;
	}
	public List<UploadErrorVO> checkRepeatData(List<UploadStudentVO> studentList){
		String QQ = "";
		List<UploadErrorVO> errorList = new ArrayList<UploadErrorVO>();
		UploadStudentVO dataVO = new UploadStudentVO();
		
		for(int i=0; i<studentList.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			QQ = studentList.get(i).getQQ();
			
			logger.info(String.format("搜索学员%s by QQ:%s",studentList.get(i).getName(), QQ));
			
			//检查付款方式是否在码表中存储， 如果有，用英文替换
			String payMethod = codeTableSqlMapper.selectByTypeAndCodeValue("payment", studentList.get(i).getPayMethod());
			if(payMethod == null) {
				map.put("result", false);
				map.put("payMethod", 
						String.format("系统不支持<%s>支付方式", studentList.get(i).getPayMethod()));
			} else {
				studentList.get(i).setPayMethod(payMethod);	
			}
			//查看数据库是否有该专业
			Integer OpProId = organizationalProfessionalSqlMapper.selectProfByName(studentList.get(i).getProfessionalName());
			if(OpProId == null) {
				map.put("result", false);
				map.put("professionalName", 
						String.format("系统不存在<%s>专业", studentList.get(i).getProfessionalName()));
			} else {
				studentList.get(i).setOpProId(OpProId);
			}
			
			List<UploadStudentVO> archVOList = archivesProfOrgProfSqlMapper.selectArchByQQ(QQ);
			if(archVOList == null || archVOList.size() == 0) {// 没有该学员的信息， 是新学员
				studentList.get(i).setState(2);//新学员新专业
			} else if(archVOList.size() > 1) {
				map.put("result", false);
				map.put("SystemError", "该学员在数据库有多条数据，请删除重复学员信息数据");
				map.put("otherInfo", "数据库中学员数据archVOList: " + archVOList);
			} else {
				UploadStudentVO archVO = archVOList.get(0);
				dataVO = archivesProfOrgProfSqlMapper.selectExcelClumByQQ(QQ, String.valueOf(OpProId));
				if(dataVO == null) {// 有该学员信息， 但是没有专业信息	旧学员新专业
					studentList.get(i).setState(1);//旧学员新专业
					dataVO = new UploadStudentVO();
					BeanUtils.copyProperties(archVO, dataVO);
				} else {
					studentList.get(i).setState(0);//旧学员旧专业
					//判断该学员已付金额是否超出该专业价格
					double Arrays = dataVO.getAmountPayable() - 
							(studentList.get(i).getPayment() + dataVO.getPayment());
					if(Double.compare(Arrays, 0) == -1) {
						map.put("result", false);
						map.put("payment", "该学员系统和excel总和大于专业价格");
						map.put("otherInfo", "计算结果Arrays: " + Arrays);
					}
					
				}
				map.putAll(getErrorMap(dataVO, studentList.get(i)));
			}
			
			//记录错误信息
			if(map.size() != 0) {
				if(!(Boolean) map.get("result")) {
					UploadErrorVO uploadErrorVO = new UploadErrorVO();
					BeanUtils.copyProperties(studentList.get(i), uploadErrorVO);
					uploadErrorVO.setErrorMap(map);
					errorList.add(uploadErrorVO);					
				}
			}			

		}
		return errorList;
	}
	public boolean deleteFile(String url) {
	    boolean flag = false;  
	    File file = new File(url);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}
	
	private void updateStudentProf(UploadStudentVO dataVO, UploadStudentVO studentVO) {
		if(Double.doubleToLongBits(dataVO.getAmountPayable()) == Double.doubleToLongBits(studentVO.getAmountPayable())) {
			double totalPay = dataVO.getPayment() + studentVO.getPayment();
			studentVO.setPayment(totalPay);
			if(Double.compare(totalPay, studentVO.getAmountPayable()) == 1) { //d1 > d2
				throw new BusinessException(
						EnumCodeException.E0006, "数据库中该学员已付金额： " + dataVO.getPayment());
			} else {
				StudentProfessional studentProfessional = new StudentProfessional();
				studentProfessional.setPayment(new BigDecimal(studentVO.getPayment()));
				studentProfessional.setId(dataVO.getProfId());
				studentProfessional.setArrears(new BigDecimal(
						studentVO.getAmountPayable() - studentVO.getPayment()));
				studentProfessional.setModifyTime(new Date());//记录插入时间
				
				if(Double.compare(totalPay, studentVO.getAmountPayable()) == 0) {
					//学员已付完全部金额 欠款标识更新为N
					studentProfessional.setIsArrears("N");
				} 
				
				studentProfessionalMapper.updateByPrimaryKeySelective(studentProfessional);
			}
			
			
		}
	}
	private void insertIntoStudentArch(UploadStudentVO studentVO) {
		StudentArchives studentArchives = new StudentArchives();
		String[] ignoreList = {"id"};
		BeanUtils.copyProperties(studentVO, studentArchives, ignoreList);
		//添加未copy的内容
		studentArchives.setQq(studentVO.getQQ());
		studentArchives.setCreateTime(new Date());
		studentArchives.setCreator(studentVO.getCreator());
		studentArchives.setIsValid("Y");
		//生成学员编码，并给studentArchives赋值
		String codeNo = iStudentArchivesService.selectStudentCode();	
		if(StringUtil.isNull(codeNo)) {
			throw new BusinessException(EnumCodeException.E0017);
		}
		studentArchives.setCodeNo(codeNo);
		
		/***修复一个人同时上传多个专业，产生多条记录的问题--by  xinagui***/
		List<UploadStudentVO> archVOList = archivesProfOrgProfSqlMapper.selectArchByQQ(studentArchives.getQq());
		if(archVOList.size() == 0){
			 archivesProfOrgProfSqlMapper.insertStudentData(studentArchives);
			 studentVO.setId(studentArchives.getId());//用于关联专业表
		}else{
			UploadStudentVO archVO = archVOList.get(0);
			//生成新的数据
			studentVO.setId(archVO.getId());
		}
		
//		int k = archivesProfOrgProfSqlMapper.insertStudentData(studentArchives);
//		if(k == 0){
//			throw new BusinessException(EnumCodeException.E0006, 
//											"插入学员基础数据失败，失败数据QQ号码: "+ studentVO.getQQ());
//		}
//		studentVO.setId(studentArchives.getId());//用于关联专业表
		
		
		logger.info("插入学员基础信息：studentArchives " + studentArchives);
	}
	private void insertIntoStudentProf(UploadStudentVO studentVO) {
		String ignore[] = {"id"};
		StudentProfessional studentProfessional = new StudentProfessional();
		BeanUtils.copyProperties(studentVO, studentProfessional, ignore);
		
		double Arrays = studentVO.getAmountPayable() - studentVO.getPayment();
		switch (Double.compare(Arrays, 0)) {
			case 0: {//相等
				studentProfessional.setIsArrears("N");
				studentProfessional.setArrears(new BigDecimal(0));
				break;
			}
			case 1: {//d1 >　d2 
				studentProfessional.setIsArrears("Y");
				studentProfessional.setArrears(new BigDecimal(Arrays));
				break;			
			}
			case -1: {//d1 < d2
				throw new BusinessException(EnumCodeException.E0006, 
						"插入学员专业数据失败，专业价格小于已付金额: " + studentVO.getAmountPayable() +"<"+ studentVO.getPayment());
			}
		}
		//生成专业编号，并给studentProfessional赋值
/*		String professionCode = iProfessionSquenceService.getStudentCode(
					studentVO.getEnterDate(), studentVO.getOpProId());
		if(StringUtil.isNull(professionCode)) {
			throw new BusinessException(EnumCodeException.E0016);
		}
		studentProfessional.setProfessionCode(professionCode);*/
		
		//插入未拷贝的数据
		studentProfessional.setAmountPayable(new BigDecimal(studentVO.getAmountPayable()));
		studentProfessional.setPayment(new BigDecimal(studentVO.getPayment()));
		
		studentProfessional.setOpProId(studentVO.getOpProId());
		studentProfessional.setStudentId(studentVO.getId());
		studentProfessional.setCreateTime(new Date());
		studentProfessional.setCreator(studentVO.getCreator());
		studentProfessional.setIsRefund("N");
		studentProfessional.setIsValid("Y");
		studentProfessional.setStatus("reading");
		int k = studentProfessionalMapper.insertSelective(studentProfessional);
		if(k == 0){
			throw new BusinessException(EnumCodeException.E0006, 
											"插入学员专业数据失败，失败数据QQ号码: ", studentVO.getQQ());
		}
		logger.info("插入学员专业信息：studentProfessional " + studentProfessional);
	}
	/**
	 * 对比数据库内容和Excel内容看是否有错误<br/> 
	 * @Title: getErrorMap <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年2月16日 下午4:36:46  <br/> 
	 * @param dataVO
	 * @param uploadDataVO
	 * @return
	 * Map<String,Object>
	 * @throws  <br/>
	 */
	private Map<String, Object> getErrorMap(UploadStudentVO dataVO, UploadStudentVO uploadDataVO) {

		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");

		Map<String, Object> checkDataVOmap = checkDataVONull(dataVO);
		if(checkDataVOmap != null && checkDataVOmap.size() > 0) {
			map.put("result", false);
			map.putAll(checkDataVOmap);
			return map;
		}
		if(!dataVO.getName().equalsIgnoreCase(uploadDataVO.getName())) {
			map.put("name（姓名）", formatString(uploadDataVO.getName(), dataVO.getName()));
		}
		if(!dataVO.getTelephone().equalsIgnoreCase(uploadDataVO.getTelephone())) {
			map.put("telephone（电话）", formatString(uploadDataVO.getTelephone(), dataVO.getTelephone()));
		}
		if(!dataVO.getQQ().equalsIgnoreCase(uploadDataVO.getQQ())) {
			map.put("QQ", formatString(uploadDataVO.getName(), dataVO.getName()));
		}
		if(dataVO.getProfessionalName() == null) {//旧学员 新专业
			if(map.size() != 0) {
				map.put("result", false);
			}
			return map;
		}
		// 旧学员， 旧专业
		if(!dataVO.getProfessionalName()
							.equalsIgnoreCase(uploadDataVO.getProfessionalName())) {
			uploadDataVO.setState(1);//旧学员新专业
			
		} else {//专业名称相同
			if(dataVO.getProfessionCode() == null) {
				throw new BusinessException(EnumCodeException.E0006, String.format("学员（QQ:%s）系统中学员编号为空， 请添加后操作", dataVO.getQQ()));
			}
			if(!dataVO.getProfessionCode().equalsIgnoreCase(uploadDataVO.getProfessionCode())) {
				map.put("professionCode（学员编号）", formatString(uploadDataVO.getProfessionCode(), dataVO.getProfessionCode()));
			}	
			if(Double.doubleToLongBits(dataVO.getAmountPayable()) != Double.doubleToLongBits(uploadDataVO.getAmountPayable())) {
				map.put("amountPayable（应付金额）", formatString(String.valueOf(dataVO.getAmountPayable())
						, String.valueOf(uploadDataVO.getAmountPayable()))); 
			}
			if(dataVO.getEnterDate().compareTo(uploadDataVO.getEnterDate()) != 0) {
				map.put("EnterDate（报名时间）", formatString(sdf.format(uploadDataVO.getEnterDate())
						, sdf.format(dataVO.getEnterDate())));
			}
		}
		if(map.size() != 0) {
			map.put("result", false);
			map.put("otherInfo", String.format("学员数据与数据库对比有误： dataVO: %s/n uploadDataVO: %s", dataVO, uploadDataVO));
		}
		return map;
	}
	/**
	 * 检查数据库关键信息是否为空<br/> 
	 * @Title: checkDataVONull <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年2月16日 下午4:10:14  <br/> 
	 * @param dataVO
	 * @return
	 * Map<String,Object>
	 * @throws  <br/>
	 */
	private Map<String, Object> checkDataVONull(UploadStudentVO dataVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(BlankUtil.isBlank(dataVO.getName())) {
			map.put("name", "数据库中name为空, 请在学员信息或者问题数据检查");
		}
		if(BlankUtil.isBlank(dataVO.getTelephone())) {
			map.put("telephone", "数据库中telephone为空, 请在学员信息或者问题数据检查");
		}
		if(!BlankUtil.isBlank(dataVO.getProfessionalName())) {
			if(BlankUtil.isBlank(dataVO.getProfessionCode())) {
				map.put("professionCode", "数据库中专业编号为空, 请在学员信息或者问题数据检查");
			}
			if(Double.compare(0, dataVO.getAmountPayable()) == 0) {
				map.put("amountPayable", "数据库中应付金额为0, 请在学员信息或者问题数据检查");
			}
			if(dataVO.getEnterDate() == null) {
				map.put("EnterDate", "数据库中报名时间为空, 请在学员信息或者问题数据检查");
			}
		}
		return map;
	}
	private String formatString(String str1, String str2){
		return String.format("%s != %s,与数据库不符", str1, str2);
	}	
}
