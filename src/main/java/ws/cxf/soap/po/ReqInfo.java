package ws.cxf.soap.po;

import java.util.Date;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.activation.DataHandler;
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
	//年龄
	private Date birthDate;
	//文件传输，传输时需要给流FIle就可以
	private DataHandler data;
	/**
	 * 封装方式如下：
	 * 	InputStream inputStream = new FileInputStream(new File("c:\\11.docx"));
				DataSource dataSource = new InputStreamDataSource(inputStream, "application/octet-stream");
				DataHandler dataHandler = new DataHandler(dataSource);
				ReqInfo info = new ReqInfo();
				info.setData(dataHandler);
	 */
	//流形式发送附件，json忽略处理
	@XmlMimeType("application/octet-stream")
	@JsonIgnore
	public DataHandler getData() {
		return data;
	}
	public void setData(DataHandler data) {
		this.data = data;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
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
