package ws.cxf.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ws.cxf.soap.po.ReqInfo;
import ws.cxf.soap.po.WsResult;


/**
 * CXFwebservice服务端 endpoint
 * @author admin
 *
 */
@WebService
public interface CxfServerService {
	@WebMethod(action="hiOp")
	public String sayHi(@WebParam(name="text")String name);
	@WebMethod(action="add")
	public WsResult addPersonInfo(@WebParam(name="reqVO") ReqInfo info);
}
