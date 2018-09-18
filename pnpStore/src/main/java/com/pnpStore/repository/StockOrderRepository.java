package com.pnpStore.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pnpStore.model.StockOrder;

@Repository
public interface StockOrderRepository extends CrudRepository <StockOrder, Integer> {

	@Query("SELECT l FROM StockOrder l WHERE l.stockOrder_id = :stockOrder_id")
	public ArrayList<StockOrder> viewByStockOrderId(@Param("stockOrder_id") int stockOrder_id);
	
}
