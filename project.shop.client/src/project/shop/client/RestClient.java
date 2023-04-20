package project.shop.client;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
 
   private Client client = ClientBuilder.newClient();

   public Clients getClient(int id) {
	   String url = "http://localhost:8080/project.shop.web/api/clients/"+String.valueOf(id);
       return client
         .target(url)
         .request(MediaType.APPLICATION_XML)
         .get(Clients.class);
   }
   
   public Clients[] getAllClients() {
	   String url = "http://localhost:8080/project.shop.web/api/clients";
       return client
         .target(url)
         .request(MediaType.APPLICATION_XML).get(new GenericType<Clients[]> () {});
   }
   public Response createXMLClient(Clients c) {
	   String url = "http://localhost:8080/project.shop.web/api/clients";
	    return client
	      .target(url)
	      .request(MediaType.APPLICATION_XML)
	      .post(Entity.entity(c, MediaType.APPLICATION_XML));
	}
   public Order[] getAllOrders() {
	   String url = "http://localhost:8080/project.shop.web/api/clients/order";
       return client
         .target(url)
         .request(MediaType.APPLICATION_XML).get(new GenericType<Order[]> () {});
   }
   public Product[] getAllProducts() {
	   String url = "http://localhost:8080/project.shop.web/api/clients/products";
       return client
         .target(url)
         .request(MediaType.APPLICATION_XML).get(new GenericType<Product[]> () {});
   }
   
}
