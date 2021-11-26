package model.dao;

import java.util.List;

import model.entities.Product;

public interface ProductDao {
	
	void insert(Product obj);
	void upadate(Product obj);
	void deleteById(Product obj);
	Product findById(Integer id);
	List<Product> findALL();

}
