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
import com.logistics.hennex.modal.Orders;
import com.logistics.hennex.repository.OrdersRepository;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;

	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}

	public Orders createOrder(Orders orders) {
//		String ordersIDPrefix = "";
//		if(orders.getCreatedBy().startsWith("ADMIN")) {
//			ordersIDPrefix = OrderIDFormat.ADMIN.getValue();
//		}else {
//			ordersIDPrefix = OrderIDFormat.CUSTOMER.getValue();
//		}
		orders.setOrderID(Long.toString(System.nanoTime()).substring(9));
		orders.setAddlCharges((orders.getAddlCharges()==null)?Double.valueOf(0):orders.getAddlCharges());
		orders.setFinalAmt(orders.getTotalOrderAmt()+orders.getAddlCharges());
		orders.setPaidDuringOrder((orders.getPaidDuringOrder()==null)?Double.valueOf(0):orders.getPaidDuringOrder());
		orders.setBalancePayment(orders.getFinalAmt()-orders.getPaidDuringOrder());
		orders.setOrderStatus("Initiated");
		orders.setPaymentStatus((orders.getBalancePayment()==0)?"FullyPaid":"PaymentPending");
		orders.setUpdatedBy(orders.getCreatedBy());
		return ordersRepository.save(orders);
	}

	public Orders getOrderById(String orderID) {
		return ordersRepository.findById(orderID)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderID));
	}

	public Orders updateOrder(String orderID, Orders orders) {
//		return ordersRepository.save(Order);
		Orders existingOrder = ordersRepository.findById(orderID)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderID));
		orders.setOrderID(orderID);
		orders.setAddlCharges((orders.getAddlCharges()==null)?Double.valueOf(0):orders.getAddlCharges());
		orders.setFinalAmt(orders.getTotalOrderAmt()+orders.getAddlCharges());
		orders.setPaidDuringOrder((orders.getPaidDuringOrder()==null)?0.00:orders.getPaidDuringOrder());
		orders.setBalancePayment(orders.getFinalAmt()-orders.getPaidDuringOrder());
		orders.setPaymentStatus((orders.getBalancePayment()==0)?"FullyPaid":"PaymentPending");
		Orders updatedOrder = ordersRepository.save(orders);
		return updatedOrder;
	}

	public boolean deleteOrder(String orderID) {
//		Order Order = ordersRepository.findById(OrderID)
//				.orElseThrow(() -> new ResourceNotFoundException("Order", "id", OrderID));

//		ordersRepository.delete(Order);
		if (ordersRepository.findById(orderID).isPresent()) {
			ordersRepository.deleteById(orderID);
			return true;
		} else {
			return false;
		}
	}
}
