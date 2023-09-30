package com.anaphy.dataLayer.repository;

import org.springframework.data.repository.CrudRepository;

import com.anaphy.dataLayer.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
