package com.anaphy.dataLayer.repository;

import org.springframework.data.repository.CrudRepository;

import com.anaphy.dataLayer.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
