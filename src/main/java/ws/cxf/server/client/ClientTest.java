package ws.cxf.server.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import ws.cxf.server.CxfServerService;
import ws.cxf.server.po.ReqInfo;
import ws.cxf.server.po.WsResult;



/**
 * cxf客户端调用,不同的实现采用不同的调用方式
 * @author admin
 *
 */
public class ClientTest {
public static void main(String[] args) {
	invokeM2();
	
	/*//调用方式2：
	//1、使用代理
	 JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();  
	 //设置服务接口
     factoryBean.setServiceClass(CxfServerService.class);  
     //设置服务地址
     factoryBean.setAddress("http://localhost:8080/hi");  
       
     //创建服务代理调用类
     CxfServerService readerService = (CxfServerService)factoryBean.create();  
     //调用服务，和本地调用一样，这和axis2很像
     String msg = readerService.sayHi("xgx");  
     ReqInfo info = new ReqInfo();
     info.setAddress("北京");
     info.setAge("45");
     WsResult addPersonInfo = readerService.addPersonInfo(info);
     System.out.println("Reader:"+msg);  
     System.out.println("Reader:"+addPersonInfo.toString());  */
}

//@Test
public static void invokeM2(){
	//调用方式二：
	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean(); 
	factory.getInInterceptors().add(new LoggingInInterceptor());
	factory.getOutInterceptors().add(new LoggingOutInterceptor()); 
	factory.setServiceClass(CxfServerService.class); 
	factory.setAddress("http://localhost:8080/hi"); 
	
	Map<String, Object> outProps = new HashMap<String, Object>();
	outProps.put(WSHandlerConstants.ACTION,
			WSHandlerConstants.USERNAME_TOKEN);
	// 服务器用户标识
	outProps.put(WSHandlerConstants.USER, "xgx");
	// 密码类型 : plain text--passwordtext
	outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
	// 返回给客户端的密码信息,密码处理回掉类
	outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,
			ClientWsSecurityHandler.class.getName());
	WSS4JOutInterceptor wss = new WSS4JOutInterceptor(outProps);
    factory.getOutInterceptors().add(wss);
	CxfServerService client = (CxfServerService) factory.create(); 
	String reply = client.sayHi("我是xgx，哈哈哈哈"); 
	ReqInfo info =new ReqInfo(); 
	info.setAddress("北京");
	info.setBirthDate(new Date());
	WsResult result = client.addPersonInfo(info);
	System.out.println("Server said: " + reply); 
	System.out.println("Add person result: " + result.getMessage()); 
	System.exit(0);
	
}
}
