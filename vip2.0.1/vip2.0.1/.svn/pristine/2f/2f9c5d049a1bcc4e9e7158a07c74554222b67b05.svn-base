package com.moon.vip.service.onReadStudent;

import java.util.List;

import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.vo.onReadPage.OnReadPageStudentsVO;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;

/**
 * 非在读页面的service
 * @ClassName: INotReadService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author A18ccms a18ccms_gmail_com 
 * @date 2016年1月5日 下午3:57:45 
 *
 */
public interface INotReadService {

	/**
	 * 查找非在读学员的总数<br/> 
	 * @Title: selectNotReadStudentCount <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月5日 下午4:02:20  <br/> 
	 * @param paramsVO 
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public int selectNotReadStudentCount(ParamsVO paramsVO);
	/**
	 * 查找非在读学员的详细信息<br/> 
	 * @Title: selectNotReadStudent <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月5日 下午4:04:08  <br/> 
	 * @param paramsVO
	 * @return
	 * List<OnReadPageStudentsVO>
	 * @throws  <br/>
	 */
	public List<OnReadPageStudentsVO> selectNotReadStudent(ParamsVO paramsVO);
	/**
	 * 将选中学员状态置为reading<br/> 
	 * @Title: backReadAction <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2016年1月5日 下午6:51:31  <br/> 
	 * @param paramsVO
	 * @return
	 * Message
	 * @throws  <br/>
	 */
	public Message backReadAction(ParamsVO paramsVO);
	
}
