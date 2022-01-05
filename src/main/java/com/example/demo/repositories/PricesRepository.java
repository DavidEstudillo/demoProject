package com.example.demo.repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Prices;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long>{
	
	@Query("SELECT price FROM Prices price"
			+ " WHERE :applicationDate BETWEEN price.startDate AND price.endDate"
            + " AND price.productId = :productId"
            + " AND price.brandId = :brandId"
            + " ORDER BY price.priority DESC")
	ArrayList<Prices> findPriceByDateProductAndBrand(LocalDateTime applicationDate, int productId, int brandId);

}
