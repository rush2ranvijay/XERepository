package com.rps.xe.restclient;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.rps.xe.model.CurrencyQuery;
import com.rps.xe.restclient.model.CurrencyExchange;

@Component("currencyLayerClient")
public class CurrencyLayerClientImpl implements ICurrencyLayerClient {
	
	private static final Logger logger = LoggerFactory.getLogger(CurrencyLayerClientImpl.class);
	public static final String USD="USD";
	
	@Autowired
	RestOperations restOperations;

	private final String baseUrl;
	private final String accessKey;


	public CurrencyLayerClientImpl(
			@Value("${currency.service.baseUrl}") final String baseUrl,
			@Value("${currency.service.access_key}") final String accessKey) {
			this.baseUrl = baseUrl;
			this.accessKey = accessKey;
	}

	@Override
	public CurrencyExchange getCurrencyQuotes(final String endpoint) {
		final String restUrl = baseUrl + endpoint + "?access_key=" + accessKey;
		CurrencyExchange currencyExchange = restOperations.getForObject(restUrl, CurrencyExchange.class);
		return currencyExchange;
	}

	@Override
	public CurrencyQuery convertCurrency(final CurrencyQuery currencyQuery) {
		final String restUrl = baseUrl + ICurrencyLayerClient.ENDPOINT_LIVE
				+ "?access_key=" + accessKey + "&currencies=" + currencyQuery.getFromCurrency()
				+ "," + currencyQuery.getToCurrency();
		CurrencyExchange currencyExchange = restOperations.getForObject(restUrl, CurrencyExchange.class);
		BigDecimal usdFromCurrency = currencyExchange.getQuotes().get(USD + currencyQuery.getFromCurrency());
		BigDecimal usdToCurrency = currencyExchange.getQuotes().get(USD + currencyQuery.getToCurrency());
		logger.info("[ "+ USD +" -> "+ currencyQuery.getFromCurrency()+" ] = " + usdFromCurrency);
		logger.info("[ "+ USD +" -> "+ currencyQuery.getToCurrency()+" ] = " + usdToCurrency);
		
		BigDecimal baseQuote =  usdToCurrency.divide(usdFromCurrency, 5 , RoundingMode.HALF_UP);
		BigDecimal convertedAmount = baseQuote.multiply(new BigDecimal(currencyQuery.getEnterAmount()));
		currencyQuery.setConvertedAmount(convertedAmount);
		return currencyQuery;
	}
}
