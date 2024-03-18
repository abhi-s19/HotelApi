package com.project.HotelApi.HostelApi.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "price_table")
public class PriceTableEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "price")
	@NotNull(message = "Price should not be null")
	@Min(1000)
	@Max(10000)
	private int price;
	public PriceTableEntity(int id, int price) {
		super();
		this.id = id;
		this.price = price;
	}
	public PriceTableEntity() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "PriceTableEntity [id=" + id + ", price=" + price + "]";
	}
	
	
}
