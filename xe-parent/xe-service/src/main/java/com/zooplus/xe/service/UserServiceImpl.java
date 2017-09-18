package com.zooplus.xe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zooplus.xe.model.User;
import com.zooplus.xe.repository.IRoleRepository;
import com.zooplus.xe.repository.IUserRepository;



@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	@Autowired
    private IRoleRepository roleRepository;

	@Override
	public User findUserByEmail(final String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User saveUser(final User user) {
		return userRepository.save(user);
	}

	/*@Override
	public UserDetails loadUserByUsername(final String userName)
			throws UsernameNotFoundException {
		User userInfo = findUserByEmail(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRoles().toString());
		UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(userInfo.getEmail(),
				userInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}*/

}
