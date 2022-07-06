package com.ecommerce.OrderService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.OrderService.entity.Cart;
import com.ecommerce.OrderService.entity.Order;
import com.ecommerce.OrderService.entity.OrderDto;
import com.ecommerce.OrderService.entity.User;
import com.ecommerce.OrderService.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepo;

	@Autowired
	private RestTemplate restTemplate;

	public Order createOrder(OrderDto orderDto) {

		Cart cart = restTemplate.getForObject("http://CART-SERVICE/cart/" + orderDto.getCartId(), Cart.class);

		User user = restTemplate.getForObject("http://USER-SERVICE/users/" + orderDto.getUserId(), User.class);

		Order order = new Order();

		order.setOrderId(orderDto.getOrderId());

		order.setCartDetails(cart);

		order.setUserDetails(user);

		order.setShippingAddress(orderDto.getShippingAddress());

		order.setPaymentMethods(orderDto.getPaymentMethods());

		order.setCardDetails(orderDto.getCardDetails());

		return orderRepo.insert(order);

	}

	public List<Order> getOrderByUserId(Integer userId) {

		List<Order> orders = orderRepo.findByUserDetailsUserId(userId);
		return orders;
	}
	
	public Order getSingleOrder(String orderId) {
		Optional<Order> order = orderRepo.findById(orderId);
		if(order.isPresent()) {
			return order.get();
		}else {
			throw new RuntimeException("order not found");
		}
	}
	

	/*
	 * public Order getSingleOrder(String orderId) {
	 * 
	 * List<Order> orders = orderRepo.findAll();
	 * 
	 * Order ord = null;
	 * 
	 * for (Order order : orders) {
	 * 
	 * if (order.getOrderId() == orderId)
	 * 
	 * ord = order; } return ord; }
	 */
}
