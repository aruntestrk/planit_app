package com.planit.selenium.pojos;

public class Product {
	
	private String name;
    private Integer quantity;
	private Double price;
	private String priceString;
	private Double subTotal;
	
	public Double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}

	
	
	
	

	public String getPriceString() {
		return priceString;
	}

	public void setPriceString(String priceString) {
		this.priceString = priceString;
	}

	public String getName() {
		return name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
