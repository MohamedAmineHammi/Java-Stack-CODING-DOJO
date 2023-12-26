package com.amine.productandcategorie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amine.productandcategorie.models.Category;
import com.amine.productandcategorie.models.Product;
import com.amine.productandcategorie.repositories.CategoryRepository;
import com.amine.productandcategorie.repositories.ProductRepository;

@Service
public class AppService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
		
		public AppService(ProductRepository productRepository,CategoryRepository categoryRepository) {
	        this.productRepository = productRepository;
	        this.categoryRepository= categoryRepository;
	    }
		
		
		public List<Product> allProducts() {
	        return productRepository.findAll();
	    }
		
		public List<Category> allCategories() {
	        return categoryRepository.findAll();
	    }

	    public Product createProduct(Product b) {
	        return productRepository.save(b);
	    }
	    
	    public Category createCategory(Category b) {
	        return categoryRepository.save(b);
	    }

	    public Product findProduct(Long id) {
	        Optional<Product> optionalProduct = productRepository.findById(id);
	        if(optionalProduct.isPresent()) {
	            return optionalProduct.get();
	        } else {
	            return null;
	        }
	    }
	    
	    public Category findCategory(Long id) {
	        Optional<Category> optionalCategory = categoryRepository.findById(id);
	        if(optionalCategory.isPresent()) {
	            return optionalCategory.get();
	        } else {
	            return null;
	        }
	    }
	    
		public void deleteProduct(Long id) {
			productRepository.deleteById(id);
		}
		
		public void deleteCategory(Long id) {
			categoryRepository.deleteById(id);
		}
		
		public Product updateProduct(Product b) {
			productRepository.save(b);
			return b;
		}
		
		public Category updateCategory(Category b) {
			categoryRepository.save(b);
			return b;
		}
		
		public List<Category> findCategoriesByProduct(Product b){
			return categoryRepository.findAllByProducts(b);
		}
		
		public List<Product> findProductsByCategory(Category b){
			return productRepository.findAllByCategories(b);
		}
		
		public List<Product> findByCategoriesNotContains(Category b){
			return productRepository.findByCategoriesNotContains(b);
		}
		
		public List<Category> findByProductsNotContains(Product b){
			return categoryRepository.findByProductsNotContains(b);
		}
		
		
		public Category addProductToCategory(Category cat,Product prod) {
			cat.getProducts().add(prod);
			categoryRepository.save(cat);
			return cat;
		}
		
		public Product addCategoryToProduct(Category cat,Product prod) {
			prod.getCategories().add(cat);
			productRepository.save(prod);
			return prod;
		}
}
