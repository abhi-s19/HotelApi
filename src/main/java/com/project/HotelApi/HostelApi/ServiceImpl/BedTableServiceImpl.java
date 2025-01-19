package com.project.HotelApi.HostelApi.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.HotelApi.HostelApi.Dao.BedCountDao;
import com.project.HotelApi.HostelApi.Dao.HotelPriceDao;
import com.project.HotelApi.HostelApi.Entity.BedTableEntity;
import com.project.HotelApi.HostelApi.Entity.PriceTableEntity;
import com.project.HotelApi.HostelApi.Exception.PriceNotFoundException;
import com.project.HotelApi.HostelApi.Service.BedTableService;

@Service
public class BedTableServiceImpl implements BedTableService {

	@Autowired
	HotelPriceDao hotelPriceDao;
	
	@Autowired
	BedCountDao bedCountDao;
	
	@Override
	public List<BedTableEntity> getBedsByPrice(int price) throws PriceNotFoundException {
		PriceTableEntity dbPriceTableEntity = hotelPriceDao.findByPrice(price);
		if(dbPriceTableEntity==null)
		{
			throw new PriceNotFoundException("mentioned price is not present in DB, price: "+price);
		}
		List<BedTableEntity> dbBedTableEntities = bedCountDao.findByPriceTableEntity(dbPriceTableEntity);
		
		return dbBedTableEntities;
	}

}
