package com.rps.xe.restclient;

import com.rps.xe.restclient.model.CurrencyExchange;
import com.rps.xe.model.CurrencyQuery;


public interface ICurrencyLayerClient {

	public static final String ENDPOINT_LIST="list";
	public static final String ENDPOINT_LIVE="live";
	public static final String ENDPOINT_HISTORICAL="historical";
	public static final String ENDPOINT_CONVERT="convert";
	
	CurrencyExchange getCurrencyQuotes(final String endpoint);
	
	CurrencyQuery convertCurrency(final CurrencyQuery currencyQuery);
	
}
