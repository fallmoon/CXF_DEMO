package ws.cxf.server.security;

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
public class WsSecurityHandler implements CallbackHandler{

	@SuppressWarnings("deprecation")
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		if (pc.getIdentifier().equals("xgx")) {
			//设置密码，校验机制会将这个密码和客户端的密码做比较
			//新版本不需要写校验逻辑，API自动校验，只需要设置校验的密码
			//重要：用户名需要自己校验判断
            // set the password on the callback. This will be compared to the password which was sent from the client.
            pc.setPassword("123456");
        }
		
		/*
		 * Note that for up to and including CXF 2.3.x, the password validation of the special case of a plain-text password (or any other yet unknown password type) is delegated to the callback class.
		 *  In that case, the ServerPasswordCallback should be something like the following one:
		 */
	}
}
