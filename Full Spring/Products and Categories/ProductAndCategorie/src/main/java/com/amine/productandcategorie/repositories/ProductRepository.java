package com.amine.productandcategorie.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.amine.productandcategorie.models.Category;
import com.amine.productandcategorie.models.Product;

public interface ProductRepository  extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category c);
}
