package com.anaphy.dataLayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anaphy.dataLayer.model.Product;
import com.anaphy.dataLayer.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProduitById(Integer id) {
		return productRepository.findById(id);
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
	}

//	This method help me to select many products by name
	public Iterable<Product> getProductsByName(String name) {
		return productRepository.findByName(name);
	}

//	Select list of product with the category
	public Iterable<Product> findProductsByCategoryName(String name) {
		return productRepository.findByCategoriesName(name);
	}

//	Select product by the name using JPQL
	public Iterable<Product> getProductByNameJPQL(String name) {
		return productRepository.findByNameJPQL(name);
	}

//	Select product by the cost
	public Iterable<Product> findProductByCostNative(Integer cost) {
		return productRepository.findByCostNative(cost);
	}
}
