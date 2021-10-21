package com.coder.form;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.model.Admin;

public class AdminRegisterform {
private AdminForm adminForm=null;
private List<Admin> admins;
private Map<String,String> mapPositions=new HashedMap<String,String>();
private Map<String,String> mapRoles=new HashedMap<String,String>();
public AdminForm getAdminForm() {
	return adminForm;
}
public void setAdminForm(AdminForm adminForm) {
	this.adminForm = adminForm;
}
public Map<String, String> getMapPositions() {
	return mapPositions;
}
public void setMapPositions(Map<String, String> mapPositions) {
	this.mapPositions = mapPositions;
}
public Map<String, String> getMapRoles() {
	return mapRoles;
}
public void setMapRoles(Map<String, String> mapRoles) {
	this.mapRoles = mapRoles;
}
public List<Admin> getAdmins() {
	return admins;
}
public void setAdmins(List<Admin> admins) {
	this.admins = admins;
}
}
