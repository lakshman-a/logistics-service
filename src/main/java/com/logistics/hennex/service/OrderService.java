package com.logistics.hennex.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.logistics.hennex.enums.OrderIDFormat;
import com.logistics.hennex.exception.ResourceNotFoundException;
import com.logistics.hennex.modal.Order;
import com.logistics.hennex.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository OrderRepository;

	public List<Order> getAllOrders() {
		return OrderRepository.findAll();
	}

	public Order createOrder(Order order) {
//		String orderIDPrefix = "";
//		if(order.getCreatedBy().startsWith("ADMIN")) {
//			orderIDPrefix = OrderIDFormat.ADMIN.getValue();
//		}else {
//			orderIDPrefix = OrderIDFormat.CUSTOMER.getValue();
//		}
		order.setOrderID(Long.toString(System.nanoTime()).substring(9));
		order.setAddlCharges((order.getAddlCharges()==null)?Double.valueOf(0):order.getAddlCharges());
		order.setFinalAmt(order.getTotalOrderAmt()+order.getAddlCharges());
		order.setPaidDuringOrder((order.getPaidDuringOrder()==null)?Double.valueOf(0):order.getPaidDuringOrder());
		order.setBalancePayment(order.getFinalAmt()-order.getPaidDuringOrder());
		order.setOrderStatus("Initiated");
		order.setPaymentStatus((order.getBalancePayment()==0)?"FullyPaid":"PaymentPending");
		order.setUpdatedBy(order.getCreatedBy());
		return OrderRepository.save(order);
	}

	public Order getOrderById(String orderID) {
		return OrderRepository.findById(orderID)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderID));
	}

	public Order updateOrder(String orderID, Order order) {
//		return OrderRepository.save(Order);
		Order existingOrder = OrderRepository.findById(orderID)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderID));
		order.setOrderID(orderID);
		order.setAddlCharges((order.getAddlCharges()==null)?Double.valueOf(0):order.getAddlCharges());
		order.setFinalAmt(order.getTotalOrderAmt()+order.getAddlCharges());
		order.setPaidDuringOrder((order.getPaidDuringOrder()==null)?0.00:order.getPaidDuringOrder());
		order.setBalancePayment(order.getFinalAmt()-order.getPaidDuringOrder());
		order.setPaymentStatus((order.getBalancePayment()==0)?"FullyPaid":"PaymentPending");
		Order updatedOrder = OrderRepository.save(order);
		return updatedOrder;
	}

	public boolean deleteOrder(String orderID) {
//		Order Order = OrderRepository.findById(OrderID)
//				.orElseThrow(() -> new ResourceNotFoundException("Order", "id", OrderID));

//		OrderRepository.delete(Order);
		if (OrderRepository.findById(orderID).isPresent()) {
			OrderRepository.deleteById(orderID);
			return true;
		} else {
			return false;
		}
	}
}
