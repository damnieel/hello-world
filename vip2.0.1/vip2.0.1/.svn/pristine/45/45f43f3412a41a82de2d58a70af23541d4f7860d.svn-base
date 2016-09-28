package com.moon.socket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;  
import org.springframework.web.socket.WebSocketSession;  
import org.springframework.web.socket.handler.TextWebSocketHandler;  

/**
 * 
* @ClassName: WebsocketEndPoint 
* @Description: TODO(暴露到客户端的方法) 
* @author  陈海  - （怡宝 ）
* @date 2015年12月25日 下午4:04:06 
*
 */
public class WebsocketEndPoint extends TextWebSocketHandler {  
    private static final String maxUserNum = "3000";
    private static final String sessionId = "userId";
	private static final Map<Integer,WebSocketSession> users; //存储所有登陆过的用户
	private static Map<Integer,String> msgCatainner; //离线消息临时存储器
	private static Logger logger = Logger.getLogger(WebsocketEndPoint.class);
	private Integer userMaxNum;
	private String sessionKey;
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public void setUserMaxNum(Integer userMaxNum) {
		this.userMaxNum = userMaxNum;
	}
	static {
		users = new HashMap<Integer,WebSocketSession>();
		setMsgCatainner(new HashMap<Integer, String>());
	}

	 public WebsocketEndPoint(Properties pro){
		if(pro != null){
		  try{
			 setSessionKey(pro.getProperty("sessionkey", sessionId));
		     setUserMaxNum(Integer.valueOf(pro.getProperty("maxusernum", maxUserNum)));
		  }catch(Exception e){
			logger.error("params error");
			setUserMaxNum(Integer.valueOf(maxUserNum));
		  }
		}
		else{
			System.out.println("WebsocketEndPoint 执行默认配置");
			setSessionKey("userId");
			setUserMaxNum(Integer.valueOf(maxUserNum));
		}
	 }
		
	/**
	 * 连接成功时候，会触发UI上onopen方法
	 */
	@Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	System.out.println("connect to the websocket success......"+userMaxNum);
	Integer user = (Integer) session.getAttributes().get(sessionKey);
	if(users.size() < userMaxNum){
	  users.put(user,session);
	  sendOffLineMsg(user);
	  logger.info(String.format("当前在线人数：[%s]", (users.size())));
	}
	else{
        TextMessage returnMessage = new TextMessage("服务器繁忙,连接失败"); //
	    session.sendMessage(returnMessage);
	}  
	   // 实现其余上线后的功能
	  // sendMessageToUser(user,new TextMessage("DEL_COOKIES"));
    }

	/**
	 * 在UI在用js调用websocket.send()时候，会调用该方法
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		  System.out.print(message.getPayload());
		  super.handleTextMessage(session, message);
				
	}
	
	
	
	private void sendOffLineMsg(Integer useId){
	     WebSocketSession user =  users.get(useId);
	     String text = msgCatainner.get(useId);
	     if(text == null || "".equals(text)){
	    	 logger.info("不存在离线消息");
	     }
	     else{
	      TextMessage msg = new TextMessage(text);
          try {
             if (user.isOpen()) {
                 user.sendMessage(msg);
                 msgCatainner.remove(useId);
             }
          } catch (IOException e) {
             e.printStackTrace();
          }
         }
	}

	
    public void sendMessageToUser(Integer userName, TextMessage message) {
	      WebSocketSession user =  users.get(userName);
          try {
              if (user.isOpen()) {
                  user.sendMessage(message);
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
	
    public void sendMessageToUser(Integer userName, String message) {
	      WebSocketSession user =  users.get(userName);
          try {
              if (user.isOpen()) {
                  user.sendMessage(new TextMessage(message));
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
    
    public void sendMessageToAll(String message) { //遍历MAP
    	  for(Entry<Integer, WebSocketSession> entry:users.entrySet()){ 
    		  WebSocketSession user =   entry.getValue(); 
    		  try {
    			  if (user.isOpen()) {
    				  user.sendMessage(new TextMessage(message));
    			  }
    		  } catch (IOException e) {
    			  e.printStackTrace();
    		  }
    	  }
    } 
    
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    	Integer user = (Integer) session.getAttributes().get("userId");
        if(session.isOpen()){
            session.close();
        }
        logger.error("websocket connection closed......");
        users.remove(user);
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
    	Integer user = (Integer) session.getAttributes().get("userId");
    	logger.debug("websocket connection closed......");
        users.remove(user);
    }
    
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

	public static Map<Integer,String> getMsgCatainner() {
		return msgCatainner;
	}

	public static void setMsgCatainner(Map<Integer,String> msgCatainner) {
		WebsocketEndPoint.msgCatainner = msgCatainner;
	}

}