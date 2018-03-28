package ws.cxf.soap;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import ws.cxf.soap.impl.CxfServerServiceImpl;
import ws.cxf.soap.security.WsSecurityHandler;
/**
 * 关于Jar包问题：
 * 使用的Jar包和你希望发布的服务有关
 * @author admin
 *
 */
@SuppressWarnings("restriction")
public class Publish_Services {
	 protected Publish_Services() throws Exception {
	        // START SNIPPET: publish方式一：方便快捷，使用endpoint发布服务
	     	System.out.println("Starting Server");
	        CxfServerServiceImpl implementor = new CxfServerServiceImpl();
	        String address = "http://localhost:9000/hi";
	        Endpoint.publish(address, implementor);
	        // END SNIPPET: publish
	    }

	    public static void main(String args[]) throws Exception {
	    	//new  PubServerM1();
	    	System.out.println("Starting Server OK");
	     //发布方式二：使用工厂发布服务，添加更多限制，行为控制
	        CxfServerServiceImpl implementor1 = new CxfServerServiceImpl(); 
	        JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean(); 
	        svrFactory.setServiceClass(CxfServerService.class); 
	        svrFactory.setAddress("http://localhost:8080/hi"); 
	        svrFactory.setServiceBean(implementor1); 
	        svrFactory.getInInterceptors().add(new LoggingInInterceptor());
	        svrFactory.getOutInterceptors().add(new LoggingOutInterceptor()); 
	        Map<String, Object> inProps = new HashMap<String, Object>();
			inProps.put(WSHandlerConstants.ACTION,
					WSHandlerConstants.USERNAME_TOKEN);
			// 密码类型 : plain text
			inProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
			// 客户信息校验类设置
			inProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,
					WsSecurityHandler.class.getName());
	        
	        WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
	        svrFactory.getInInterceptors().add(wssIn);
	        svrFactory.getOutInterceptors().add(new LoggingOutInterceptor()); 
	        svrFactory.create();
	    }
}
