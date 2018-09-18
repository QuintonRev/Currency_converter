package za.co.nedj.train.currencyconverter.service;


import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.nedj.train.currencyconverter.model.Currency;

import za.co.nedj.train.currencyconverter.model.Quotes;
import za.co.nedj.train.currencyconverter.repository.QuotesRepo;

@Service
public class CurrencyService {

	@Autowired
	QuotesRepo quotesRepo;

	public List<Currency> findAllCurrencies() throws IOException {

		List<Currency> currencyList = new ArrayList<>();

		String apiURL = "https://restcountries.eu/rest/v2/all?fields=currencies";

		URL obj = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// ====================================================================================================
		// Read JSON response and print
		JSONArray myResponse = new JSONArray(response.toString());

		String array = "";
		JSONArray jsonArray;
		Currency currency;
		List<Currency> currencies = new ArrayList<>();

		for(int i = 0; i < myResponse.length(); i++){
			array = myResponse.getJSONObject(i).get("currencies").toString();
			jsonArray = new JSONArray(array);

			String[] line = array.split("}");

			for(int row = 0; row < jsonArray.length(); row++){

				currency = new ObjectMapper().readValue(jsonArray.getJSONObject(row).toString(), Currency.class);

				currencies.add(i, currency);
			}
		}

		return currencies;
	}

	public String convertCurrency(String sourceCurrencyCode, double sourceAmount, String sourceTargetCode)
			throws IOException{

		String message = "Successfully converted currency";
		String sourceName =  findCurrencyName(sourceCurrencyCode);
		String targetName =  findCurrencyName(sourceTargetCode);


		System.out.println(sourceName + "============" + targetName);

		double targetAmount = getCurrencyRate(sourceCurrencyCode) * sourceAmount;

		Quotes quotes = new Quotes(sourceCurrencyCode, sourceName, sourceTargetCode, targetName,
				sourceAmount, getCurrencyRate(sourceCurrencyCode), targetAmount);

		this.quotesRepo.save(quotes);


		return message;
	}

	private static Double getCurrencyRate(String sourceCode) throws IOException {

		double targetAmount = 0.0;

		String apiURL = "http://apilayer.net/api/live?access_key=0e5fc512f4e8a02dc7a7a5b185a24e09&format=1";

		URL obj = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		//Read JSON response and print
		JSONObject myResponse = new JSONObject(response.toString());

		String quotesString = "" + myResponse.get("quotes");

		//System.out.println(quotesString);


		JSONObject myNewResponse = new JSONObject(quotesString);

		sourceCode = "USD" + sourceCode;

		targetAmount = Double.parseDouble(myNewResponse.get(sourceCode).toString());
		System.out.println("currency rate: "+ targetAmount);

		return targetAmount;

	}

	private String findCurrencyName(String code)  throws IOException {

		String name = "";

		List<Currency> currencyList = new ArrayList<>();
		currencyList = findAllCurrencies();

		for (int i = 0; i < currencyList.size(); i++){
			if(currencyList.get(i).getCode().equalsIgnoreCase(code)){
				name = currencyList.get(i).getName();
				break;
			}
		}

		return name;
	}

}
