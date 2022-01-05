package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.models.Prices;
import com.example.demo.repositories.PricesRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(DemoApplication.class, args);
		PricesRepository pricesRepository = configurableApplicationContext.getBean(PricesRepository.class);
		
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");			
		
		Prices price1 = new Prices(1, LocalDateTime.parse("2020-06-14-00.00.00", formatter), LocalDateTime.parse("2020-12-31-23.59.59", formatter), 1, 35455, 0, 35.50, "EUR");
		Prices price2 = new Prices(1, LocalDateTime.parse("2020-06-14-15.00.00", formatter), LocalDateTime.parse("2020-06-14-18.30.00", formatter), 2, 35455, 1, 25.45, "EUR");
		Prices price3 = new Prices(1, LocalDateTime.parse("2020-06-15-00.00.00", formatter), LocalDateTime.parse("2020-06-15-11.00.00", formatter), 3, 35455, 1, 30.50, "EUR");
		Prices price4 = new Prices(1, LocalDateTime.parse("2020-06-15-16.00.00", formatter), LocalDateTime.parse("2020-12-31-23.59.59", formatter), 4, 35455, 1, 38.95, "EUR");
		
		pricesRepository.save(price1);
		pricesRepository.save(price2);
		pricesRepository.save(price3);
		pricesRepository.save(price4);		
		
	}

}
