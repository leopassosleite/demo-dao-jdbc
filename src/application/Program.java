package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Eletrônicos");
		
		Product product = new Product(21, "Xbox", new Date(), 6100.0, obj);
		
		System.out.println(product);

	}

}
