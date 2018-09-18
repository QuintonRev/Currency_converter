package com.pnpStore.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.pnpStore.service.PaymentService;
import com.pnpStore.model.Payment;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@RequestMapping("/GetPayments") 
	public List<Payment> getAllpayments() 
	{
		return paymentService.getAllpayments();
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/DeletePayment/{paymentID}")
	//@PathVariable - identifies the path pattern used in URL for incoming data
	public void DeleteStockOrder(@PathVariable int paymentID)
	{
		paymentService.DeletePayment(paymentID);

	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/SavePayment")
	//@RequestBody converts JSON format to java object
	public void SaveProduct(@RequestBody Payment Payments)
	{
		paymentService.SavePayment(Payments);		

	}

	@RequestMapping(method = RequestMethod.PUT,value = "/UpdatePayment/{id}")
	public void updatePayment(@RequestBody Payment Payments, @PathVariable int id)
	{
		
		paymentService.updatePayment(id, Payments);
		
	}

}
