package com.zooplus.xe.restclient;

import com.zooplus.xe.model.CurrencyQuery;
import com.zooplus.xe.restclient.model.CurrencyExchange;


public interface ICurrencyLayerClient {

	public static final String ENDPOINT_LIST="list";
	public static final String ENDPOINT_LIVE="live";
	public static final String ENDPOINT_HISTORICAL="historical";
	public static final String ENDPOINT_CONVERT="convert";
	
	CurrencyExchange getCurrencyQuotes(final String endpoint);
	
	CurrencyQuery convertCurrency(final CurrencyQuery currencyQuery);
	
}
