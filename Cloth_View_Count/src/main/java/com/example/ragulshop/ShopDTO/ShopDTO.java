package com.example.ragulshop.ShopDTO;

import java.math.BigDecimal;

public class ShopDTO {
	
	private String name;
	private BigDecimal price;
	
	public ShopDTO(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
