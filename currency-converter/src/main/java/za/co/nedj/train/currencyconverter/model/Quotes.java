package za.co.nedj.train.currencyconverter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "quotes")

public class Quotes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String SourceCurrencyCode;
	private String SourceCurrencyName;
	private String TargetCurrencyCode;
	private String TargetCurrencyName;
	private double SourceAmount;
	private double ConversionRate;
	private double TargetAmount;

	public Quotes(String sourceCurrencyCode, String sourceCurrencyName, String targetCurrencyCode, String targetCurrencyName, double sourceAmount, double conversionRate, double targetAmount) {
		SourceCurrencyCode = sourceCurrencyCode;
		SourceCurrencyName = sourceCurrencyName;
		TargetCurrencyCode = targetCurrencyCode;
		TargetCurrencyName = targetCurrencyName;
		SourceAmount = sourceAmount;
		ConversionRate = conversionRate;
		TargetAmount = targetAmount;
	}
}
