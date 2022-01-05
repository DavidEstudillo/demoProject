package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Prices;
import com.example.demo.repositories.PricesRepository;
import com.example.demo.services.PricesService;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PricesService pricesService;
	
	@Autowired
	PricesRepository pricesRepository;
	
	DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");	
	
	Prices price1 = new Prices(1, LocalDateTime.parse("2020-06-14-00.00.00", formatter), LocalDateTime.parse("2020-12-31-23.59.59", formatter), 1, 35455, 0, 35.50, "EUR");
	Prices price2 = new Prices(1, LocalDateTime.parse("2020-06-14-15.00.00", formatter), LocalDateTime.parse("2020-06-14-18.30.00", formatter), 2, 35455, 1, 25.45, "EUR");
	Prices price3 = new Prices(1, LocalDateTime.parse("2020-06-15-00.00.00", formatter), LocalDateTime.parse("2020-06-15-11.00.00", formatter), 3, 35455, 1, 30.50, "EUR");
	Prices price4 = new Prices(1, LocalDateTime.parse("2020-06-15-16.00.00", formatter), LocalDateTime.parse("2020-12-31-23.59.59", formatter), 4, 35455, 1, 38.95, "EUR");
	
	
	//Todos los tests son para el producto 35455 y la marca 1 (ZARA)	 
	@Order(1)
	@Test
	public void contextLoads() {	
		pricesRepository.save(price1);
		pricesRepository.save(price2);
		pricesRepository.save(price3);
		pricesRepository.save(price4);		
	}
	
	@Order(2)
	@Test
	public void getPriceOn14ThAt10() {	
		//Se debe obtener el precio 1 al no haber un precio con mayor prioridad en este dia y a esta hora
		assertEquals(price1.getPrice(), pricesService.getPriceByDateProductAndBrand(LocalDateTime.parse("2020-06-14-10.00.00", formatter), 35455, 1).get().getPrice());		
	}
	
	@Order(3)
	@Test
	public void getPriceOn14ThAt16() {				
		//En este dia y a esta hora se aplica un precio prioritario, el precio 2, por tanto se debe obtener el precio 2
		assertEquals(price2.getPrice(), pricesService.getPriceByDateProductAndBrand(LocalDateTime.parse("2020-06-14-16.00.00", formatter), 35455, 1).get().getPrice());		
	}
	
	@Order(4)
	@Test
	public void getPriceOn14ThAt21() {				
		//El periodo del precio 2 ha finalizado, por tanto se debe obtener el precio 1 al no haber un precio con mayor prioridad
		assertEquals(price1.getPrice(), pricesService.getPriceByDateProductAndBrand(LocalDateTime.parse("2020-06-14-21.00.00", formatter), 35455, 1).get().getPrice());		
	}
	
	@Order(5)
	@Test
	public void getPriceOn15ThAt10() {				
		//En este dia y a esta hora se aplica un precio prioritario, el precio 3, por tanto se debe obtener el precio 3
		assertEquals(price3.getPrice(), pricesService.getPriceByDateProductAndBrand(LocalDateTime.parse("2020-06-15-10.00.00", formatter), 35455, 1).get().getPrice());		
	}
	
	@Order(6)
	@Test
	public void getPriceOn16ThAt21() {				
		//En este dia y a esta hora se aplica un precio prioritario, el precio 4, por tanto se debe obtener el precio 4
		assertEquals(price4.getPrice(), pricesService.getPriceByDateProductAndBrand(LocalDateTime.parse("2020-06-16-21.00.00", formatter), 35455, 1).get().getPrice());		
	}

}
