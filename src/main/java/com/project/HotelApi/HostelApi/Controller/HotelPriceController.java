package com.project.HotelApi.HostelApi.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.HotelApi.HostelApi.Entity.BedTableEntity;
import com.project.HotelApi.HostelApi.Entity.PriceTableEntity;
import com.project.HotelApi.HostelApi.Exception.BedNotFoundException;
import com.project.HotelApi.HostelApi.Exception.PriceAlreadyExistException;
import com.project.HotelApi.HostelApi.Exception.PriceNotFoundException;
import com.project.HotelApi.HostelApi.Service.BedTableService;
import com.project.HotelApi.HostelApi.Service.HotelPriceService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/prices")
public class HotelPriceController {
	
	@Autowired
	HotelPriceService hotelPriceService;
	
	@Autowired
	BedTableService bedTableService;
	
	@GetMapping
	public ResponseEntity<List<PriceTableEntity>> getAllPrices(){
		return new ResponseEntity<>(hotelPriceService.getAllPrices(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PriceTableEntity> getPricesById(@PathVariable int id) throws PriceNotFoundException{
		PriceTableEntity dbPrice = hotelPriceService.getPriceById(id);
		if(dbPrice == null)
			throw new PriceNotFoundException("Price not found with id:- "+id);
		return new ResponseEntity<PriceTableEntity>(dbPrice,HttpStatus.OK);
				
	}
	
	@PostMapping
	public ResponseEntity<PriceTableEntity> addPrice(@Valid@RequestBody PriceTableEntity price) throws Exception{
		if(hotelPriceService.existsByPrice(price.getPrice())==true) {
			throw new PriceAlreadyExistException("entered price = "+price.getPrice()+" already exist");
		}
		PriceTableEntity dbPrice = hotelPriceService.addPrice(price);
		return new ResponseEntity<PriceTableEntity>(dbPrice,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PriceTableEntity> editPrice(@PathVariable int id, @Valid@RequestBody PriceTableEntity updatedPrice) throws Exception{
		if(hotelPriceService.existsByPrice(updatedPrice.getPrice())==true) {
			throw new PriceAlreadyExistException("entered price = "+updatedPrice.getPrice()+" already exist");
		}
		
		PriceTableEntity dbPrice = hotelPriceService.getPriceById(id);
		if(dbPrice == null)
			throw new PriceNotFoundException("Price not found with id:- "+id);
		PriceTableEntity updatedDBPrice = hotelPriceService.editPrice(dbPrice, updatedPrice);
		return new ResponseEntity<PriceTableEntity>(updatedDBPrice,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletPriceById(@PathVariable int id) throws PriceNotFoundException{
		PriceTableEntity dbPrice = hotelPriceService.getPriceById(id);
		if(dbPrice == null)
			throw new PriceNotFoundException("Price not found with id:- "+id);
		hotelPriceService.deletPriceById(id);
		return new ResponseEntity<String>("Price Entity deleted with id:- "+id,HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/beds/{price}")
	public ResponseEntity<List<BedTableEntity>> getBedRoomsByPrice(@PathVariable int price) throws Exception{
		List<BedTableEntity> dbBedTableEntities =  bedTableService.getBedsByPrice(price);
		
		if(dbBedTableEntities.size()>0) {
			return new ResponseEntity<List<BedTableEntity>>(dbBedTableEntities,HttpStatus.OK);
		}
		else {
			throw new BedNotFoundException("no bed rooms found with given price: "+price);
		}
	}
	
}
