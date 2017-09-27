package com.rps.xe.service;

import java.util.List;

import com.rps.xe.model.Role;

public interface IRoleService {
	public Role findRoleByName(final String role);
	public Role findRoleById(final int roleId);
	public List<Role> findAllRoles();
}
