package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Department;
import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println("\n=== TEST 4: product insert ===");
		Product newProduct = new Product(null, "Televisor", new Date(), 2, 1800.0, department);
		productDao.insert(newProduct);
		System.out.println("Inserted! New id = " + newProduct.getId());
		
		System.out.println("\n=== TEST 5: product update ===");
		product = productDao.findById(1);
		product.setName("Máquina de lavar");
		productDao.upadate(product);
		System.out.println("Updade completo");
		
		System.out.println("\n=== TEST 6: product delete ===");
		System.out.println("Informe um id para deletar: ");
		int id = sc .nextInt();
		productDao.deleteById(id);
		System.out.println("Deletado com sucesso!");
	}
}
