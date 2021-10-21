package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Book;
import com.coder.model.Member;
import com.coder.model.Role;
import com.coder.model.Student;
import com.coder.model.Teacher;
@Repository("roleDoa")
public class RoleDao extends AbstractDao<Integer,Role>{
	
	public Integer saveRole(Role role)
	{
	return (Integer)super.persist(role);
	}
	public Role getRoleById(int id){
		Role role=super.criteriaQuerryGetObjectById(id,"roleId");
		return role;
	}
  
public void  updateRole(Role role)
{
super.update(role);
}
public void  deleteRole(Role role)
{
super.delete(role);
}
public List<Role> getRoles() {
List<Role> roles=(List<Role>)super.getAllEntity();
	return roles;
}



}
