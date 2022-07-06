package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository _orderRepository;

	public Order saveOrder(Order order)
	{
		return _orderRepository.save(order);
	}
	
	public List<Order> getAll()
	{
		return _orderRepository.findAll();
	}
}
