package com.moon.vip.service.attend;

import java.util.List;
import java.util.Map;

import com.moon.vip.infra.vo.attendance.AttendErrorRecordVO;
import com.moon.vip.infra.vo.attendance.AttendanceErrorVO;
import com.moon.vip.model.inspect.InspectDetail;

/**
 * 
* @ClassName: IAttendImportService 
* @Description: TODO(考勤记录导入service) 
* @author  陈海  - （怡宝 ）
* @date 2016年1月6日 下午3:09:43 
*
 */
public interface IAttendImportService {
/**
  * 导入考勤记录<br/>
  * @Author：  陈海  - （怡宝 ）<br/>
  * @Title: insertAttendRecords <br/>
  * @return boolean    返回类型 <br/>
  * @date 2016年1月6日 下午3:10:16 <br/>
  * @throws <br/>
  *
 */
	public boolean insertAttendRecords(List<InspectDetail> atRecords,int id);
   
    /**
      * 将获取到的数据转成目标模型，并作验证<br/>
      * @Author：  陈海  - （怡宝 ）<br/>
      * @Title: changeList <br/>
      * @return List<InspectDetail>    返回类型 <br/>
      * @date 2016年1月6日 下午3:10:40 <br/>
      * @throws <br/>
      *
     */
	public List<InspectDetail> changeList(List<Map<Integer, String>> list, List<AttendanceErrorVO> errRecords, String empcode, int id);
    

}
