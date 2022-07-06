package com.ecommerce.OrderService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.OrderService.controller.OrderControllerTest;
import com.ecommerce.OrderService.entity.Address;
import com.ecommerce.OrderService.entity.Card;
import com.ecommerce.OrderService.entity.Cart;
import com.ecommerce.OrderService.entity.CartItem;
import com.ecommerce.OrderService.entity.Category;
import com.ecommerce.OrderService.entity.Order;
import com.ecommerce.OrderService.entity.OrderDto;
import com.ecommerce.OrderService.entity.Payment;
import com.ecommerce.OrderService.entity.Product;
import com.ecommerce.OrderService.entity.User;
import com.ecommerce.OrderService.repository.OrderRepository;
import com.ecommerce.OrderService.service.OrderService;

@SpringBootTest(classes = { OrderServiceApplicationTests.class })
class OrderServiceApplicationTests {

	@Mock
	OrderRepository orderRepo;

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	OrderService orderService;

	@Test
	
	public void test_createOrder() {

		Category category1 = new Category(7, "gfs");

		Category category2 = new Category();
		category2.setCategoryId(category2.getCategoryId());
		category2.setCategoryName(category2.getCategoryName());

		Product product1 = new Product();
		product1.setCategory(category1);
		product1.setDescription("scac");
		product1.setDiscountedPrice(700);
		product1.setProductId(10);
		product1.setProductName("dxdw");
		product1.setProductRating(4);
		product1.setProductReview("qdd");
		product1.setQuantity(40);
		product1.setRegularPrice(500);

		Product product2 = new Product(8, "hp", "hhjjhj", 20, 900, 800, 2, "hghjhj", category2);

		CartItem item1 = new CartItem();
		item1.setCartItemId(12);
		item1.setQuantity(5);
		item1.setPrice(700);
		item1.setProduct(product1);

		CartItem item2 = new CartItem();
		item2.setCartItemId(7);
		item2.setQuantity(6);
		item2.setPrice(600);
		item2.setProduct(product2);

		List<CartItem> items = new ArrayList<CartItem>();

		items.add(item1);
		items.add(item2);

		Cart cart = new Cart();

		cart.setCartId(100);
		cart.setCartItems(items);
		cart.setGrandTotal(300d);

		Address add = new Address();

		add.setLine1("fcd");
		add.setLine2("ef");
		add.setCity("sfvfs");
		add.setDistrict("dvvdv");
		add.setState("cdda");
		add.setCountry("scss");
		add.setZipcode(1234);

		User user2 = new User();
		user2.setAddress(add);
		user2.setEmail("dvfsv");
		user2.setPassword("dff");
		user2.setPhone(10L);
		user2.setUserId(105);
		user2.setUserName("ffe");

		Card card = new Card();
		card.setCardCVV(1234);
		card.setCardNumber(222);
		card.setCardOwner("ffrwr");

		Card card2 = new Card(12, 34, "fdfhg");

		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId("order123");
		orderDto.setCartId(100);
		orderDto.setUserId(105);
		orderDto.setPaymentMethods(Payment.CARDPAYMENT);
		orderDto.setCardDetails(card);
		orderDto.setShippingAddress(add);

		when(restTemplate.getForObject("http://CART-SERVICE/cart/Cart/" + orderDto.getCartId(), Cart.class))
				.thenReturn(cart);

		when(restTemplate.getForObject("http://USER-SERVICE/users/" + orderDto.getUserId(), User.class))
				.thenReturn(user2);

		Order order = new Order();
		order.setOrderId(orderDto.getOrderId());
		order.setCartDetails(cart);
		order.setUserDetails(user2);
		order.setCardDetails(card);
		order.setPaymentMethods(orderDto.getPaymentMethods());
		order.setShippingAddress(orderDto.getShippingAddress());

		when(orderRepo.insert(order)).thenReturn(order);

	}

	@Test
	public void getOrderByUserIdTest() {

		Card card = new Card(1, 2, "abc");
		Address address = new Address("abc", "ABC", "bina", 1, "abc", "abc", "ABC");
		Category category = new Category(1, "abc");
		Product product = new Product(1, "abc", "abc", 2, 200, 22, 23, "abc", category);
		List<CartItem> cartItem = new ArrayList<CartItem>();
		cartItem.add(new CartItem(1, 3, 2000, product, 3000));
		Cart cart = new Cart(1, cartItem, 300.0);
		User user = new User(1, "abc", "abc", "abc", address, 23947396L);

		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId("order123");
		orderDto.setCartId(123);
		orderDto.setUserId(123);
		orderDto.setPaymentMethods(Payment.CARDPAYMENT);
		orderDto.setCardDetails(card);
		orderDto.setShippingAddress(address);

		List<Order> order12 = new ArrayList<Order>();

		Order order1 = new Order();
		order1.setOrderId("order1");
		order1.setCartDetails(cart);
		order1.setUserDetails(user);
		order1.setCardDetails(orderDto.getCardDetails());
		order1.setPaymentMethods(orderDto.getPaymentMethods());
		order1.setShippingAddress(orderDto.getShippingAddress());
		order12.add(order1);

		when(orderRepo.findByUserDetailsUserId(order1.getUserDetails().getUserId())).thenReturn(order12);

		assertEquals(order12, orderService.getOrderByUserId(1));
	}

	@Test

	public void getSingleOrder() {

		Card card = new Card();
		card.setCardCVV(1);
		card.setCardNumber(1232);
		card.setCardOwner("abc");
		Address address = new Address();
		address.setCity("abc");
		address.setCountry("abc");
		address.setDistrict("sagar");
		address.setLine1("bina");
		address.setLine2("bina1");
		address.setState("MP");
		address.setZipcode(2334);
		Category category = new Category();
		category.setCategoryId(category.getCategoryId());
		category.setCategoryName(category.getCategoryName());

		Product product = new Product();
		product.setProductId(product.getProductId());
		product.setProductName(product.getProductName());
		product.setCategory(category);
		product.setDescription(product.getDescription());
		product.setDiscountedPrice(product.getDiscountedPrice());
		product.setProductRating(product.getProductRating());
		product.setProductReview(product.getProductReview());
		product.setQuantity(product.getQuantity());
		product.setRegularPrice(product.getRegularPrice());

//		List<CartItem> cartItem = new ArrayList<CartItem>();
//		CartItem cartitems = new CartItem();
//		cartitems.setCartItemId(3);
//		cartitems.setPrice(2347);
//		cartitems.setQuantity(4);
//		cartitems.setProduct(product);
//		cartitems.setSubTotal(38974);
//		 cartItem.add( cartitems);
//		 
		List<CartItem> cartItem = new ArrayList<CartItem>();
		cartItem.add(new CartItem(1, 3, 2000, product, 3000));

		Cart cart = new Cart();
		cart.setCartId(cart.getCartId());
		cart.setCartItems(cartItem);
		cart.setGrandTotal(cart.getGrandTotal());

		User user = new User();
		user.setAddress(address);
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		user.setPhone(user.getPhone());
		user.setUserId(user.getUserId());
		user.setUserName(user.getUserName());

		Order order = new Order("23874", cart, user, address, Payment.CARDPAYMENT, card);
		when(orderRepo.findById(order.getOrderId())).thenReturn(Optional.ofNullable(order));

		assertEquals(order, orderService.getSingleOrder("23874"));
	}

}
