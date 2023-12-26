
package com.amine.productandcategorie.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amine.productandcategorie.models.Category;
import com.amine.productandcategorie.models.Product;
import com.amine.productandcategorie.services.AppService;

import jakarta.validation.Valid;

@Controller
public class AppController {
	private final AppService appService;
	public AppController(AppService appService) {
        this.appService= appService;
    }
	
	@RequestMapping("/")
    public String index(Model model) {
		List<Product> allProducts=appService.allProducts();
      	 model.addAttribute("allproducts",allProducts);
      	 
      	List<Category> allCategories=appService.allCategories();
     	 model.addAttribute("allcategories",allCategories);
     	 
        return "index.jsp";
    }
	
	@RequestMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "product.jsp";
    }
	
	@RequestMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "category.jsp";
    }
	
	@RequestMapping("/newproduct")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
            if (result.hasErrors()) {
                return "product.jsp";
            }
            else {
                appService.createProduct(product);
                return "redirect:/";
            }
        }
	
	@RequestMapping("/newcategory")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
            if (result.hasErrors()) {
                return "category.jsp";
            }
            else {
                appService.createCategory(category);
                return "redirect:/";
            }
        }
	
	@RequestMapping("/products/new/{id}")
	public String addProductToCat(@PathVariable("id") Long id ,Model model) {
		Product pro=appService.findProduct(id);
		model.addAttribute("pro1",pro);
		model.addAttribute("category",appService.findByProductsNotContains(pro));
		return "viewproduct.jsp";
		
	}
	@PostMapping("/products/new/{id}")
	public String submitProductToForm(@PathVariable("id") Long id,@RequestParam("category") Long Cat_id,Model model) {
		Category category=appService.findCategory(Cat_id);
		Product pro=appService.findProduct(id);
		List<Category> cat=pro.getCategories();
		cat.add(category);
		pro.setCategories(cat);
		appService.updateProduct(pro);
		return "redirect:/";
			
	}
	// added category to product 
	@RequestMapping("/category/new/{id}")
	public String addCategoryToProduct(@PathVariable("id") Long id ,Model model) {
		Category cat =appService.findCategory(id);
		model.addAttribute("cat1",cat);
		model.addAttribute("product",appService.findByCategoriesNotContains(cat));
		return "viewcategory.jsp";
	}
	@PostMapping("/category/new/{id}")
	public String submitCategoryToForm(@PathVariable("id") Long id,@RequestParam("product") Long prod_id,Model model) {
		Category category =appService.findCategory(id);
		Product pro=appService.findProduct(prod_id);
		List<Product> prod=category.getProducts();
		prod.add(pro);
		category.setProducts(prod);
		appService.updateCategory(category);

		return "redirect:/";
		
	}
	@GetMapping("/products/{id}")
    public String viewProduct(@PathVariable("id") Long id,Model model,@ModelAttribute("product") Product product) {
	 Product product1 = appService.findProduct(id);
     model.addAttribute("product",product1);
     List<Category> missingCategories=appService.findByProductsNotContains(product1);
 	 model.addAttribute("missingcategories",missingCategories);
 	List<Category> existingCategories=appService.findCategoriesByProduct(product1);
	 model.addAttribute("existingcategories",existingCategories);
        return "viewproduct.jsp";
    }
	
	@GetMapping("/categories/{id}")
    public String viewCategory(@PathVariable("id") Long id,Model model,@ModelAttribute("category") Category category) {
	 Category category1 = appService.findCategory(id);
     model.addAttribute("category",category1);
     List<Product> missingProducts=appService.findByCategoriesNotContains(category1);
 	 model.addAttribute("missingproducts",missingProducts);
 	List<Product> existingProducts=appService.findProductsByCategory(category1);
	 model.addAttribute("existingproducts",existingProducts);
        return "viewcategory.jsp";
    }
	}
	
