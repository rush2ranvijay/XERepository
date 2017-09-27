package com.rps.xe.service;

import com.rps.xe.model.User;

public interface IUserService{
	public User findUserByEmail(final String email);
	public User saveUser(final User user);
}
