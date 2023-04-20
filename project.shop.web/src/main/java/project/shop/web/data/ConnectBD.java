package project.shop.web.data;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectBD {
	public Order putOrder(Order o) {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://mysql-maestri.alwaysdata.net:3306/maestri_web_service", "maestri" , "Suzuki1100!");
		Statement stmt = conn.createStatement();
		String query = "INSERT INTO `command` (`id_client`, `id_produc`, `id_order`, `date`, `nb_product`) VALUES ('"+o.getId_client()+"', '"+o.getId_product()+"', '"+o.getId_order()+"', CURRENT_TIMESTAMP, '"+o.getNb_product()+"');";
		stmt.executeUpdate(query);
		return o;
		}catch(Exception e){ 
			System.out.println(e);
			return null;
		}
	}
	
	public Client putClient(Client c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://mysql-maestri.alwaysdata.net:3306/maestri_web_service", "maestri" , "Suzuki1100!");
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO `client` (`id`, `name`, `pwd`, `active`) VALUES ('"+c.getId()+"', '"+c.getName()+"', '"+c.getPwd()+"', '"+c.isActive()+"');";
			stmt.executeUpdate(query);
			return c;
		}catch(Exception e){ 
			System.out.println(e);
			return null;
		}
	}
	
	public Map<Integer, Order> getOrders(){
		try{
			Map<Integer, Order> orders  = new HashMap<Integer,Order>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://mysql-maestri.alwaysdata.net:3306/maestri_web_service", "maestri" , "Suzuki1100!");
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM command");
			
			while(res.next()) {
				Order o = new Order();
				o.setId_client(res.getInt(1));
				o.setId_product(res.getInt(2));
				o.setId_order(res.getInt(3));
				o.setDate(res.getString(4));
				o.setNb_product(res.getInt(5));
				orders.put(o.getId_order(), o);
			}
			conn.close();
			return orders;
		}
		catch(Exception e){ 
			System.out.println(e);
			return null;
		}
	}
	
	public Map<Integer, Client> getClient(){
		try{
			Map<Integer, Client> clients  = new HashMap<Integer,Client>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://mysql-maestri.alwaysdata.net:3306/maestri_web_service", "maestri" , "Suzuki1100!");
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM client");
			
			while(res.next()) {
				Client c = new Client();
				c.setId(res.getInt(1));
				c.setName(res.getString(2));
				c.setPwd(res.getString(3));
				c.setActive(res.getBoolean(3));
				clients.put(c.getId(), c);
			}
			conn.close();
			return clients;
		}
		catch(Exception e){ 
			System.out.println(e);
			return null;
		}
		
	}
	
	public Client updateClient(int id, Client c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://mysql-maestri.alwaysdata.net:3306/maestri_web_service", "maestri" , "Suzuki1100!");
			Statement stmt = conn.createStatement();
			String query = "UPDATE `client` SET 'name'="+c.getName()+", 'pwd'="+c.getPwd()+" , 'active'="+c.isActive()+" WHERE `client`.`id` = "+id+";";
			stmt.executeUpdate(query);
			return c;
		}
		catch(Exception e){ 
			System.out.println(e);
			return null;
		}
	}
	
	public void lessProduct(int id, int less) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://mysql-maestri.alwaysdata.net:3306/maestri_web_service", "maestri" , "Suzuki1100!");
			Statement stmt = conn.createStatement();
			String query = "UPDATE `product` SET `nomber` = '"+less+"' WHERE `product`.`id` = "+id+";";
			stmt.executeUpdate(query);
		}
		catch(Exception e){ 
			System.out.println(e);
		}
	}
	
	public Map<Integer, Product> getProduct(){
		try{
			Map<Integer, Product> products  = new HashMap<Integer,Product>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://mysql-maestri.alwaysdata.net:3306/maestri_web_service", "maestri" , "Suzuki1100!");
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM product");
			
			while(res.next()) {
				Product product = new Product();
				product.setId(res.getInt(1));
				product.setName(res.getString(2));
				product.setPrice(res.getFloat(3));
				product.setQuantity(res.getInt(4));
				products.put(product.getId(), product);
			}
			conn.close();
			return products;
		}
		catch(Exception e){ 
			System.out.println(e);
			return null;
		}
		
	}
}
