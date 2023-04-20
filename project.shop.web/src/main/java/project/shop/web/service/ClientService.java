package project.shop.web.service;
import java.util.*;

import project.shop.web.data.*;

public class ClientService {
	private static Map<Integer, Client> CLIENT_DATA = new HashMap<Integer, Client>();
	
	private int getNewIdClient() {
		int newId = 0;
		ConnectBD conBD = new ConnectBD();
	    Map<Integer, Client> clientMap = conBD.getClient();
		for (int id : clientMap.keySet()) {
			if (newId < id)
				newId = id;
	 	}
		return ++newId;
	}
	@SuppressWarnings("unused")
	private int getNewIdProduct() {
		int newId = 0;
		ConnectBD conBD = new ConnectBD();
	    Map<Integer, Product> productMap = conBD.getProduct();
		for (int id : productMap.keySet()) {
			if (newId < id)
				newId = id;
	 	}
		return ++newId;
	}
	
	private int getNewIdOrder() {
		int newId = 0;
		ConnectBD conBD = new ConnectBD();
	    Map<Integer, Order> orderMap = conBD.getOrders();
		for (int id : orderMap.keySet()) {
			if (newId < id)
				newId = id;
	 	}
		return ++newId;
	}
	
	public Order getOrder(int id) {
		ConnectBD conBD = new ConnectBD();
	    Map<Integer, Order> orderMap = conBD.getOrders();
	    return orderMap.get(id);
	}
	
	public Order addOrder(Order o) {
		int id = getNewIdOrder();
		ConnectBD conBD = new ConnectBD();
	    Map<Integer, Order> orderMap = conBD.getOrders();
		if(orderMap.get(o.getId_order()) != null) {
			return null;
		}

		Map<Integer, Product> productMap = conBD.getProduct();
		if(productMap.get(o.getId_product()) == null) {
			return null;
		}
		Product p = productMap.get(o.getId_product());
		int less = p.getQuantity()-o.getNb_product();
		conBD.lessProduct(p.getId(), less);
		o.setId_order(id);
		conBD.putOrder(o);
		return o;
	}
	
	public Client addClient(Client c) {
		int id = getNewIdClient();
		ConnectBD conBD = new ConnectBD();
	    Map<Integer, Client> clientMap = conBD.getClient();
		if(clientMap.get(c.getId()) != null) {
			return null;
		}
		c.setId(id);
		c.setActive(true);
		CLIENT_DATA.put(id, c);
		return c;
	}
	public boolean deleteClient(int id) {
		ConnectBD conBD = new ConnectBD();
		Map<Integer, Client> clientMap = conBD.getClient();
		if(CLIENT_DATA.get(id) == null) {
			return false;
		}
		Client c = clientMap.get(id);
		c.setActive(false);
		conBD.updateClient(id, c);
		return true;
	}
	
	public Client getClient(int id) {
		ConnectBD conBD = new ConnectBD();
		Map<Integer, Client> clientMap = conBD.getClient();
		return clientMap.get(id);
	}
	
	public Product getProduct(int id) {
		ConnectBD conBD = new ConnectBD();
	    Map<Integer, Product> productMap = conBD.getProduct();
	    if (productMap == null) {
	        return null;
	    }
		return productMap.get(id);
	}
	
	public Client[] getAllClient() {
		ConnectBD conBD = new ConnectBD();
		Map<Integer, Client> clientMap = conBD.getClient();
		if (clientMap == null) {
			return null;
		}
		Collection<Client> values = clientMap.values();
		Client[] targetArray = values.toArray(new Client[0]);
		return targetArray;
	}
	
	public Order[] getAllOrder() {
		ConnectBD conBD = new ConnectBD();
	    Map<Integer, Order> orderMap = conBD.getOrders();
	    if (orderMap == null) {
	        return null;
	    }
	    Collection<Order> values = orderMap.values();
	    Order[] targetArray = values.toArray(new Order[0]);
	    return targetArray;
	}
	
	public Product[] getAllProduct() {
		ConnectBD conBD = new ConnectBD();
	    Map<Integer, Product> productMap = conBD.getProduct();
	    if (productMap == null) {
	        return null;
	    }
	    Collection<Product> values = productMap.values();
	    Product[] targetArray = values.toArray(new Product[0]);
	    return targetArray;
	}
	
	public Client updateClient(Client c) {
		int id = c.getId();
		ConnectBD conBD = new ConnectBD();
	    Map<Integer, Client> clientMap = conBD.getClient();
		if(clientMap.get(id) == null) {
			return null;
		}
		conBD.updateClient(id, c);
		return c;
	}
}
