package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Book;
import com.coder.model.Department;
import com.coder.model.Position;
import com.coder.model.Student;
import com.coder.model.Teacher;
@Repository("departmentDao")
public class DepartmentDao extends AbstractDao<Integer,Department>{
	
	public Integer saveDepartment(Department department)
	{
	return (Integer)super.persist(department);
    }
	
	public Department getDepartmentById(int id){
		Department position=super.criteriaQuerryGetObjectById(id,"departmentId");
	return position;}
  
public void  updateDepartment(Department department)
{
super.update(department);

}
public void  deleteDepartment(Department department)
{
super.delete(department);

}
public List<Department> getDepartments() {
	List<Department> departments=(List<Department>)super.getAllEntity();
		return departments;
	}

}
