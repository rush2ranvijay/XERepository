package com.rps.xe.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rps.xe.model.User;

@Repository("userRepository")
public interface IUserRepository extends CrudRepository<User, Long>{

	public User findByEmail(final String email);
	
	@Override
	public <S extends User> S save(S user);
	
}
