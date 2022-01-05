package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Prices;
import com.example.demo.repositories.PricesRepository;

@Service	
public class PricesService {

	@Autowired
	PricesRepository pricesRepository;
	
	public Optional<Prices> getPriceByDateProductAndBrand(LocalDateTime applicationDate, int productId, int brandId){
		
		ArrayList<Prices> result = pricesRepository.findPriceByDateProductAndBrand(applicationDate, productId, brandId);
		return result.stream().findFirst();	
		
	}
}
