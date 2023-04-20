package project.shop.client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	private String name;
	private float price;
	private Integer quantity;
	private Integer id;
	
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return name + "::" + price + "::" + quantity + "::" + id;
	}
	
	
}
