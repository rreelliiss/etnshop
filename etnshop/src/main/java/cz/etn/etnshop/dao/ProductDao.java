package cz.etn.etnshop.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface ProductDao {

	@Transactional(readOnly = true)
	List<Product> getProducts();

	@Transactional(readOnly = false)
	void saveProduct(Product product);

	@Transactional(readOnly = true)
	Product getById(Integer id);

	@Transactional(readOnly = true)
	Object searchProducts(String query);
}
