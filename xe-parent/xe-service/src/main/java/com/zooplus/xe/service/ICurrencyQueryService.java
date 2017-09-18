package com.zooplus.xe.service;

import java.util.List;

import com.zooplus.xe.model.CurrencyQuery;

public interface ICurrencyQueryService{
	
	public CurrencyQuery saveCurrencyQuery(final CurrencyQuery currencyQuery);
	
	public List<CurrencyQuery> find(final String email);
}
