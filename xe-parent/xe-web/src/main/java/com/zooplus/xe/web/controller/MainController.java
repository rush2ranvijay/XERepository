package com.zooplus.xe.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zooplus.xe.model.CurrencyQuery;
import com.zooplus.xe.model.User;
import com.zooplus.xe.restclient.ICurrencyLayerClient;
import com.zooplus.xe.restclient.model.CurrencyExchange;
import com.zooplus.xe.service.ICurrencyQueryService;
import com.zooplus.xe.service.IRoleService;
import com.zooplus.xe.service.IUserService;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	ICurrencyQueryService currencyQueryService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	ICurrencyLayerClient currencyLayerClient;
	
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public ModelAndView mainPage(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName());
		List<CurrencyQuery> topCurrencyQueries= currencyQueryService.find(auth.getName());
		CurrencyQuery currencyQuery = new CurrencyQuery();
		modelAndView.addObject("currencyQuery", currencyQuery);
		modelAndView.addObject("topCurrencyQueries", topCurrencyQueries);
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	public @ModelAttribute("currencyList")
	CurrencyExchange setupcurrencyList() {
		return currencyLayerClient.getCurrencyQuotes(ICurrencyLayerClient.ENDPOINT_LIST);
	}
	
	
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public ModelAndView convertCurrency(
			@Valid @ModelAttribute("currencyQuery") CurrencyQuery currencyQuery,
			BindingResult bindingResult) {
		
		final ModelAndView modelAndView = new ModelAndView();
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final User user = userService.findUserByEmail(auth.getName());
		if (bindingResult.hasErrors()) {
			logger.info(new StringBuilder("CurrencyConverter [ ").append(user.getEmail()).append(" ] : Form Vailidation Error : ").toString());
			refreshCurrencyQueriesData(modelAndView, auth, user);
			modelAndView.setViewName("main");
		} else {
			currencyLayerClient.convertCurrency(currencyQuery);
			logger.info(new StringBuilder("CurrencyConverter [ ").append(user.getEmail())
					.append(" ] : ").append(currencyQuery.getEnterAmount())
					.append(" ").append(currencyQuery.getFromCurrency())
					.append(" = ").append(currencyQuery.getConvertedAmount())
					.append(" ").append(currencyQuery.getToCurrency()).toString());
			currencyQuery.setUser(user);
			final CurrencyQuery dbCurrencyQuery = currencyQueryService.saveCurrencyQuery(currencyQuery);
			logger.info(new StringBuilder("CurrencyConverter [ ")
					.append(dbCurrencyQuery.getUser().getEmail())
					.append(" ] : Saved Currency Query with ID : ").toString());
			refreshCurrencyQueriesData(modelAndView, auth, user);
		}
		return modelAndView;
	}

	/**
	 * 
	 * @param modelAndView
	 * @param auth
	 * @param user
	 */
	private void refreshCurrencyQueriesData(ModelAndView modelAndView,
			Authentication auth, User user) {
		List<CurrencyQuery> topCurrencyQueries= currencyQueryService.find(auth.getName());
		logger.info(new StringBuilder("CurrencyConverter [ ")
		.append(user.getEmail())
		.append(" ] : Refresh Last Saved Currency Queris").toString());
		modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName());
		modelAndView.addObject("topCurrencyQueries", topCurrencyQueries);
	}

}
