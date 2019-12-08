package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		List<OrderItem> itens = new ArrayList<>();
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date dateBirth = sdf.parse(sc.next());
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.next();
		
		Order order = new Order(OrderStatus.valueOf(orderStatus), new Client(name, email, dateBirth));
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=1; i<=n; i++) {
			
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String prodName = sc.nextLine();
			System.out.print("Product price: ");
			double prodPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			int prodQuant = sc.nextInt();
			
			OrderItem prodOrder = new OrderItem(prodQuant, prodPrice, new Product(prodName, prodPrice));
			order.addItem(prodOrder);
						
			sc.nextLine();
			System.out.println();
		}
		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		sc.close();
	}
}
