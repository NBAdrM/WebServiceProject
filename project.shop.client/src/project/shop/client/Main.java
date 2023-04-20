package project.shop.client;


import java.util.*;

import javax.ws.rs.core.Response;


public class Main {
	public static void main(String[] args) {
		boolean start = true;
		Scanner sc;
		RestClient client = new RestClient();
		Response response;
		while(start) {
			sc = new Scanner(System.in);
			System.out.println("\nVeuillez saisir un nombre\n 0 : Quittez\n 1 : Voir les clients\n 2 : Voir un client\n 3 : Ajouter un client\n 4 : Voir les commandes\n 5 : Ajouter une commande\n 6 : Voir les produits");
			int entrer = sc.nextInt();
			System.out.println(entrer);
			if(entrer == 0) {
				start = false;
			}
			else if(entrer == 1) {
				Clients[] clients = client.getAllClients();
				System.out.println("La liste des clients :");
				for (int i = 0; i < clients.length; i++) {
					System.out.println(clients[i].toString());
				}
			}
			else if(entrer == 2) {
				System.out.println("Entrer l'id du client");
				sc = new Scanner(System.in);
				int id = sc.nextInt();
				Clients c = client.getClient(id); 
				System.out.println(c.toString());
			}
			else if(entrer == 3) {
				System.out.println("Entrer votre nom");
				sc = new Scanner(System.in);
				String tmp = sc.nextLine();
				Clients c = new Clients();
				c.setName(tmp);
				System.out.println("Entrer votre mot de passe");
				sc = new Scanner(System.in);
				tmp = sc.nextLine();
				c.setPwd(tmp);
				response = client.createXMLClient(c);
				if (response.getStatus() == 200 || response.getStatus() == 201)
					System.out.println("Le client a été créer");				
				else
					System.out.println("Probleme avec la création du client avec le status :"+response.getStatus());
			}
			else if(entrer == 4) {
				Order[] orders = client.getAllOrders();
				System.out.println("La liste des commandes :");
				for (int i = 0; i < orders.length; i++) {
					System.out.println(orders[i].toString());
				}
			}
			else if(entrer == 5) {
				
			}
			else if(entrer == 6) {
				Product[] products = client.getAllProducts();
				System.out.println("La liste des produits :");
				for (int i = 0; i < products.length; i++) {
					System.out.println(products[i].toString());
				}
			}
			else if(entrer == 7) {
				
			}
		}
	}
}
