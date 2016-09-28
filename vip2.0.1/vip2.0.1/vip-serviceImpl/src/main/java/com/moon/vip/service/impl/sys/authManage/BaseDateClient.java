package com.moon.vip.service.impl.sys.authManage;

import org.apache.log4j.Logger;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.service.IDbPoolEnv;
import com.moon.service.thrift.User;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;
/**
 * 
 * 类名称：BaseDateClient.java<br/>
 * 日期：2016年6月18日 上午11:15:41<br/>
 * 类描述：基础数据接口客户端<br/>
 * 修改说明（时间、人、详细备注）：<br/>
 * 2016年6月18日 chenhai  TODO<br/>
 * @author <a href="mailto:937870526@qq.com"></a><br/>
 * @version 1.0.0
 */
public class BaseDateClient {
	@Autowired
	private IDbPoolEnv bdpool;
	private static Logger logger = Logger.getLogger(BaseDateClient.class);
	private boolean isCon = true;
	private  User.Client getClient() throws Exception{
		TTransport transport = null;
		User.Client client = null;
		try {
			transport = bdpool.borrowConn();
			TProtocol protocol = new TBinaryProtocol(transport);
		    client = new User.Client(protocol);
		} catch (Exception e1) {
			   logger.error("获取thrift客户端实例失败");
			   reConnect();
			   throw e1;
		}finally {
			if(null != transport){
				try {
					bdpool.returnConn(transport);
				} catch (Exception e) {
					logger.error("获取连接池失败",e);
				}
			}
		}
		return client;
	}
	/**
	 * 
	 * 日期：2016年6月16日 下午2:35:37<br/>
	 * 描述：判断账号是否存在<br/>
	 * 修改说明（时间、人）：<br/>
	 * 下午2:35:37 chenhai <br/>
	 * 修改备注：TODO<br/>
	 * @param account
	 * @param pwd
	 * @return<br/>
	 * LoginUser
	 */
	public  boolean accountIsExist(String account){
	 try {
	        User.Client client = getClient();
			boolean a =  client.isUserAccountExists(account);
			logger.info(String.format("从基础数据服务验证账号[%s]是否存在，结果[%s]", account,a));
			return a;
		} catch (Exception e) {
			logger.error("Thrift 统一登录异常",e);
			throw new BusinessException(EnumCodeException.E0125);
		}
	}
	
	
	/**
	 * 
	 * 日期：2016年6月24日 上午11:18:23<br/>
	 * 描述：重连<br/>
	 * 修改说明（时间、人）：<br/>
	 * 上午11:18:23 chenhai <br/>
	 * 修改备注：TODO<br/><br/>
	 * void
	 */
	private void reConnect() {
		new Thread(new Runnable() {
			public void run() {
				if (isCon) {
					isCon = false;
						while (!checkIsCon()) {
							try {
								bdpool.onload();
								Thread.sleep(3000);
							} catch (Exception e) {
								logger.error("重连失败", e);
							}
						}
					isCon = true;
				 } 
				}
		}).run();
	}
	
	
	private boolean checkIsCon(){
		boolean isConnect = true;
		try {
			if(bdpool.borrowConn() == null){
				isConnect = false;
			}
		} catch (Exception e) {
			isConnect = false;
		}
		return isConnect;
	}


	
}
