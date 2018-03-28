package ws.cxf.soap.po;

import javax.xml.bind.annotation.XmlType;

/**
 * 数据传递方案，核心是XML和javaBean之间的转换
 * 故实现webservice
 * @author admin
 *
 */
@XmlType
public class WsResult {
	//响应状态码：0 success，101-fail,500-sys-err
	private String code;
	//json字符串，按需求编写响应
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
