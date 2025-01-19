package com.project.HotelApi.HostelApi.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.HotelApi.HostelApi.Entity.BedTableEntity;
import com.project.HotelApi.HostelApi.Entity.PriceTableEntity;

public interface BedCountDao extends JpaRepository<BedTableEntity, Integer> {

	List<BedTableEntity> findByPriceTableEntity(PriceTableEntity dbPriceTableEntity);

}
