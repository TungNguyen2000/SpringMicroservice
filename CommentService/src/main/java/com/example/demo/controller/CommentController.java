package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CommentService;
import com.sun.istack.NotNull;
import com.example.demo.model.Comment;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService CommentService;
	
	@GetMapping("all")
	public List<Comment> getAll()
	{
		return CommentService.getAll();
	}
	
	@GetMapping("id/{id}")
	public Optional<Comment> getByID(@PathVariable @NotNull int id)
	{
		return CommentService.GetById(id);
	}
	
	@PostMapping("add")
	public Comment saveComment(@RequestBody Comment Comment)
	{
		return CommentService.saveComment(Comment);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable(value = "id") int CommentId, @RequestBody Comment CommentDetails) {
	     Comment Comment = CommentService.GetById(CommentId)
	     .orElseThrow();

	     Comment.setCommentId(CommentDetails.getCommentId());
	     Comment.setContent(CommentDetails.getContent());
	     Comment.setCustomerID(CommentDetails.getCustomerID());
	     final Comment updatedComment = CommentService.saveComment(Comment);
	     return ResponseEntity.ok(updatedComment);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable(value = "id") int CommentId) throws Exception {
		
		 try{CommentService.Delete(CommentId);
	     return ResponseEntity.ok("success");}
		 catch(Exception e) {
			 throw e;
		 }
	}
}
