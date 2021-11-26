package model.dao;

public class DaoFactory {
	
	public static ProductDao createProductDao() {
		return new ProductDaoJDBC();
	}

}
