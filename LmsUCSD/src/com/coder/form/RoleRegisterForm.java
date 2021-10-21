package com.coder.form;

import java.util.List;

import com.coder.model.Role;

public class RoleRegisterForm {
private RoleForm roleForm;
private List<Role> roles;
public RoleForm getRoleForm() {
	return roleForm;
}
public void setRoleForm(RoleForm roleForm) {
	this.roleForm = roleForm;
}
public List<Role> getRoles() {
	return roles;
}
public void setRoles(List<Role> roles) {
	this.roles = roles;
}
}
