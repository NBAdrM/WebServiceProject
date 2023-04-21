package project.shop.web.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import project.shop.web.data.Client;
import project.shop.web.data.Order;
import project.shop.web.data.Product;
import project.shop.web.service.ClientService;

@WebService
public class ShopService {

    private ClientService clientService = new ClientService();

    @WebMethod(operationName = "addClient")
    @WebResult(name = "client")
    public Client addClient(@WebParam(name = "client") Client client) {
        return clientService.addClient(client);
    }

    @WebMethod(operationName = "addOrder")
    @WebResult(name = "order")
    public Order addOrder(@WebParam(name = "order") Order order) {
        return clientService.addOrder(order);
    }

    @WebMethod(operationName = "getOrder")
    @WebResult(name = "order")
    public Order getOrder(@WebParam(name = "id") int id) {
        return clientService.getOrder(id);
    }

    @WebMethod(operationName = "deleteClient")
    public void deleteClient(@WebParam(name = "id") int id) {
        clientService.deleteClient(id);
    }

    @WebMethod(operationName = "getClient")
    @WebResult(name = "client")
    public Client getClient(@WebParam(name = "id") int id) {
        return clientService.getClient(id);
    }

    @WebMethod(operationName = "getAllOrder")
    @WebResult(name = "order")
    public Order[] getAllOrder() {
        return clientService.getAllOrder();
    }

    @WebMethod(operationName = "getAllProduct")
    @WebResult(name = "product")
    public Product[] getAllProduct() {
        return clientService.getAllProduct();
    }

    @WebMethod(operationName = "getAllClient")
    @WebResult(name = "client")
    public Client[] getAllClient() {
        return clientService.getAllClient();
    }

    @WebMethod(operationName = "updateClient")
    @WebResult(name = "client")
    public Client updateClient(@WebParam(name = "id") int id, @WebParam(name = "client") Client client) {
        client.setId(id);
        return clientService.updateClient(client);
    }
}
