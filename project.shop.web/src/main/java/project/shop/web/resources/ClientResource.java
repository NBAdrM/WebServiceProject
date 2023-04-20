package project.shop.web.resources;
import java.net.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import project.shop.web.data.*;
import project.shop.web.service.*;
@Path("/clients")

public class ClientResource {
		ClientService service = new ClientService();
		@Context
		UriInfo uriInfo;
		 
		 
		@POST
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.APPLICATION_XML)
		public Response addClient(Client c) {
			Client client = service.addClient(c);
			if(client == null) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			URI uri = uriInfo.getRequestUri();
			String newUri = uri.getPath() + "/" + client.getId();
			return Response.status(Response.Status.CREATED)
			.entity(client)
			.contentLocation(uri.resolve(newUri))
			.build();
		}
		
		@POST
		@Path("/order")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.APPLICATION_XML)
		public Response addOrder(Order o) {
			Order order = service.addOrder(o);
			if(order == null) {
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			URI uri = uriInfo.getRequestUri();
			String newUri = uri.getPath() + "/" + order.getId_order();
			return Response.status(Response.Status.CREATED)
			.entity(order)
			.contentLocation(uri.resolve(newUri))
			.build();
		}
		
		@GET
		@Path("order/{id}")
		@Produces(MediaType.APPLICATION_XML)
		public Response getOrder(@PathParam("id") int id) {
			Order order = service.getOrder(id);
			if(order == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			Link link = Link.fromUri(uriInfo.getRequestUri())
			.rel("self")
			.type("application/xml")
			.build();
			return Response.status(Response.Status.OK)
			.entity(order)
			.links(link)
			.build();
		}
		
		@DELETE
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_XML)
		public Response deleteClient(@PathParam("id") int id) {
			if(service.deleteClient(id) == false) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			return Response.status(Response.Status.OK).build();
		}
		
		
		
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_XML)
		public Response getClient(@PathParam("id") int id) {
			Client client = service.getClient(id);
			if(client == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			Link link = Link.fromUri(uriInfo.getRequestUri())
			.rel("self")
			.type("application/xml")
			.build();
			return Response.status(Response.Status.OK)
			.entity(client)
			.links(link)
			.build();
		}
		@Path("/order")
		@GET
		@Produces(MediaType.APPLICATION_XML)
		public Response getAllOrder() {
			Order[] orders = service.getAllOrder();
			if(orders == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			Link link = Link.fromUri(uriInfo.getRequestUri())
			.rel("self")
			.type("application/xml")
			.build();
			return Response.status(Response.Status.OK)
			.entity(orders)
			.links(link)
			.build();
		}
		
		@Path("/products")
		@GET
		@Produces(MediaType.APPLICATION_XML)
		public Response getAllProduct() {
			Product[] products = service.getAllProduct();
			if(products == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			Link link = Link.fromUri(uriInfo.getRequestUri())
			.rel("self")
			.type("application/xml")
			.build();
			return Response.status(Response.Status.OK)
			.entity(products)
			.links(link)
			.build();
		}
		 
		@GET
		@Produces(MediaType.APPLICATION_XML)
		public Response getAllClient() {
			Client[] clients = service.getAllClient();
			if(clients == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			Link link = Link.fromUri(uriInfo.getRequestUri())
			.rel("self")
			.type("application/xml")
			.build();
			return Response.status(Response.Status.OK)
			.entity(clients)
			.links(link)
			.build();
		}
		 
		@PUT
		@Path("/{id}")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.APPLICATION_XML)
		public Response updateClient(@PathParam("id") int id, Client c) {
			Client client = service.updateClient(c);
			if(client == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			URI uri = uriInfo.getRequestUri();
			String newUri = uri.getPath() + "/" + client.getId();
			return Response.status(Response.Status.CREATED)
			.entity(client)
			.contentLocation(uri.resolve(newUri))
			.build();
		}
}