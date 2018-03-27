package ws.cxf.server.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

/**
 * 可选：
 * 还有想想这么实现拦截器，其实就是在调用服务前的异步验证，实现提供接口即可
 * 为cxfwebservice添加安全机制
 * username
 * password
 * 创建一个基于WS-Security标准的安全验证(CXF回调函数使用)
 * @author admin
 *
 */
public class ClientWsSecurityHandler implements CallbackHandler{

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		 WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
	        //服务器标识
	        System.out.println("Server ID:"+pc.getIdentifier());
	        // 设置返回给客户的服务器密码信息
	        pc.setPassword("123456");
	        pc.setIdentifier("xgx");
	}
}
