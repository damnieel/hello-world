package com.moon.vip.webservice;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.moon.client.vo.Message;
import com.moon.client.vo.UserInfoVO;





/**
 * 
* @ClassName: IUserService 
* @Description: TODO(webservice 接口) 
* @author  陈海  - （怡宝 ）
* @date 2016年3月21日 下午2:58:53 
*
 */
@Path(value="/user")
public interface IUserService extends Serializable {
	

	/**
	  * 获取账户信息<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getUserInfoByAccount <br/>
	  * @return UserInfoVO    返回类型 <br/>
	  * @date 2016年3月21日 下午2:58:33 <br/>
	  * @throws <br/>
	  *
	 */
	@GET
	@Path(value="/getUserInfo")
	@Produces(MediaType.APPLICATION_JSON )
	UserInfoVO getUserInfoByAccount(@QueryParam(value = "account") String account);
	
	/**
	  * 增添新用户<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: addUser <br/>
	  * @return Message    返回类型 <br/>
	  * @date 2016年3月22日 下午5:16:10 <br/>
	  * @throws <br/>
	  *
	 */
    @POST
    @Path("/addUser")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Message addUser(UserInfoVO user) ;
	
	
}
