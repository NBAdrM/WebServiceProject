package project.shop.client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Clients {
	private String name;
	private String pwd;
	private Integer id;
	private boolean active;
	
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return name + "::" + pwd + "::" + id + "::" + active ;
	}
	
}
