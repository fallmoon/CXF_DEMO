package ws.cxf.server.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

/**
 * 
 * 创建一个基于WS-Security标准的安全验证(CXF回调函数使用)
 * password callback:
 * @author admin
 *
 */
public class ClientWsSecurityHandler implements CallbackHandler{

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		 WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
	        //服务器标识，服务区标识不在此设置，写在了outProps.put(WSHandlerConstants.USER, "xgx");这是一个密码回掉类
	        System.out.println("Server ID:"+pc.getIdentifier());
	        // 设置返回给客户的服务器密码信息
	        /*
	         * Once again we're using a password callback, except this time instead of specifying our password on the server side, we're specifying the password we want sent with the message. 
	         * This is so we don't have to store our password in our configuration file.
	         */
	     // set the password for our message.
	        pc.setPassword("123456");
	}
}
