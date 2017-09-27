package com.rps.xe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rps.xe.model.Role;
import com.rps.xe.repository.IRoleRepository;

@Service("roleService")
public class RoleServiceImpl implements IRoleService{
	
	@Autowired
    private IRoleRepository roleRepository;

	@Override
	public Role findRoleByName(final String role) {
		return roleRepository.findByRole(role);
	}

	@Override
	public Role findRoleById(int roleId) {
		return roleRepository.findOne(roleId);
	}

	@Override
	public List<Role> findAllRoles() {
		return (List<Role>) roleRepository.findAll();
	}

}
