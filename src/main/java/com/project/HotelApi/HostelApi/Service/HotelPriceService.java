package com.project.HotelApi.HostelApi.Service;

import java.util.List;

import com.project.HotelApi.HostelApi.Entity.PriceTableEntity;

public interface HotelPriceService {
	
	List<PriceTableEntity> getAllPrices();
	PriceTableEntity getPriceById(int id);
	PriceTableEntity addPrice(PriceTableEntity price);
	PriceTableEntity editPrice(PriceTableEntity dbPrice,PriceTableEntity updatedprice);
	void deletPriceById(int id);
	Boolean existsByPrice(int price);
	
}
