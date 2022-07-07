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

import com.example.demo.service.ProductService;
import com.sun.istack.NotNull;
import com.example.demo.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService ProductService;
	
	@GetMapping("all")
	public List<Product> getAll()
	{
		return ProductService.getAll();
	}
	
	@GetMapping("id/{id}")
	public Optional<Product> getByID(@PathVariable @NotNull int id)
	{
		return ProductService.GetById(id);
	}
	
	@PostMapping("add")
	public Product saveProduct(@RequestBody Product product)
	{
		return ProductService.saveProduct(product);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") int ProductId, @RequestBody Product ProductDetails) {
	     Product Product = ProductService.GetById(ProductId)
	     .orElseThrow();

	     Product.setPrice(ProductDetails.getPrice());
	     Product.setProductImage(ProductDetails.getProductImage());
	     Product.setProductName(ProductDetails.getProductName());
	     Product.setProductTypeID(ProductDetails.getProductTypeID());
	     Product.setSoluong(ProductDetails.getSoluong());
	     final Product updatedProduct = ProductService.saveProduct(Product);
	     return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") int ProductId) throws Exception {
		
		 try{ProductService.Delete(ProductId);
	     return ResponseEntity.ok("success");}
		 catch(Exception e) {
			 throw e;
		 }
	}
}
