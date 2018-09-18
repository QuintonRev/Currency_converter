package com.pnpStore.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.pnpStore.service.StockOrderService;
import com.pnpStore.model.StockOrder;

@RestController
public class StockOrderController {

	@Autowired
	private StockOrderService stockOrderService;

	@RequestMapping("/GetStockOrders") 
	public List<StockOrder> getAllstockOrders() 
	{
		return stockOrderService.getAllstockOrders();
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/DeleteStockOrder/{stockOrderID}")
	//@PathVariable - identifies the path pattern used in URL for incoming data
	public void DeleteStockOrder(@PathVariable int stockOrderID)
	{
		stockOrderService.DeleteStockOrder(stockOrderID);

	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/SaveStockOrder")
	//@RequestBody converts JSON format to java object
	public void SaveProduct(@RequestBody StockOrder StockOrders)
	{
		stockOrderService.SaveStockOrder(StockOrders);		

	}

	@RequestMapping(method = RequestMethod.PUT,value = "/UpdateStockOrder/{id}")
	public void updateProduct(@RequestBody StockOrder StockOrders, @PathVariable int id)
	{
		
		stockOrderService.updateStockOrder(id, StockOrders);
		
	}

}
