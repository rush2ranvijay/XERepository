package com.zooplus.xe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zooplus.xe.model.CurrencyQuery;
import com.zooplus.xe.repository.ICurrencyQueryRepository;

@Service("currencyQueryService")
public class CurrencyQueryServiceImpl implements ICurrencyQueryService {

	@Autowired
    private ICurrencyQueryRepository currencyQueryRepository;
	
	@Override
	public CurrencyQuery saveCurrencyQuery(final CurrencyQuery currencyQuery) {
		return currencyQueryRepository.save(currencyQuery);
	}

	@Override
	public List<CurrencyQuery> find(String email) {
		Pageable topTen = new PageRequest(0, 10);
		List<CurrencyQuery> topTenQueries = currencyQueryRepository.find(email, topTen);
		return topTenQueries;
	}


}
