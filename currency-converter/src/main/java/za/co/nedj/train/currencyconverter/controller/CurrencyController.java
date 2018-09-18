package za.co.nedj.train.currencyconverter.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.nedj.train.currencyconverter.model.Currency;
import za.co.nedj.train.currencyconverter.model.Quotes;
import za.co.nedj.train.currencyconverter.repository.QuotesRepo;
import za.co.nedj.train.currencyconverter.service.CurrencyService;

@RestController
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;

	@Autowired
	QuotesRepo quotesrepo;

	@GetMapping("/getCurrencies")
	public List<Currency> getCurrencies() throws IOException {
		return currencyService.findAllCurrencies();
	}

	@PostMapping("/convertCurrency/{sourceCurrencyCode}/{sourceAmount}/{targetCurrencyCode}")
	public String convertCurrency(@PathVariable(value = "sourceCurrencyCode") String sourceCurrencyCode,
                                  @PathVariable(value = "sourceAmount") double sourceAmount,
                                  @PathVariable(value = "targetCurrencyCode") String targetCurrencyCode) throws IOException {

		return currencyService.convertCurrency(sourceCurrencyCode, sourceAmount,targetCurrencyCode);
	}

	@GetMapping("/quotes")
	public List<Quotes> quotes() {
		return quotesrepo.findAll();
	}

}
