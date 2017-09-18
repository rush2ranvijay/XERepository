package com.zooplus.xe.service;

import com.zooplus.xe.model.User;

public interface IUserService{
	public User findUserByEmail(final String email);
	public User saveUser(final User user);
}
