package com.anaphy.dataLayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anaphy.dataLayer.model.Category;
import com.anaphy.dataLayer.model.Comment;
import com.anaphy.dataLayer.model.Product;
import com.anaphy.dataLayer.service.CategoryService;
import com.anaphy.dataLayer.service.CommentService;
import com.anaphy.dataLayer.service.ProductService;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	CommentService commentService;

	@Autowired
	CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		 TODO Auto-generated method stub
//		Print Infornation from the table Product
		Iterable<Product> products = productService.getProducts();
		products.forEach(product -> System.out.println(product.getName()));

		Optional<Product> produitOpt = productService.getProduitById(3);
		Product produit = produitOpt.get();
		System.out.println(produit.getName());
		produit.getComments().forEach(comment -> System.out
				.println("There are lists of comment for the " + produit.getName() + " \n" + comment.getContent()));
//		Print information from the table Comment

		Iterable<Comment> comments = commentService.getComments();
		comments.forEach(comment -> System.out.println(comment.getContent()));

		Optional<Comment> commeOpt = commentService.getCommentById(1);
		Comment comment = commeOpt.get();
		System.out.println(comment.getContent());

//		Print information from the table category

		Iterable<Category> categories = categoryService.getCategiries();
		categories.forEach(categorie -> System.out.println(categorie.getName()));

		Optional<Category> categoryOpt = categoryService.getCategoryById(3);
		Category category = categoryOpt.get();
		System.out.println(category.getName());
		category.getProducts().forEach(prodCatP -> System.out.println(prodCatP.getName()));

//		I wanna print all products for the categorie n 1

		Optional<Category> catProdOpt = categoryService.getCategoryById(1);
		Category catprod = catProdOpt.get();
		System.out.println("\n\n" + catprod.getName());
		System.out.println("\n\n");
		catprod.getProducts().forEach(prodCatP -> System.out.println(prodCatP.getName()));

//		I wanna print all categories for the product n 1
		Optional<Product> prodCatOpt = productService.getProduitById(1);
		Product prodCat = prodCatOpt.get();
		System.out.println("\n\n" + prodCat.getName());
		System.out.println("\n\n");
		prodCat.getCategories().forEach(catP -> System.out.println(catP.getName()));

//		It's time to play by adding information in the Database
//		Add a name category into the Database
//		Category categoryAdd = new Category();
//		categoryAdd.setName("Alimentation");
//		categoryAdd = categoryService.addCategory(categoryAdd);

//		Add a name product into the Database
//		Product productAdd = new Product();
//		productAdd.setName("Bidon");
//		productAdd.setDescription("dxfcgvhbjnbhvgcfxdcfv");
//		productAdd.setCost(12000);
//		categoryAdd.addProduct(productAdd);
//		productAdd = productService.addProduct(productAdd);
//		My aim is to create a product couple with a comment
//		Comment commentAdd = new Comment();
//		commentAdd.setContent("um! Provident similique accusantium");
//		productAdd.addComment(commentAdd);
//		commentAdd = commentService.addComment(commentAdd);
//
//		System.out.println(commentAdd.getProduct().getName() + " \n" + commentAdd.getContent());

//		Update an existing product in the Database

		Product existingProduct = productService.getProduitById(1).get();
		System.out.println(existingProduct.getName());
		System.out.println(existingProduct.getCost());
		existingProduct.setCost(220000);

		productService.addProduct(existingProduct);
		System.out.println(existingProduct.getCost());

//		I'm trying to delete the comment number 3
//		commentService.deleteComment(3);

//		I write a code who get the product by name
		Iterable<Product> searchProducts = productService.getProductsByName("Lait");
		searchProducts.forEach(productByName -> System.out.println(productByName.getName()));

//		Search products by categories
		searchProducts = productService.findProductsByCategoryName("Cat 1");
		searchProducts.forEach(productByName -> System.out.println(productByName.getProductID()));

		System.out.println("Select Products using JPQL");
		Iterable<Product> productsJPQL = productService.getProductByNameJPQL("Lait");
		productsJPQL.forEach(productJPQL -> System.out.println(productJPQL.getName()));

//		Select list of product by the cost
		Iterable<Product> productsByCost = productService.findProductByCostNative(12000);
		productsByCost
				.forEach(productByCost -> System.out.println(productByCost.getName() + " " + productByCost.getCost()));
	}

}
