package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository _CommentRepository;

	public Comment saveComment(Comment Comment)
	{
		return _CommentRepository.save(Comment);
	}
	
	public List<Comment> getAll()
	{
		return _CommentRepository.findAll();
	}
	
	public Optional<Comment> GetById(int i)
	{
		 return _CommentRepository.findById(i);
	}
	
	public void Delete(int i)
	{
		_CommentRepository.deleteById(i);
		return ;
	}
}
