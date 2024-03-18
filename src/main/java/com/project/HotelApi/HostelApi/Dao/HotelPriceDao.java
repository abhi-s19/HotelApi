package com.project.HotelApi.HostelApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.HotelApi.HostelApi.Entity.PriceTableEntity;

public interface HotelPriceDao extends JpaRepository<PriceTableEntity, Integer> {
	Boolean existsByPrice(int price);
}
