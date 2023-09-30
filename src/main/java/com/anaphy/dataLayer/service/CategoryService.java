package com.anaphy.dataLayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anaphy.dataLayer.model.Category;
import com.anaphy.dataLayer.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public Iterable<Category> getCategiries() {
		return categoryRepository.findAll();
	}

	public Optional<Category> getCategoryById(Integer id) {
		return categoryRepository.findById(id);
	}

	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	public void deleteCategoryById(Integer id) {
		categoryRepository.deleteById(id);
	}
}
