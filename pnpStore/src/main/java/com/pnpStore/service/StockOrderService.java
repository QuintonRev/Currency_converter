package com.pnpStore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnpStore.model.StockOrder;
import com.pnpStore.repository.StockOrderRepository;

@Service
public class StockOrderService {

	@Autowired
	public StockOrderRepository stockOrderRepository;
	
	public List<StockOrder> getAllstockOrders()
	{
		
		List<StockOrder> stockOrders = new ArrayList<>();
		stockOrderRepository.findAll()
		.forEach(stockOrders::add);
		return stockOrders;
		
	}

	public void DeleteStockOrder(int StockOrderID) {
		
		
		stockOrderRepository.delete(StockOrderID);
		
	}

	public void SaveStockOrder(StockOrder StockOrders) {
		
		
		stockOrderRepository.save(StockOrders);
		
	}

	public void updateStockOrder(int id, StockOrder StockOrders) {
		
		
		stockOrderRepository.save(StockOrders);
		
	}
}
