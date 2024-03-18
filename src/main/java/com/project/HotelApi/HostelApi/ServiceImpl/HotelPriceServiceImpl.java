package com.project.HotelApi.HostelApi.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.HotelApi.HostelApi.Dao.HotelPriceDao;
import com.project.HotelApi.HostelApi.Entity.PriceTableEntity;
import com.project.HotelApi.HostelApi.Service.HotelPriceService;

@Service
public class HotelPriceServiceImpl implements HotelPriceService {

	@Autowired
	HotelPriceDao hotelPriceDao;
	
	@Override
	public List<PriceTableEntity> getAllPrices() {
		
		return hotelPriceDao.findAll();
	}

	@Override
	public PriceTableEntity getPriceById(int id) {
		Optional<PriceTableEntity> dbPrice = hotelPriceDao.findById(id);
		if(dbPrice.isPresent())
			return dbPrice.get();
		return null;
	}

	@Override
	public PriceTableEntity addPrice(PriceTableEntity price) {
		return hotelPriceDao.save(price);
	}

	@Override
	public PriceTableEntity editPrice(PriceTableEntity dbPrice,PriceTableEntity updatedprice) {
		dbPrice.setPrice(updatedprice.getPrice());
		return hotelPriceDao.save(dbPrice);
	}

	@Override
	public void deletPriceById(int id) {
		// TODO Auto-generated method stub
		hotelPriceDao.deleteById(id);
	}

	@Override
	public Boolean existsByPrice(int price) {
		return hotelPriceDao.existsByPrice(price);
		
	}

}
