package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository _ProductRepository;

	public Product saveProduct(Product Product)
	{
		return _ProductRepository.save(Product);
	}
	
	public List<Product> getAll()
	{
		return _ProductRepository.findAll();
	}
	
	public Optional<Product> GetById(int i)
	{
		 return _ProductRepository.findById(i);
	}
	
	public void Delete(int i)
	{
		_ProductRepository.deleteById(i);
		return ;
	}
}
