package com.anaphy.dataLayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anaphy.dataLayer.model.Comment;
import com.anaphy.dataLayer.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;

	public Iterable<Comment> getComments() {
		return commentRepository.findAll();
	}

	public Optional<Comment> getCommentById(Integer id) {
		return commentRepository.findById(id);
	}

	public Comment addComment(Comment comment) {
		return commentRepository.save(comment);
	}

	public void deleteComment(Integer id) {
		commentRepository.deleteById(id);
	}
}
