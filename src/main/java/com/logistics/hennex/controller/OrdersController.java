package com.logistics.hennex.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.logistics.hennex.exception.ResourceNotFoundException;
import com.logistics.hennex.modal.Order;
import com.logistics.hennex.modal.Orders;
import com.logistics.hennex.repository.OrderRepository;
import com.logistics.hennex.service.OrderService;
import com.logistics.hennex.service.OrdersService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;

	// Get All Orders
	@GetMapping("/orders")
	public List<Orders> getAllOrders() {
		return ordersService.getAllOrders();
	}

	// Create a new Order
	@PostMapping("/orders")
	public Orders createOrder(@Valid @RequestBody Orders order) {
		return ordersService.createOrder(order);
	}

	// Get a Single Order
	@GetMapping("/orders/{id}")
	public Orders getOrderById(@PathVariable(value = "id") String OrderId) {
	//	return OrderRepository.findById(OrderId).orElseThrow(() -> new ResourceNotFoundException("Order", "id", OrderId));
		return ordersService.getOrderById(OrderId);
	}

	// Update a Order
	@PutMapping("/orders/{id}")
	public Orders updateOrder(@PathVariable(value = "id") String OrderId, @Valid @RequestBody Orders orderDetails) {

		return ordersService.updateOrder(OrderId,orderDetails);
	}

	// Delete a Order
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") String OrderId) {
		if(ordersService.deleteOrder(OrderId)){
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}

}
