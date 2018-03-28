package ws.cxf.soap.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

/**
 * 创建一个基于WS-Security标准的安全验证(CXF回调函数使用)
 * 考虑多用户使用的情况，Username Token Authentication
 * @author admin
 *In the case of multiple users with different passwords, //differ from in case of 
 *use the WSPasswordCallback's getIdentifier() method to obtain the username of the current SOAP request.
 *
 *  *新版说明
             * For CXF 2.4 onwards, the callback handler supplies the password for all cases, and the validation is done internally (but can be configured). 
 */
public class WsSecurityHandler implements CallbackHandler{

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		
		//重要：用户名需要自己校验判断,多用户
		if (pc.getIdentifier().equals("xgx")) {
			//设置密码，校验机制会将这个密码和客户端的密码做比较
			//新版本不需要写校验逻辑，API自动校验，只需要设置校验的密码
            // set the password on the callback. This will be compared to the password which was sent from the client.
            pc.setPassword("123456");
            /*
             * Note that for up to and including CXF 2.3.x, t
             * he password validation of the special case of a plain-text password (or any other yet unknown password type) is delegated to the callback class.
             *  In that case, the ServerPasswordCallback should be something like the following one:
             */
        }else if(pc.getIdentifier().equals("zyg")){
        	pc.setPassword("950416");
        }
	}
}
