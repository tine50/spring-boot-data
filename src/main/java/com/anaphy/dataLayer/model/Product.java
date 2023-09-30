package com.anaphy.dataLayer.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Produit")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produit_id")
	private int productID;

	@Column(name = "nom")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "cout")
	private int cost;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Comment> comments = new ArrayList<>();

	@ManyToMany(mappedBy = "products", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	List<Category> categories = new ArrayList<>();

	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setProduct(this);
	}

	public void removeComment(Comment comment) {
		comments.remove(comment);
		comment.setProduct(null);
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
