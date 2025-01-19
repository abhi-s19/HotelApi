package com.project.HotelApi.HostelApi.Service;

import java.util.List;

import com.project.HotelApi.HostelApi.Entity.BedTableEntity;
import com.project.HotelApi.HostelApi.Exception.PriceNotFoundException;

public interface BedTableService {
	
	List<BedTableEntity> getBedsByPrice(int price)  throws PriceNotFoundException;

}
