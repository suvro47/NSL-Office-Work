package com.product.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.product.manager.model.Product;
import com.product.manager.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Product> products = productService.allProduct();
		model.addAttribute("allProduct", products);
		return "home";
	}
	
	@RequestMapping("/new")
	public String getAddForm(Model model) {
	    Product product = new Product();  // its need to fulfill the form object.
	    model.addAttribute("product", product);
		return "new_product";
	}
	
	@RequestMapping("/save")
	public String saveProduct(Product product) {
		productService.saveProduct(product);
		return "redirect:/";  // redirect on home
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editProduct( @PathVariable(value="id") Long productId ) {
		ModelAndView mv = new ModelAndView();
		Product product = productService.findById(productId);
		mv.addObject("product", product);
		mv.setViewName("new_product");
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct( @PathVariable(value="id") Long productId ) {
		productService.deleteById(productId);
		return "redirect:/";  // redirect on home
	}

}
