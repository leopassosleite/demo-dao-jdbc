package application;

import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		ProductDao productDao = DaoFactory.createProductDao();
		
		System.out.println("=== TEST1: product findById ===");
		Product product = productDao.findById(3);

		System.out.println(product);
	}
}
