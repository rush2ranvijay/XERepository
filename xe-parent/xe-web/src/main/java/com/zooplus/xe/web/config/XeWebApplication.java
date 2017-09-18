/**
 * 
 */
package com.zooplus.xe.web.config;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.zooplus.xe.XeDataApplication;
import com.zooplus.xe.XeServiceApplication;
import com.zooplus.xe.model.Role;
import com.zooplus.xe.model.User;
import com.zooplus.xe.restclient.ICurrencyLayerClient;
import com.zooplus.xe.service.IRoleService;
import com.zooplus.xe.service.IUserService;
import com.zooplus.xe.web.controller.MainController;

/**
 * @author ranvsing
 * 
 */
@Configuration
@ComponentScan(basePackages = "com.zooplus.xe")
@Import({ XeSecurityConfiguration.class, XeMvcConfig.class })
@EnableAutoConfiguration
public class XeWebApplication extends SpringBootServletInitializer implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	ICurrencyLayerClient currencyLayerClient;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(XeWebApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(XeDataApplication.class,
				XeServiceApplication.class, XeWebApplication.class);
	}
	@Transactional(readOnly = true)
	@Override
	public void run(String... arg0) throws Exception {
		User user =new User();
		user.setFirstName("Ranvijay Pratap");
		user.setLastName("Singh");
		user.setStreet("Koblezer Str 41");
		user.setEmail("xe@sharklasers.com");
		user.setZipCode("60327");
		user.setCity("Frankfurt");
		user.setCountry("Germany");
		user.setBirthday(new Date());
		user.setPassword(bCryptPasswordEncoder.encode("test1"));
		user.setConfirmPassword(bCryptPasswordEncoder.encode("test1"));
		user.setActive(1);
		Role userRole = roleService.findRoleByName("ADMIN");
	    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		User adminUser = userService.saveUser(user);
		logger.info("Admin User [ "+adminUser.getFirstName()+" "+adminUser.getLastName()  +"( "+adminUser.getEmail()+" )] Created Successfully!");
		
	}

}
