package com.zooplus.xe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zooplus.xe.model.Role;

@Repository("roleRepository")
public interface IRoleRepository extends CrudRepository<Role, Integer>{
	
	Role findByRole(final String role);
	
	@Override
	public <S extends Role> S save(S arg0);
}
