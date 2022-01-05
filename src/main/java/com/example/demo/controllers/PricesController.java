package com.example.demo.controllers;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Prices;
import com.example.demo.services.PricesService;

@RestController
@RequestMapping("/prices")
public class PricesController {
	
	//Se considera este patrón de fecha el que se va a enviar como parámetro al ser el mismo del txt proporcionado
	DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
	
	@Autowired
	PricesService pricesService;

	@GetMapping("/priceByDateProductAndBrand")
	public ResponseEntity<Object> getPrice(@RequestParam("applicationDate") String applicationDate, @RequestParam("productId") int productId, @RequestParam("brandId") int brandId) throws ParseException{
				
		Optional<Prices> result = pricesService.getPriceByDateProductAndBrand(LocalDateTime.parse(applicationDate, formatter), productId, brandId);
		
		if (result.orElse(null) == null) {		
			return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
		} else {	
			return new ResponseEntity<>(result.get(), HttpStatus.OK);			
		}
		
	}

}
