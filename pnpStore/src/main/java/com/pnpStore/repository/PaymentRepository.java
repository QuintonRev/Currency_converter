 package com.pnpStore.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pnpStore.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository <Payment, Integer> {

	@Query("SELECT l FROM Payment l WHERE l.payment_id = :payment_id")
	public ArrayList<Payment> viewByPaymentId(@Param("payment_id") int payment_id);
	
}

         