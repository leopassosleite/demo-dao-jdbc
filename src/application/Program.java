package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Department;
import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		ProductDao productDao = DaoFactory.createProductDao();
		
		System.out.println("=== TEST 1: product findById ===");
		Product product = productDao.findById(2);
		System.out.println(product);
		
		System.out.println("\n=== TEST 2: product findByDepartment ===");
		Department department = new Department(3, null);
		List<Product> list = productDao.findByDepartment(department);
		for (Product obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: product findAll ===");
		list = productDao.findALL();
		for (Product obj : list) {
			System.out.println(obj);
		}
	}
}
