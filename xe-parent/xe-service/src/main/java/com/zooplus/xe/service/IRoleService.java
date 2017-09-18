package com.zooplus.xe.service;

import java.util.List;

import com.zooplus.xe.model.Role;

public interface IRoleService {
	public Role findRoleByName(final String role);
	public Role findRoleById(final int roleId);
	public List<Role> findAllRoles();
}
