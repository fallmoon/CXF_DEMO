package ws.cxf.server.po;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;
/**
 * cxf请求实体
 * @author admin
 *注意实体需要使用注解：@XmlType
 */
@XmlType
public class ReqInfo {
	//姓名
	private String name;
	//年龄
	private String age;
	//地址
	private String address;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
