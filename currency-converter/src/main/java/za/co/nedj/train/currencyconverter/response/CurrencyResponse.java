package za.co.nedj.train.currencyconverter.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.nedj.train.currencyconverter.model.Currency;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CurrencyResponse {
	private List<Currency> currencies;
}
