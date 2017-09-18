package com.zooplus.xe;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.zooplus.xe.model.Role;
import com.zooplus.xe.repository.IRoleRepository;
import com.zooplus.xe.repository.IUserRepository;


@SpringBootApplication
public class XeDataApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(XeDataApplication.class);
	
	@Autowired
	IRoleRepository roleRepository;
	@Autowired
	IUserRepository userRepository;

	@Transactional(readOnly = true)
	@Override
	public void run(String... arg0) throws Exception {
		Role admin = new Role(1, "ADMIN");
		Role roleUser = new Role(2, "USER");
		roleRepository.save(admin);roleRepository.save(roleUser);
		logger.info("ADMIN and USER roles has been created");
	}

}
