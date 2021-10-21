package com.coder.servic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AcademicYearDao;
import com.coder.dao.BookDao;
import com.coder.dao.BookEditionDao;
import com.coder.dao.DepartmentDao;
import com.coder.dao.GreadDao;
import com.coder.dao.MajorDao;
import com.coder.dao.PositionDao;
import com.coder.dao.ShellDao;
import com.coder.dao.StudentDao;
import com.coder.dao.TeacherDao;
import com.coder.form.BookForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.DepartmentForm;
import com.coder.form.DepartmentRegisterForm;
import com.coder.form.StudentForm;
import com.coder.form.StudentRegisterForm;
import com.coder.form.TeacherForm;
import com.coder.form.TeacherRegisterForm;
import com.coder.model.AcademicYear;
import com.coder.model.Book;
import com.coder.model.BookEdition;
import com.coder.model.Department;
import com.coder.model.Gread;
import com.coder.model.Major;
import com.coder.model.Position;
import com.coder.model.Shell;
import com.coder.model.Student;
import com.coder.model.Teacher;
import com.coder.util.DateFormat;
@Service
@Repository("departmentService")
public class DepartmentServic {
	@Autowired
	private DepartmentDao departmentDao;
		public void prepareDepartmentRegister(DepartmentRegisterForm departmentRegisterForm){
		DepartmentForm departmentForm=departmentRegisterForm.getDepartmentForm();
			if(departmentForm!=null){
			int id=departmentRegister(departmentRegisterForm);
			departmentForm=new DepartmentForm();
			}
	    departmentRegisterForm.setDepartments(this.departmentDao.getDepartments());
	}
	private int departmentRegister(DepartmentRegisterForm departmentRegisterForm){
		Department department=new Department();
		DepartmentForm departmentForm=departmentRegisterForm.getDepartmentForm();
		department.setDepartmentName(departmentForm.getDepartmentName());
		department.setShortTerm(departmentForm.getShortTerm());
		int id=this.departmentDao.saveDepartment(department);
		return id; 
	}

}
