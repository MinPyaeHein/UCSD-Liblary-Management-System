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
import com.coder.form.PositionForm;
import com.coder.form.PositionRegisterForm;
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
@Repository("positionService")
public class PositionServic {
	@Autowired
	private PositionDao positionDao;
		public void preparePositionRegister(PositionRegisterForm positionRegisterForm){
		PositionForm positionForm=positionRegisterForm.getPositionForm();
			if(positionForm!=null){
			int id=positionRegister(positionRegisterForm);
			positionForm=new PositionForm();
			}
			positionRegisterForm.setPositions(this.positionDao.getPositions());
		
	}
	private int positionRegister(PositionRegisterForm positionRegisterForm){
		Position position=new Position();
		PositionForm positionForm=positionRegisterForm.getPositionForm();
		position.setPositionName(positionForm.getPositionName());
		position.setShortTerm(positionForm.getShortTerm());
		int id=this.positionDao.savePosition(position);
		return id; 
	}

}
