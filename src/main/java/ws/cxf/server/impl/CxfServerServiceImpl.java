package ws.cxf.server.impl;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ws.cxf.server.CxfServerService;
import ws.cxf.server.po.ReqInfo;
import ws.cxf.server.po.WsResult;

/**
 * cxf服务端：使用@Webservice注解，让程序知道哪里需要转化为WSDL
 *核心包： javax.jws
 * @author admin
 *
 */
@SuppressWarnings("restriction")
@WebService
public class CxfServerServiceImpl implements CxfServerService{

	@WebMethod(action="hiOp")
	public String sayHi(@WebParam(name="text")String name) {
			return "Hi,"+name;
		}

	@WebMethod(action="add")
	public WsResult addPersonInfo(ReqInfo info) {
		WsResult res = new WsResult();
		res.setCode("0");
		System.out.println(info.toString());
		res.setMessage("添加成功！");
		return res;
	}

}
