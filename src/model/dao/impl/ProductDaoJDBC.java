package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ProductDao;
import model.entities.Department;
import model.entities.Product;

public class ProductDaoJDBC implements ProductDao {

	private Connection conn;

	public ProductDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Product obj) {

	}

	@Override
	public void upadate(Product obj) {

	}

	@Override
	public void deleteById(Product obj) {

	}

	@Override
	public Product findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT product.*,department.Name as DepName "
					+ " FROM product INNER JOIN department "			
					+ "ON product.DepartmentId = department.Id "
					+ "WHERE product.Id = ? ");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				Product obj = instantiateProduct(rs, dep);
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Product instantiateProduct(ResultSet rs, Department dep) throws SQLException {
		Product obj = new Product();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setPrice(rs.getDouble("Price"));
		obj.setQuantity(rs.getInt("Quantity"));
		obj.setSaleDate(rs.getDate("SaleDate"));
		obj.setDepartment(dep);
		return obj;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Product> findALL() {

		return null;
	}
}
