package com.zooplus.xe.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zooplus.xe.model.Role;
import com.zooplus.xe.model.User;
import com.zooplus.xe.restclient.ICurrencyLayerClient;
import com.zooplus.xe.service.ICurrencyQueryService;
import com.zooplus.xe.service.IRoleService;
import com.zooplus.xe.service.IUserService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
	
	static List<Locale> countryList = new ArrayList<>();
	static{
        final String[] locales = Locale.getISOCountries();
        for (final String countryCode : locales) {
    		Locale obj = new Locale("", countryCode);
    		countryList.add(obj);
    	}
    }

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	public @ModelAttribute("countryList")
	List<Locale> setupCountryList() {
		return countryList;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView setupRegistrationForm(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (!StringUtils.equals(user.getPassword(), user.getConfirmPassword())) {
			bindingResult
					.rejectValue("confirmPassword", "error.confirmPassword",
							"Password and Confirm password is not match!");
		}
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActive(1);
			Role userRole = roleService.findRoleByName("USER");
		    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully, <a href='/login'>click here</a> to login");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value={"/access-denied"}, method = RequestMethod.GET)
	public ModelAndView accessDenied(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errorMsg","You are not authorized for the requested data.");
		modelAndView.setViewName("access-denied");
		return modelAndView;
	}

}
