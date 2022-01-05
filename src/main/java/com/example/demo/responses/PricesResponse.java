package com.example.demo.responses;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PricesResponse {

	//Fields	
	private int productId;
	private int brandId;
	private int priceList;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endDate;		
	
	private String finalPrice;
	
	//Constructors
	public PricesResponse() {
		
	}
	
	public PricesResponse(int productId, int priceList, int brandId, LocalDateTime startDate, LocalDateTime endDate, Double price, String curr) {
		this.productId = productId;
		this.brandId = brandId;
		this.priceList = priceList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.finalPrice = price.toString() + " " + curr;
	}
	
	//Field 'productId' getter and setter
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	//Field 'brandId' getter and setter
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	
	//Field 'priceList' getter and setter
	public int getPriceList() {
		return priceList;
	}
	public void setPriceList(int priceList) {
		this.priceList = priceList;
	}
	
	//Field 'startDate' getter and setter
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	//Field 'endDate' getter and setter
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}	

	//Field 'finalPrice' getter and setter
	public String getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Double price, String curr) {
		this.finalPrice = price.toString() + " " + curr;
	}
	
}
