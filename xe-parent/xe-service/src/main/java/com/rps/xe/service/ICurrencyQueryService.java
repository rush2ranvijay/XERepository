package com.rps.xe.service;

import java.util.List;

import com.rps.xe.model.CurrencyQuery;

public interface ICurrencyQueryService{
	
	public CurrencyQuery saveCurrencyQuery(final CurrencyQuery currencyQuery);
	
	public List<CurrencyQuery> find(final String email);
}
