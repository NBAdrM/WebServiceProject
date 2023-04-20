package project.shop.web.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	private int id_order;
	private int id_client;
	private int id_product;
	private String date;
	private int nb_product;
	public int getId_order() {
		return id_order;
	}
	public void setId_order(int id_order) {
		this.id_order = id_order;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNb_product() {
		return nb_product;
	}
	public void setNb_product(int nb_product) {
		this.nb_product = nb_product;
	}
	@Override
	public String toString() {
		return id_order + " :: " + id_client + " :: " + id_product + " :: " + date + " :: " + nb_product ;
	}
	
}
