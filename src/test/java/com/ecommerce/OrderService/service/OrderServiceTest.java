//package com.ecommerce.OrderService.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.client.RestTemplate;
//
//import com.ecommerce.OrderService.entity.Address;
//import com.ecommerce.OrderService.entity.Card;
//import com.ecommerce.OrderService.entity.Cart;
//import com.ecommerce.OrderService.entity.CartItem;
//import com.ecommerce.OrderService.entity.Category;
//import com.ecommerce.OrderService.entity.Order;
//import com.ecommerce.OrderService.entity.OrderDto;
//import com.ecommerce.OrderService.entity.Payment;
//import com.ecommerce.OrderService.entity.Product;
//import com.ecommerce.OrderService.entity.User;
//import com.ecommerce.OrderService.repository.OrderRepository;
//
//@SpringBootTest(classes= {OrderServiceTest.class})
//public class OrderServiceTest {
//
//	
////	@Mock
////    private RestTemplate restTemplate;
//	@Mock
//	OrderRepository orderRepo;
//	
//	@InjectMocks
//	OrderService orderService;
//	
////	
////	@Test
////	public void test_createOrder() {
////		
////		Card card = new Card(1,2,"abc");
////		Address address= new Address("abc","ABC","bina",1,"abc","abc","ABC");
////		Category category = new Category(1,"abc");
////		Product product = new Product(1,"abc","abc",2,200,22,23,"abc",category);
////		List<CartItem> cartItem = new ArrayList<CartItem>();
////		 cartItem.add( new CartItem(1,3,2000,product,3000));
////		Cart cart = new Cart(1,cartItem,300.0);
////		User user = new User(1,"abc","abc","abc",address,23947396L);
////		
////		
////		OrderDto orderDto = new OrderDto();
////		orderDto.setOrderId("order123");
////		orderDto.setCartId(123);
////		orderDto.setUserId(123);
////		orderDto.setPaymentMethods(Payment.CARDPAYMENT);
////		orderDto.setCardDetails(card);
////		orderDto.setShippingAddress(address);
////		
////		
////		Order order1= new Order();
////		order1.setOrderId("order1");
////		order1.setCartDetails(cart);
////		order1.setUserDetails(user);
////		order1.setCardDetails(orderDto.getCardDetails());
////		order1.setPaymentMethods(orderDto.getPaymentMethods());
////		order1.setShippingAddress(orderDto.getShippingAddress());
////	
////	when(orderRepo.insert(order1)).thenReturn(order1);
////	
////	
////	
////	assertEquals(order1,orderService.createOrder(orderDto));}
//	
//	
//	@Test
//	public void  getOrderByUserIdTest() {
//		
//
//		Card card = new Card(1,2,"abc");
//		Address address= new Address("abc","ABC","bina",1,"abc","abc","ABC");
//		Category category = new Category(1,"abc");
//		Product product = new Product(1,"abc","abc",2,200,22,23,"abc",category);
//		List<CartItem> cartItem = new ArrayList<CartItem>();
//		 cartItem.add( new CartItem(1,3,2000,product,3000));
//		Cart cart = new Cart(1,cartItem,300.0);
//		User user = new User(1,"abc","abc","abc",address,23947396L);
//		
//		
//		OrderDto orderDto = new OrderDto();
//		orderDto.setOrderId("order123");
//		orderDto.setCartId(123);
//		orderDto.setUserId(123);
//		orderDto.setPaymentMethods(Payment.CARDPAYMENT);
//		orderDto.setCardDetails(card);
//		orderDto.setShippingAddress(address);
//		
//		List<Order> order12= new ArrayList<Order>();
//		
//		Order order1= new Order();
//		order1.setOrderId("order1");
//		order1.setCartDetails(cart);
//		order1.setUserDetails(user);
//		order1.setCardDetails(orderDto.getCardDetails());
//		order1.setPaymentMethods(orderDto.getPaymentMethods());
//		order1.setShippingAddress(orderDto.getShippingAddress());
//	     order12.add(order1);
//	
//	when(orderRepo.findByUserDetailsUserId(order1.getUserDetails().getUserId())).thenReturn(order12);
//	
//	
//	
//	assertEquals(order12,orderService.getOrderByUserId(1));}
//	
//	
//	}
//
//
