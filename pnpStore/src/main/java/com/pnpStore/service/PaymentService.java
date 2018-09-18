package com.pnpStore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnpStore.model.Payment;
import com.pnpStore.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	public PaymentRepository paymentRepository;
	
	public List<Payment> getAllpayments()
	{
		
		List<Payment> payments = new ArrayList<>();
		paymentRepository.findAll()
		.forEach(payments::add);
		return payments;
		
	}

	public void DeletePayment(int PaymentID) {
		
		
		paymentRepository.delete(PaymentID);
		
	}

	public void SavePayment(Payment Payments) {
		
		
		paymentRepository.save(Payments);
		
	}

	public void updatePayment(int id, Payment Payments) {
		
		
		paymentRepository.save(Payments);
		
	}
}
