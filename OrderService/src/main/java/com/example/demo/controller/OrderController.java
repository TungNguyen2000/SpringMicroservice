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

import com.example.demo.service.OrderService;
import com.sun.istack.NotNull;
import com.example.demo.model.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("all")
	public List<Order> getAll()
	{
		return orderService.getAll();
	}
	
	@GetMapping("id/{id}")
	public Optional<Order> getByID(@PathVariable @NotNull int id)
	{
		return orderService.GetById(id);
	}
	
	@PostMapping("add")
	public Order saveOrder(@RequestBody Order order)
	{
		return orderService.saveOrder(order);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") int orderId, @RequestBody Order orderDetails) {
	     Order order = orderService.GetById(orderId)
	     .orElseThrow();

	     order.setTotalPrice(orderDetails.getTotalPrice());
	     order.setCustomerID(orderDetails.getCustomerID());
	     order.setEmployeeID(orderDetails.getEmployeeID());
	     order.setOrderStatus(orderDetails.getOrderStatus());
	     final Order updatedOrder = orderService.saveOrder(order);
	     return ResponseEntity.ok(updatedOrder);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable(value = "id") int orderId) throws Exception {
		
		 try{orderService.Delete(orderId);
	     return ResponseEntity.ok("success");}
		 catch(Exception e) {
			 throw e;
		 }
	}
}
