package com.ecommerce.OrderService.entity;

import org.springframework.data.annotation.Id;

public class CartItem {
	
	private Integer cartItemId;

	private Integer quantity;

	private Integer price;

	private Product product;

	private Integer subTotal;

	public CartItem(Integer cartItemId, Integer quantity, Product product, Integer subTotal) {

		super();

		this.cartItemId = cartItemId;

		this.quantity = quantity;

		this.product = product;

		this.subTotal = subTotal;

		getSubTotal();

	}
	

	public CartItem(Integer cartItemId, Integer quantity, Integer price, Product product, Integer subTotal) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		this.subTotal = subTotal;
	}


	public CartItem() {

		super();

		// TODO Auto-generated constructor stub

	}

	public Integer getCartItemId() {

		return cartItemId;

	}

	public void setCartItemId(Integer cartItemId) {

		this.cartItemId = cartItemId;

	}

	public Integer getQuantity() {

		return quantity;

	}

	public void setQuantity(Integer quantity) {

		this.quantity = quantity;

	}

	public Product getProduct() {

		return product;

	}

	public void setProduct(Product product) {

		this.product = product;

	}

	public Integer getSubTotal() {

		this.subTotal = getQuantity() * getPrice();

		return subTotal;

	}

	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}


	public Integer getPrice() {

		return price;

	}

	public void setPrice(Integer price) {

		this.price = price;

		getSubTotal();

	}

}
