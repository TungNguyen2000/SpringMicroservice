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

import com.example.demo.service.OrderProductService;
import com.sun.istack.NotNull;
import com.example.demo.model.OrderProduct;

@RestController
@RequestMapping("/OrderProduct")
public class OrderProductController {

	@Autowired
	OrderProductService OrderProductService;
	
	@GetMapping("all")
	public List<OrderProduct> getAll()
	{
		return OrderProductService.getAll();
	}
	
	@GetMapping("id/{id}")
	public Optional<OrderProduct> getByID(@PathVariable @NotNull int id)
	{
		return OrderProductService.GetById(id);
	}
	
	@PostMapping("add")
	public OrderProduct saveOrderProduct(@RequestBody OrderProduct OrderProduct)
	{
		return OrderProductService.saveOrderProduct(OrderProduct);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<OrderProduct> updateOrderProduct(@PathVariable(value = "id") int OrderProductId, @RequestBody OrderProduct OrderProductDetails) {
	     OrderProduct OrderProduct = OrderProductService.GetById(OrderProductId)
	     .orElseThrow();

	     OrderProduct.setDonGia(OrderProductDetails.getDonGia());
	     OrderProduct.setOrderId(OrderProductDetails.getOrderId());
	     OrderProduct.setProductID(OrderProductDetails.getProductID());
	     OrderProduct.setSoLuong(OrderProductDetails.getSoLuong());
	     final OrderProduct updatedOrderProduct = OrderProductService.saveOrderProduct(OrderProduct);
	     return ResponseEntity.ok(updatedOrderProduct);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteOrderProduct(@PathVariable(value = "id") int OrderProductId) throws Exception {
		
		 try{OrderProductService.Delete(OrderProductId);
	     return ResponseEntity.ok("success");}
		 catch(Exception e) {
			 throw e;
		 }
	}
}
