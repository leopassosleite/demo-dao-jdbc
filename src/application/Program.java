package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Department;
import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Eletrônicos");
		
		Product product = new Product(21, "Xbox", new Date(), 6100.0, obj);
		
		ProductDao productDao = DaoFactory.createProductDao();
		
		System.out.println(product);

	}

}
