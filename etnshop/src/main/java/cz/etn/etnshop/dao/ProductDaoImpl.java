package cz.etn.etnshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		Criteria criteria = getSession().createCriteria(Product.class);
		return (List<Product>) criteria.list();
	}

	public void saveProduct(Product product){
		getSession().saveOrUpdate(product);
		getSession().flush();
	}

	@Override
	public Product getById(Integer id) {
		return (Product) getSession().get(Product.class,id);

	}

	public List<Product> searchProducts(String query){
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.or(
				Restrictions.ilike("name",query, MatchMode.ANYWHERE),
				Restrictions.sqlRestriction(
						"CAST(serial_number AS CHAR) LIKE ?",
						"%"+query+"%",
						StringType.INSTANCE
				)
		));
		return (List<Product>) criteria.list();
	}

}
