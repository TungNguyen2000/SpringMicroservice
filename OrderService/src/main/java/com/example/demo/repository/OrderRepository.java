package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query(value="select * from `Order`", nativeQuery = true)
	List<Order> findAll();
}
