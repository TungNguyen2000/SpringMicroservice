package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrderProduct;
import com.example.demo.repository.OrderProductRepository;

@Service
public class OrderProductService {
	@Autowired
	private OrderProductRepository _OrderProductRepository;

	public OrderProduct saveOrderProduct(OrderProduct OrderProduct)
	{
		return _OrderProductRepository.save(OrderProduct);
	}
	
	public List<OrderProduct> getAll()
	{
		return _OrderProductRepository.findAll();
	}
	
	public Optional<OrderProduct> GetById(int i)
	{
		 return _OrderProductRepository.findById(i);
	}
	
	public void Delete(int i)
	{
		_OrderProductRepository.deleteById(i);
		return ;
	}
}
